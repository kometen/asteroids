package no.gnome.asteroids;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.cdimascio.dotenv.Dotenv;
import no.gnome.asteroids.pojo.Asteroid;
import no.gnome.asteroids.pojo.CloseApproachData;
import no.gnome.asteroids.pojo.ClosestAsteroids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class SearchController {

    private final RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    public SearchController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    /*

     TODO:
       Add backend to store retrieved data from NASA.
       Add caching (caffeine).
       Add endpoint to get largest object in a year.

     */

    @RequestMapping(value = "/closest/{date}/{interval}", method = RequestMethod.GET)
    public List<ClosestAsteroids> welcome(
            @PathVariable("date")String date,
            @PathVariable("interval")int interval
            ) {

        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("api_key");
        String nasaUrl = "https://api.nasa.gov/neo/rest/v1/feed";

        try {
            date = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE).toString();
        } catch (DateTimeException e) {
            date = LocalDate.now().toString();
            logger.error("Unable to parse date: ", e);
        }

        try {
            interval = Integer.parseInt(String.valueOf(interval));
            if ((interval < 0) || (interval > 7)) {
                interval = 7;
            }
        } catch (NumberFormatException e) {
            logger.error("Unable to parse interval: ", e);
        }

        LocalDate toDate = LocalDate.parse(date).plusDays(interval);
        logger.info("from date: {}, to date: {}, interval: {}", date, toDate, interval);

        String url = nasaUrl + "?start_date=" + date + "&end_date" + toDate + "&api_key=" + apiKey;
        String result = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        assert jsonNode != null;
        JsonNode nearEarthObjects = jsonNode.get("near_earth_objects");
        Map<Float, Asteroid> closestAsteroids = getClosestAsteroids(nearEarthObjects, mapper);

        return addAsteroidsToList(closestAsteroids);
    }

    private Map<Float, Asteroid> getClosestAsteroids(JsonNode nearEarthObjects, ObjectMapper mapper) {
        var closestAsteroids = new TreeMap<Float, Asteroid>();

        for (JsonNode asteroidNodes : nearEarthObjects) {
            // https://mkyong.com/java/jackson-tree-model-example/
            if (asteroidNodes.isArray()) {
                for (JsonNode asteroidNode : asteroidNodes) {
                    Asteroid asteroid = null;
                    try {
                        asteroid = mapper.treeToValue(asteroidNode, Asteroid.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    assert asteroid != null;
                    CloseApproachData[] closeApproachData = asteroid.getCloseApproachData();
                    for (CloseApproachData approachData : closeApproachData) {
                        closestAsteroids.put(Float.parseFloat(approachData.getMissDistance().getKilometers()), asteroid);
                        if (closestAsteroids.size() > 10) {
                            closestAsteroids.pollLastEntry();
                        }
                        //logger.info("approach-date: {}, miss-distance kilometers: {}", approachData.getCloseApproachDate(), approachData.getMissDistance().getKilometers());
                    }
                }
            }
        }
        return closestAsteroids;
    }

    private List<ClosestAsteroids> addAsteroidsToList(Map<Float, Asteroid> closestAsteroids) {
        List<ClosestAsteroids> asteroidsList = new ArrayList<>();
        int index = 1;
        for (Map.Entry<Float, Asteroid> asteroidEntry : closestAsteroids.entrySet()) {
            //logger.info("distance: {}, asteroid: {}", asteroidEntry.getKey(), asteroidEntry.getValue());
            asteroidsList.add(new ClosestAsteroids(index, asteroidEntry.getKey(), asteroidEntry.getValue()));
            index++;
        }
        return asteroidsList;
    }
}

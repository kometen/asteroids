package no.gnome.asteroids;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    public static String welcome() {
        return "Search for asteroids passing earth within a timeframe";
    }
}

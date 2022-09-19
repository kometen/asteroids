This will show the ten closest asteroids within two dates.

Build jar-file

```
mvn clean package
```

Build docker-image

```
docker build -t asteroids:latest .
```

Run docker-image

```
docker run -p8080:8080 asteroids:latest   
```

This is an MVP fetching asteroids passing earth within two dates. NASA limits the
days to seven. The REST-endpoint is /closest/{date}/{interval}. Date is an ISO-formatted
date in the format yyyy-MM-dd, ie. 1967-10-28. If interval is outside the range 1-7 it
will default to 7.

Goto https://api.nasa.gov/ and register a api-key. Put it in a file called .env
(dot env) and put this file at the root of this project. Don't add this file
to this repository since it can contain secrets or other information related
to your account.

Add the following line:

```api_key=foo-bar-baz```

Then start the application and open a browser to http://localhost:8080/closest/{date}/{interval}

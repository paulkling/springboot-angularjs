# springboot-angularjs
A spring boot application that has angularjs, twitter bootstrap, and swagger in it


###To compile: 
```
	gradlew build
	./gradlew build
```

###To run:
``` 
	gradlew bootRun
	java -jar nameOfJar.jar
	tomacat deploy war to webapps and start tomcat
```

###To build docker image
```
	docker build -t paulkling/bgr .
```


###Docker push to public repo
```
	docker login
	docker push paulkling/bgr
```

###To run
```
	docker run -d -p 8080:8080 paulkling/bgr
```

[Using dns nginx proxy jwilder-proxy](https://github.com/jwilder/nginx-proxy)
```
	docker run -e VIRTUAL_HOST=app.streamdashboard.com -d -p 8080:8080 paulkling/bgr
```

###After push and run with nginx proxy
http://app.streamdashboard.com


###misc
/c/Users/Paul/Documents/GitHub/springboot-angularjs


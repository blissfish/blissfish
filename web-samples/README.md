# Spring Boot Hello World Example with JSP

## Guide
	https://github.com/blissfish/blissfish.git 

## What you'll need
- JDK 1.7 or later

## Stack
- Tomcat7
- Java
- JAX RS/Jersey

## Run
/apache-tomcat7-8080/bin/startup.bat
/apache-tomcat7-9090/bin/startup.bat

http://localhost:9090/web/api/service/{param}

http://localhost:9090/web/index.html

## Check for CORS headers (actually only `Access-Control-Allow-Origin: *` is used)
- Access-Control-Allow-Origin: *
- Access-Control-Allow-Headers: origin, content-type, accept, authorization
- Access-Control-Allow-Credentials: true
- Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS, HEAD
- Access-Control-Max-Age: 1209600

curl -i http://localhost:9090/api/services 

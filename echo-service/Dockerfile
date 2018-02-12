#FROM openjdk:8u121-jdk-alpine
FROM openjdk:8-jdk-alpine

MAINTAINER blissfish <mark.evertz@gmx.de>

# Keep consistent with build.gradle 
ENV APP_JAR_NAME echo-service
ENV APP_JAR_VERSION 0.0.1-SNAPSHOT

# Install curl
RUN apk --update add curl bash && \
	rm -rf /var/cache/apk/*
	
RUN mkdir /app

ADD target/${APP_JAR_NAME}-${APP_JAR_VERSION}.jar /app/app.jar 
#ADD run.sh /app/
#RUN chmod +x /app/run.sh 

WORKDIR /app

EXPOSE 8080


CMD ["/bin/echo", "hello world"]
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar


#ENTRYPOINT ["/bin/bash","-c"]
#CMD ["/app/run.sh"]
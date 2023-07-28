FROM openjdk:11-jdk
WORKDIR /app
COPY target/yajp-1.jar /app/yajp-1.jar
ENTRYPOINT ["java","-jar","/app/yajp-1.jar"]

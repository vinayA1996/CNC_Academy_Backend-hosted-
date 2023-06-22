#FROM openjdk
#WORKDIR usr/lib
#ADD ./target/cnc_academy-0.0.1-SNAPSHOT.jar /usr/lib/cnc_academy-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","cnc_academy-0.0.1-SNAPSHOT.jar"]

#--------------------------------------
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests
#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/cnc_academy-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
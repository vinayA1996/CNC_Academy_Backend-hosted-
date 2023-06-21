#FROM openjdk
#WORKDIR usr/lib
#ADD ./target/cnc_academy-0.0.1-SNAPSHOT.jar /usr/lib/cnc_academy-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","cnc_academy-0.0.1-SNAPSHOT.jar"]
FROM openjdk:11-jdk-slim
COPY --from=build /target/cnc_academy-0.0.1-SNAPSHOT.jar cnc_academy-0.0.1-SNAPSHOT.jar
# ENV PORT=8080
EXPOSE 8084
ENTRYPOINT ["java","-jar","cnc_academy-0.0.1-SNAPSHOT.jar"]
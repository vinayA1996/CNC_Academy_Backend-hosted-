FROM openjdk
WORKDIR usr/lib
ADD ./target/cnc_academy-0.0.1-SNAPSHOT.jar /usr/lib/cnc_academy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","cnc_academy-0.0.1-SNAPSHOT.jar"]
FROM adoptopenjdk/openjdk11
LABEL "Description" = "Aggregate Service"
COPY target/*.jar aggregateservice.jar
ENTRYPOINT ["java", "-jar", "/aggregateservice.jar"]

FROM openjdk:11.0-oracle
COPY "./target/ms-card-0.0.1-SNAPSHOT.jar" "mscardapp.jar"
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "mscardapp.jar"]
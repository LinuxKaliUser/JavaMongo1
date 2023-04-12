FROM openjdk:11

EXPOSE 0

WORKDIR /src/main/java

COPY target/CalculationHomeCost.jar .

CMD ["java", "-jar", "CalculationHomeCost.jar"]
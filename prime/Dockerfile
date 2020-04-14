FROM maven:3.6.3-jdk-14 as build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean install package -DskipTests

FROM openjdk:14
COPY --from=build /usr/src/app/target/prime-1.0.jar /usr/app/prime-1.0.jar
ENTRYPOINT ["java","-jar","/usr/app/prime-1.0.jar"]
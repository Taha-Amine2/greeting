FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml . 
COPY src ./src

RUN mvn clean package -DskipTests

RUN mv /app/target/ArchiJEEWSRestTP-1.0-SNAPSHOT.war /app/target/ROOT.war

FROM tomcat:10.0-jdk17 AS tomcat

COPY --from=build /app/target/ROOT.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]

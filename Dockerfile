FROM maven:3.8.3-openjdk-17 AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests

FROM openjdk:17
RUN mkdir /app
COPY --from=build /project/target/stdencdec*.jar /app/stdencdec.jar
WORKDIR /app
CMD "java" "-jar" "stdencdec.jar"
EXPOSE 8081
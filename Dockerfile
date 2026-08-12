FROM eclipse-temurin:11-jdk-alpine AS build

WORKDIR /workspace
COPY . .
RUN sed -i 's/\r$//' gradlew \
    && chmod +x gradlew \
    && ./gradlew test bootJar --no-daemon

FROM eclipse-temurin:8-jre-alpine

EXPOSE 8080

WORKDIR /usr/app
COPY --from=build /workspace/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

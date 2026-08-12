FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /workspace
COPY gradle gradle
COPY gradlew build.gradle settings.gradle ./
RUN sed -i 's/\r$//' gradlew && chmod +x gradlew && ./gradlew --no-daemon dependencies
COPY src src
RUN ./gradlew --no-daemon build

FROM eclipse-temurin:17-jre-alpine

RUN addgroup -S app && adduser -S app -G app
WORKDIR /app
COPY --from=build /workspace/build/libs/*.jar app.jar

EXPOSE 8080
USER app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

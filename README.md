# Java App

A small Spring Boot service that exposes its current status as JSON.

## Requirements

- Java 17 or newer
- Docker (optional)

## Run locally

On macOS or Linux:

```sh
./gradlew bootRun
```

On Windows:

```powershell
.\gradlew.bat bootRun
```

Then open <http://localhost:8080/status>. The response is:

```json
{"application":"java-app","status":"OK"}
```

## Test and build

```sh
./gradlew build
```

## Run with Docker

```sh
docker build -t java-app .
docker run --rm -p 8080:8080 java-app
```

## Continuous integration

GitHub Actions builds and tests every push and pull request targeting `master`.
Pushes to `master` also publish `java-app` to Docker Hub using the repository
secrets `DOCKER_USERNAME` and `DOCKER_ACCESS_TOKEN`.
    

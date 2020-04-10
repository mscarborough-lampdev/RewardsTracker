# Rewards Tracker

This application provides a test data set and demonstrates calculating customer reward points according to provided business logic.

## Getting Started

Clone the project: git clone https://github.com/mscarborough-lampdev/RewardsTracker.git
Navigate to the project directory.


### Prerequisites

```
Java JRE version 1.8 or greater
Maven 3.5.0 or greater
```

### Installing

```
On linux systems, execute the following command: ./mvnw spring-boot:run
```

```
Alternatively, you can use maven to create a runnable JAR file: mvn clean install
When Maven completes, navigate into the 'target' directory and launch the app: java --jar RewardsTracker-0.0.1-SNAPSHOT.jar
```

Once the application is running, you can use an HTTP client and perform the following call:
GET http://localhost:8080/report

When running, see also the documentation: http://localhost:8080/swagger-ui.html#!/tracker-controller/getReportUsingGET

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **M. Scarborough** - *Initial work* - [mscarborough-lampdev](https://github.com/mscarborough-lampdev)

## License

This toy project is proprietary and not for reuse without explicit written permission.

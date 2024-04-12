# notification prototype

This is a microservice prototype generated using WeDAA, you can find documentation and help at [WeDAA Docs](https://www.wedaa.tech/docs/introduction/what-is-wedaa/)

## Prerequisites

- jdk version >= 17

## Project Structure

```
├── src/
    ├── main/
        ├── docker (contains docker compose files for external components based on architecture design)
        ├── java/notification/
        └──  resources  (configuration properties)
    └── test/ (testcases for prototype)
        ├── java/notification/
        └──  resources
├── target/
├── checkstyle.xml
├── comm.yo-rc.json (generator configuration file for communications)
├── COMMUNICATION.md (Communication documentation)
├── mvnw
├── mvnw.cmd
├── package.json
├── pom.xml
├── README.md (Project documentation)
└── sonar-project.properties
```

## Dependencies

This application is configured to work with external component(s).

Docker compose files are provided for the same to get started quickly.

Component details:

- Database: `npm run docker:db:up`
- RabbitMQ message broker: `npm run docker:rabbitmq:up`

On launch, notification will refuse to start if it is not able to connect to any of the above component(s).

## Get Started

The below cmd will install the required dependencies and run the prototype in local machine.

Run the prototype locally: `./mvnw`

Open [http://localhost:8083/management/health/readiness](http://localhost:8083/management/health/readiness) to view it in your browser.

You could see the below response in your browser:

```
{
  "status": "UP"
}
```

## Containerization

Docker image will be built with the prototype name.

- Build the docker image: `npm run java:docker`

Start the container: `docker run -d -p 8083:8083 notification:latest`

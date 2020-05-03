# polyglot-micronaut-express

This is a proof of concept for calling a Micronaut bean directly from a Node.js
application. The Node.js application uses Express for routing and Pug for HTML
templating.

The project is still a bit unpolished, I might fix these issues later:

1. The structure of the project is a bit messy
1. The integration still is synchronous
1. No styling has been applied

## Requirements

- GraalVM CE 20.0 (or later) based on Java 11

GraalVM CE 20.0 does not offer a Node.js implementation on Windows.

## Setup

In the root of the project run the following command: `./gradlew assemble`
In the folder `src/main/node` run the following commands:
- `npm install`
- `npm run serve-jvm`

The application exposes the following URL's:

- <http://localhost:8080> Micronaut
- <http://localhost:3000/events> Node.js events overview page
- <http://localhost:3000/events/new> Node.js new event page

## Structure

This is a regular Micronaut Gradle project, but the folder `src/main/node`
contains the Node.js project.

The file [PolyglotEventService.js](src/main/node/polyglot/PolyglotEventService.js) integrates the Java code with the Node.js
code.

The file [EmbeddedApplication.java](src/main/java/ninckblokje/graalvm/pme/EmbeddedApplication.java) starts Micronaut and provides the ability
to retrieve beans from Micronaut's context.

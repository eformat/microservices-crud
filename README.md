# microservices-crud

Example project that leverages a quarkus template extension mechanism for microservices.

- https://github.com/eformat/quarkus-microservice-template-demo

The template can be managed, and includes any shared code and dependencies.

In this example, it exposes:

- postgres database (using quarkus dev services)
- JPA hibernate ORM
- rest api exposing Movies

## Prerequisites

[Build and Install the extension FIRST](https://github.com/eformat/quarkus-microservice-template-demo)

```xml
        <dependency>
            <groupId>me.escoffier.microservice</groupId>
            <artifactId>quarkus-microservice-deployment</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>
```

[If using podman, make sure to set DOCKER_HOST correctly](https://quarkus.io/blog/quarkus-devservices-testcontainers-podman) for quarkus dev services.

## Run It

Run the example. This will fire up a postgres container.

```bash
cd movies
mvn quarkus:dev
```

Test it out:

```bash
$ curl -s http://localhost:8080/api | jq .
[
  {
    "id": 2,
    "title": "Batman Returns"
  },
  {
    "id": 3,
    "title": "Driving Miss Daisy"
  },
  {
    "id": 1,
    "title": "Shawshank Redemption"
  }
]
```


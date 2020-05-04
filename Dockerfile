FROM oracle/graalvm-ce:20.0.0-java11

EXPOSE 3000 8080

RUN mkdir /polyglot-micronaut-express

COPY build/libs/polyglot-micronaut-express-*-all.jar /polyglot-micronaut-express/build/libs/
COPY src/main/node/ /polyglot-micronaut-express/src/main/node/

WORKDIR /polyglot-micronaut-express/src/main/node

CMD [ "npm", "run", "serve-jvm" ]

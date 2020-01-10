FROM java:8-jdk-alpine

COPY ./target/haneefboot-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

EXPOSE 8200

RUN sh -c 'touch haneefboot-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","haneefboot-0.0.1-SNAPSHOT.jar"]
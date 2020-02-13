#FROM java:8-jdk-alpine
FROM maven:3.6.3-ibmjava-8-alpine

RUN mvn clean install -DskipTests

COPY ./target/haneefboot-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

EXPOSE 8500

RUN sh -c 'touch haneefboot-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","haneefboot-0.0.1-SNAPSHOT.jar"]

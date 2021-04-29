FROM openjdk:8-jdk-buster

ENV SERVER_PORT 8888
EXPOSE $SERVER_PORT

RUN mkdir -p /software

ADD target/*.jar /app/api_tickets_vuelos.jar

CMD java -Dserver.port=$SERVER_PORT $JAVA_OPTS -jar /app/api_tickets_vuelos.jar
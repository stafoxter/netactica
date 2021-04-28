# INFORMACION

Aplicación desarrollada con Spring Boot que provee servicios Rest para registrar y obtener tickets de vuelos.

## Para iniciar la aplicación:
1. Compilar la aplicación: mvn clean install -DskipTests 
2. Ejecutar archivo jar compilado (\api-ticket-vuelo\target): java -jar ticket-0.0.1-SNAPSHOT.jar
3. Para ejecutar las pruebas: mvn test

## Deploy productivo
1. Modificar el ambiente de ejecución en el archivo "application.properties": spring.profiles.active=prod
2. Especificar la información del ambiente productivo en el archivo "application-prod.properties"

## Swagger
http://localhost:8888/netactica/swagger-ui.html#/

## Docker

	mvn clean install
	docker build -t api_tickets_vuelos .
	docker run --name container_api_tickets_vuelos -p 8888:8888 -t api_tickets_vuelos

# CONSIGNA 

##Crear Microservicio para administrar tiquetes de vuelo
###Requerimiento de Negocio

- Se necesita crear un servicio para administrar los tiquetes de vuelo. Debería poder Crear y Consultar.
- Un tiquete de vuelo tiene los siguientes parámetros:

	- Fecha de Salida
	- Fecha de Llegada
	- Ciudad Origen
	- Ciudad Destino	
	- Nombre Pasajero
	- Edad Pasajero
	- Tiene bodega de equipaje
	- Precio
	- Hora Salida
	- Hora Llegada

- El tiquete generará un ID (itineraryID) con el cual se podrá consultar.
- Dos endpoints. Uno para crear con los párametros del itinerario. Otro para consultar por el ID

##Tecnologías

	● Lenguaje de Programación Java o Kotlin
	● Utilizar el framework Spring Boot
	● Puede usar cualquier base de datos o repositorio de archivos, como el developer desee.
	● Debe ser REST API
	● Subir en un repositorio de código público, como Github.

##Tecnologías opcionales

	● Docker. Crear un dockerfile
	● Unit test. Crear pruebas unitarias.
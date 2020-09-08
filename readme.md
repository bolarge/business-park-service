# Business Park REST API

## Business Park is an aggregation, services provisioning and general business administration for micro, medium and small enterprises. It handles
##all related paperwork required to setup a business legally, provides services that support development and growth of businesses, provisions businesses
##into their various development and growth programmes, facilitates establishments of passage channels and network linkages that promotes visibility
##to these businesses.


## Running Business Park locally

### With maven command line https://github.com/bolarge/sme-portal-service.git
```
git clone https://github.com/sme-portal-service/sme-portal-service.git
cd sme-portal-service
./mvnw spring-boot:run
```

### With Docker
```
docker run -p 9966:9966 bolarge/sme-portal-service
```

You can then access sme-portal-service here: [http://localhost:9966/sme-portal-service/](http://localhost:9966/sme-portal-service/)

## Swagger REST API documentation presented here (after application start):
[http://localhost:9966/sme-portal-service/swagger-ui.html](http://localhost:9966/sme-portal-service/swagger-ui.html)

## Database configuration

In its default configuration, sme-portal-service uses an in-memory database (HSQLDB) which
gets populated at startup with data.
A similar setups is provided for MySql and PostgreSQL in case a persistent database configuration is needed.
To run sme-portal-service locally using persistent database, it is needed to change profile defined in application.properties file.

For MySQL database, it is needed to change param "hsqldb" to "mysql" in string
```
spring.profiles.active=hsqldb,spring-data-jpa
```
 defined in application.properties file.

Before do this, would be good to check properties defined in application-mysql.properties file.

```
spring.datasource.url = jdbc:mysql://localhost:3306/sme-portal-service?useUnicode=true
spring.datasource.username=sme-portal-service
spring.datasource.password=sme-portal-service 
spring.datasource.driver-class-name=com.mysql.jdbc.Driver 
spring.jpa.database=MYSQL
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=none
```      

You may also start a MySql database with docker:

```
docker run --name mysql-petclinic -e MYSQL_ROOT_PASSWORD=petclinic -e MYSQL_DATABASE=petclinic -p 3306:3306 mysql:5.7.8
```

For PostgeSQL database, it is needed to change param "hsqldb" to "postgresql" in string
```
spring.profiles.active=hsqldb,spring-data-jpa
```
 defined in application.properties file.

Before do this, would be good to check properties defined in application-postgresql.properties file.

```
spring.datasource.url=jdbc:postgresql://localhost:5432/sme-portal-service
spring.datasource.username=postgres
spring.datasource.password=sme-portal-service
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database=POSTGRESQL
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=none
```
You may also start a Postgres database with docker:

```
docker run --name postgres-sme-portal-service -e POSTGRES_PASSWORD=sme-portal-service -e POSTGRES_DB=petclinic -p 5432:5432 -d postgres:9.6.0
```

## Security configuration
In its default configuration, sme-portal-service doesn't have authentication and authorization enabled.

### Basic Authentication
In order to use the basic authentication functionality, turn in on from the application.properties file
```
petclinic.security.enable=true
```
This will secure all APIs and in order to access them, basic authentication is required.
Apart from authentication, APIs also require authorization. This is done via roles that a user can have.
The existing roles are listed below with the corresponding permissions 
* OWNER_ADMIN -> OwnerController, PetController, PetTypeController (getAllPetTypes and getPetType), VisitController
* VET_ADMIN   -> PetTypeController, SpecialityController, VetController
* ADMIN       -> UserController

There is an existing user with the username `admin` and password `admin` that has access to all APIs.
 In order to add a new user, please use the following API:
```
POST /api/users
{
    "username": "secondAdmin",
    "password": "password",
    "enabled": true,
    "roles": [
    	{ "name" : "OWNER_ADMIN" }
	]
}
```

## Looking for something in particular?

| Layer | Source |
|--|--|
| REST API controllers | [REST folder](src/main/java/com/vgg/smeportalservice/rest) |
| Service | [ClinicServiceImpl.java](src/main/java/com/vgg/smeportalservice/service/ClinicServiceImpl.java) |
| JDBC | [jdbc folder](src/main/java/com/vgg/smeportalservice/repository/jdbc) |
| JPA | [jpa folder](src/main/java/com/vgg/smeportalservice/repository/jpa) |
| Spring Data JPA | [springdatajpa folder](src/main/java/com/vgg/smeportalservice/repository/springdatajpa) |
| Tests | [AbstractClinicServiceTests.java](src/test/java/org/springframework/samples/petclinic/service/AbstractClinicServiceTests.java) |


## Publishing a Docker image

This application uses [Google Jib]([https://github.com/GoogleContainerTools/jib) to build an optimized Docker image
into the [Docker Hub](https://cloud.docker.com/u/springcommunity/repository/docker/springcommunity/spring-petclinic-rest/)
repository.
The [pom.xml](pom.xml) has been configured to publish the image with a the `springcommunity/spring-petclinic-rest`image name.




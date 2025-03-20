<h1 align="center">Backend API RESTful con Java + Spring Boot</h1>
<p></p>

<h1 align="center">pom.xml (dependencies)</h1>

- `spring-boot-starter-data-jpa`
  - Proporciona soporte para **Spring Data JPA**, facilitando la integración con **Bases de Datos** ***relacionales*** mediante el uso de **JPA** (**Java Persistence API**).
  - Incluye **Hibernate** como proveedor de **JPA** por defecto, el cual es un **ORM** (**Object-Relational Mapping**) que mapea objetos de Java a tablas en **Bases de Datos** ***relacionales*** como **MySQL, PostgreSQL, Oracle, SQL Server**, entre otras.

- `spring-boot-starter-web`
  - Contiene todo lo necesario para desarrollar una **API RESTful** en **Spring Boot**.
  - Incluye **Spring MVC**, **controladores, validaciones y servidor embebido** (**Tomcat** por defecto).

- `mysql-connector-j`
  - Es el driver **JDBC** necesario para que **Spring Boot** pueda conectarse a una **Base de Datos MySQL**.
  - Se ejecuta en tiempo de ejecución (runtime), es decir, no es necesario en tiempo de compilación.

- `spring-boot-starter-test`
  - Contiene herramientas y librerías necesarias para realizar **pruebas unitarias** e **integración** en **Spring Boot**.
  - Incluye **JUnit 5**, **Mockito**, y otras herramientas de **testing**.

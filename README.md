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

<h1 align="center">'application.properties' y 'Application'</h1>
<h2>application.properties</h2>
<p>Este archivo contiene la configuración de la aplicación <b>Spring Boot</b>, permitiendo personalizar su comportamiento sin modificar el código fuente</p>

```properties
spring.application.name=springboot-backend
spring.datasource.url=jdbc:mysql://localhost:3306/db_springboot_backend
spring.datasource.username=root
spring.datasource.password=sasa
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```

- `spring.application.name=springboot-backend`
  - Define el nombre de la aplicación dentro del entorno de **Spring Boot**.

- Configuración de la **Base de Datos MySQL**
  - `spring.datasource.url=jdbc:mysql://localhost:3306/db_springboot_backend`
    - Especifica la URL de conexión a la **Base de Datos MySQL**.
    - `localhost:3306` → Servidor y puerto de **MySQL**.
    - `db_springboot_backend` → Nombre de la **Base de Datos**.
  - `spring.datasource.username=root`
    - Usuario de la **Base de Datos**.
  - `spring.datasource.password=sasa`
    - Contraseña del usuario de la **Base de Datos**.
  - `spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`
    - Especifica el driver **JDBC** que **Spring Boot** debe usar para conectarse a **MySQL**.

- Configuración de **JPA** (**Java Persistence API**)
  - `spring.jpa.show-sql=true`
    - Hace que **Spring Boot** muestre las consultas **SQL** ejecutadas en la consola, lo cual es útil para depuración.

<h2>Application.java</h2>
<p>Esta es la clase principal de la aplicación <b>Spring Boot</b>. Su función es iniciar la aplicación y configurar automáticamente todos los componentes de <b>Spring</b>.</p>

<h1 align="center">'Product' y 'ProductRepository'</h1>
<h2>Product - Entidad JPA en Spring Boot</h2>
<p>La clase <b>Product</b> representa la entidad de un producto dentro del sistema. Está mapeada a una tabla en la <b>Base de Datos</b> y define los atributos básicos de un producto</p>

```java
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Long price;
    ...
}
```

- `@Entity`
	- Indica que esta clase es una entidad **JPA**, lo que significa que será administrada por el framework de persistencia de Java (**Hibernate** en el caso de Spring Boot).
	- Se traduce en una ***tabla*** en la **Base de Datos**.
- `@Table(name = "products")`
	- Especifica el nombre de la tabla en la **Base de Datos** a la que se ***mapeará*** esta entidad.
	- Si no se especifica, **Hibernate** asignará un nombre basado en el nombre de la clase.
- `@Id`
	- Declara que el campo **id** es la ***clave primaria*** de la entidad.
- `@GeneratedValue(strategy = GenerationType.IDENTITY)`
	- Indica que el valor del campo **id** se generará automáticamente por la **Base de Datos** mediante una estrategia de identidad (IDENTITY).
	- En bases de datos como **MySQL**, esto significa que el **id** se generará como un ***campo autoincremental***.

<h2>ProductRepository - Repositorio JPA en Spring Boot</h2>
<p>Esta interfaz define el acceso a la <b>Base de Datos</b> para la entidad <b>Product</b>, utilizando el mecanismo de persistencia de <b>Spring Data JPA</b>.</p>

```java
public interface ProductRepository extends CrudRepository<Product, Long> {}
```

- `ProductRepository extends CrudRepository<Product, Long>`
	- Extiende de `CrudRepository`, la cual proporciona operaciones **CRUD** (**Create**, **Read**, **Update**, **Delete**) para la entidad **Product**.
 	- `Product`: Es la entidad que administrará el repositorio.
  	- `Long`: Es el tipo de dato del identificador (**id**) de la entidad `Product`.

- Al heredadr de `CrudRepository` **Spring Data JPA** automáticamente genera la implementación de los siguientes métodos:
	- `save(Product product)`: **Guarda** o **actualiza** un producto en la **Base de Datos**.
	- `findById(Long id)`: **Busca** un producto por su **id**.
	- `findAll()`: **Obtiene todos** los productos.
	- `deleteById(Long id)`: **Elimina** un producto por su **id**.
	- `existsById(Long id)`: **Verifica** si un producto con el **id** dado ***existe***.
 
<h1 align="center">'ProductService' y 'ProductServiceImpl' - Capa de servicio en Spring Boot</h1>
<p>La <b>capa de servicio</b> (Service Layer) en una aplicación <b>Spring Boot</b> actúa como intermediaria entre el <b>controlador</b> (<b>Controller</b>) y el <b>repositorio</b> (<b>Repository</b>). Su propósito es encapsular la lógica de negocio y la gestión de transacciones.</p>

<h2>ProductService</h2>
<p>Esta interfaz define las operaciones de negocio relacionadas con los productos.</p>

```java
public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> deleteById(Long id);
}
```

- Métodos:
	- `findAll()`: **Obtiene** una **lista** con todos los productos.
 	- `findById(Long id)`: **Busca** un producto por su **id**.
  	- `save(Product product)`: **Guarda** o **actualiza** un producto.
	- `deleteById(Long id)`: **Elimina** un producto por su **id** y devuelve el producto eliminado si existía.

<h2>ProductServiceImpl</h2>
<p>Esta clase implementa <b>ProductService</b> y delega las operaciones al <b>ProductRepository</b></p>

```java
@Service
public class ProductServiceImpl implements ProductService {
```

- `@Service`: Marca la clase como un componente de servicio de **Spring**, lo que permite que **Spring** la detecte y la gestione como un bean dentro de su contexto de aplicación.

```java
    final private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }
```

- Se inyecta una instancia de `ProductRepository` a través del **constructor**, aplicando ***inyección de dependencias***.

```java
    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }
```

- `@Transactional(readOnly = true)`: Indica que esta operación ***solo consulta datos y no los modifica***, lo que **mejora el rendimiento**.
- Convierte el resultado de `repository.findAll()` en una **lista** de productos.

```java
    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
```

- Retorna un `Optional<Product>`, lo que ayuda a manejar el caso en que el producto no exista.
- También es una consulta de solo lectura.

```java
    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }
```

- `@Transactional`: Indica que esta operación ***puede modificar** la **Base de Datos** y, ***si ocurre un error, la transacción se revierte***.
- **Guarda** o **actualiza** un producto.

```java
    @Transactional
    @Override
    public Optional<Product> deleteById(Long id) {

        Optional<Product> productOptional = repository.findById(id);

        if (productOptional.isPresent()) {
            repository.deleteById(id);
            return productOptional;
        }

        return Optional.empty();
    }
```

- Primero **busca** el producto antes de **eliminarlo** para devolverlo como Optional<Product> en caso de éxito.
- Si el producto no existe, devuelve un `Optional.empty()`.
- `@Transactional` asegura que la eliminación sea parte de una transacción.


<h1 align="center">Backend API RESTful con Java + Spring Boot</h1>
<p>Este proyecto es una <b>API REST</b> desarrollada con <b>Spring Boot</b> que proporciona servicios para la gestión de productos. Está diseñada para interactuar con una <b>Base de Datos SQL</b> y facilitar la comunicación con clientes externos a través de <b>JSON</b>.</p>

<h2><ins>Descripción del Proyecto</ins></h2>
<p>El objetivo principal de este <b>backend</b> es ofrecer una <b>API</b> eficiente y escalable que permita realizar operaciones <b>CRUD</b> (Crear, Leer, Actualizar y Eliminar) sobre productos. Se ha implementado con buenas prácticas como el uso de Servicios, Repositorios e Inyección de Dependencias, asegurando un código limpio y mantenible.</p>

<h2><ins>Características Principales del Proyecto</ins></h2>

- Operaciones **CRUD** completas para la gestión de productos.
- Desarrollo con **Spring Boot** para una configuración rápida y eficiente.
- Persistencia de datos mediante **Spring Data JPA** y **Base de Datos SQL**.
- **API RESTful** con endpoints bien estructurados.
- Soporte para **CORS** para permitir conexiones desde clientes en **React** (http://localhost:5173), **Angular** (http://localhost:4200) y **Postman** (http://localhost:8080/)
- Gestión de excepciones y respuestas **HTTP** adecuadas.
- Uso de **Optional** en consultas para un manejo seguro de valores nulos.
- Integración con **Postman** o herramientas similares para pruebas de **API**.

<h2><ins>Imagenes del Proyecto</ins></h2>

<h3><ins>Solicitud HTTP GET</ins></h3>

![Postman-GET](https://github.com/user-attachments/assets/afc8d66d-a248-4765-a926-1343dad56ab4)
![Postman-Preview-GET](https://github.com/user-attachments/assets/5bfa398c-3204-41d5-b789-be8e695a6b2f)
![Backend-GET](https://github.com/user-attachments/assets/472000cf-2048-4690-8be1-1d98cd6a6002)

![Postman-ID-GET](https://github.com/user-attachments/assets/e05e3e79-d22d-401c-8d0a-1a4afe3dcb2e)
![Backend-ID-GET](https://github.com/user-attachments/assets/bf55a6b4-3f1b-4559-aa81-62ca676e115b)

<h3><ins>Solicitud HTTP POST</ins></h3>

![Postman-POST](https://github.com/user-attachments/assets/118b43c8-b7c9-43af-af7e-970ab2602d6c)
![Backend-POST](https://github.com/user-attachments/assets/21065b19-3ffa-48e1-8fd5-c2a4f4a1d70d)

<h3><ins>Solicitud HTTP PUT</ins></h3>

![Postman-PUT](https://github.com/user-attachments/assets/d9ff2e23-8e8d-4c2e-9ebd-70e068a4633b)
![Backend-PUT](https://github.com/user-attachments/assets/b8ae5b7b-f2f4-4a98-afed-9f8b029dda8a)

<h3><ins>Solicitud HTTP DELETE</ins></h3>

![Postman-DELETE](https://github.com/user-attachments/assets/aafa70ab-27c8-4ca2-873e-5fc96da934ec)
![Backend-DELETE](https://github.com/user-attachments/assets/03e7aca3-3a86-4ddd-8fde-6e5436d5b46c)

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

<h1 align="center">ProductController - Controlador (Controller)</h1>
<p>La clase <b>ProductController</b> en <b>Spring Boot</b> actúa como el punto de entrada para gestionar las <b>solicitudes HTTP</b> relacionadas con los productos. Sus anotaciones permiten definir su comportamiento y configuración.</p>

<h2>Anotaciones en la Clase 'ProductController'</h2>

```java
@RestController
@CrossOrigin({"http://localhost:5173", "http://localhost:4200"})
public class ProductController {
}
```

- `@RestController`
	- Es una combinación de dos anotaciones:
		- `@Controller`: Indica que esta clase es un controlador en **Spring MVC**.
		- `@ResponseBody`: Esta anotación se aplica de forma implícita a todos los métodos del controlador, garantizando que la respuesta de cada endpoint se ***convierta automáticamente*** en **JSON** o **XML**, según el **Content-Type** de la solicitud.
		- **Función**: Define que esta clase manejará **solicitudes HTTP** y devolverá respuestas en formato **JSON** (útil para una **API REST**).
- ¿Por qué `@ResponseBody` es importante en este Proyecto?
	- Permite que el ***backend*** **Spring Boot** envíe respuestas **JSON** a clientes externos (**React**, **Angular**, **apps móviles**, etc.).
	- Facilita la integración del ***backend*** con cualquier ***frontend*** sin depender del formato **SQL** de la **Base de Datos**.
	- Mejora la escalabilidad y compatibilidad de la **API REST**.
- `@CrossOrigin({"http://localhost:5173", "http://localhost:4200"})`
	- Permite que el ***frontend*** acceda a esta **API** desde dominios distintos al del ***backend***.
	- Evita errores de **CORS** (***Cross-Origin Resource Sharing***) cuando se hacen ***peticiones desde un cliente externo***, como una aplicación en **React** (puerto 5173) o **Angular** (puerto 4200).

 <h2>Métodos en la Clase 'ProductController'</h2>

<h3>'list()'</h3>

```java
@GetMapping
public ResponseEntity<List<Product>> list() {
    return ResponseEntity.ok(service.findAll());
}
```
- `@GetMapping`: Indica que este método responderá a solicitudes **HTTP GET**.
	- Como no se especifica una ruta, hereda la ruta base del controlador.
- `ResponseEntity<List<Product>>`
	- `ResponseEntity` es una clase de **Spring** que representa una respuesta **HTTP completa**, incluyendo el **código de estado** y el **cuerpo de la respuesta**.
	- `List<Product>` indica que el **cuerpo de la respuesta** será una lista de productos en formato **JSON**.
	- Ventaja de usar `ResponseEntity`: Permite mayor control sobre la **respuesta HTTP** (códigos de estado, cabeceras, etc.).
 - `ResponseEntity.ok(service.findAll())`
 	- `service.findAll()` → Llama al servicio `ProductService`, que a su vez usa `ProductRepository` para obtener todos los productos de la **Base de Datos**.
 	- `ResponseEntity.ok(...)` → Devuelve la respuesta con un código **HTTP 200 OK**, indicando que ***la solicitud fue exitosa***.

<h3>'details(@PathVariable Long id)'</h3>

```java
    @GetMapping("/{id}")
    public ResponseEntity<Product> details(@PathVariable Long id) {
        Optional<Product> optionalProduct = service.findById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
```
- `@GetMapping("/{id}")`: Indica que este método manejará las **peticiones GET** con un **parámetro {id}** en la **URL**.
- `@PathVariable Long id`: Extrae el valor del **{id}** de la **URL** y lo convierte a Long.
- `findById(id)`: Busca el producto en la **Base de Datos** y devuelve un `Optional<Product>` ***porque el producto puede existir o no***.
- Si el producto existe, se devuelve con `ResponseEntity.ok()`.

<h3>'create(@RequestBody Product product)'</h3>

```java
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }
```

- `@PostMapping`: Indica que este método manejará las **peticiones HTTP POST** para **crear** un nuevo producto.
- `@RequestBody Product product`: Convierte el **JSON** recibido en el cuerpo de la solicitud en un objeto Product.
- `service.save(product)`: Guarda el producto en la **Base de Datos** utilizando el servicio `ProductService`.
- `ResponseEntity.status(HttpStatus.CREATED).body(productGuardado)`: Devuelve el producto creado con el código de estado **201 Created**.

<h3>'update(@RequestBody Product product, @PathVariable Long id)'</h3>

```java
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {

        Optional<Product> productOptional = service.findById(id);

        if (productOptional.isPresent()) {
            productOptional.get().setName(product.getName());
            productOptional.get().setPrice(product.getPrice());
            productOptional.get().setDescription(product.getDescription());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }
```
- `@PutMapping("/{id}")`: Indica que este método manejará las **peticiones PUT** para **actualizar** un producto existente.
- `{id}` en la URL representa el **ID** del producto que se actualizará.
- `@RequestBody Product product`: Convierte el **JSON** recibido en el cuerpo de la solicitud en un objeto Product.
- `@PathVariable Long id`: Extrae el valor del **ID** desde la **URL** y lo pasa como parámetro al método.
- `service.findById(id)`: Busca el producto en la **Base de Datos** utilizando su **ID**.
- Verificación `if (productOptional.isPresent())`
	- Si el producto existe, se actualizan sus atributos y se guarda en la **Base de Datos**.
	- Si no existe, se devuelve un código 404 Not Found.
- `ResponseEntity.status(HttpStatus.OK).body(service.save(productOptional.get()))`: Guarda el producto actualizado en la **Base de Datos**.
- Devuelve 200 OK, ya que se ha realizado una actualización y no una creación.

<h3>'delete(@PathVariable Long id)'</h3>

```java
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {

        Optional<Product> optionalProduct = service.deleteById(id);

        if (optionalProduct.isPresent()) {
            Product productDeleted = optionalProduct.orElseThrow();
            return ResponseEntity.status(HttpStatus.OK).body(productDeleted);
        }
        return ResponseEntity.notFound().build();
    }
```
- `@DeleteMapping("/{id}")`: Indica que este método manejará las **peticiones DELETE** para **eliminar** un producto existente.
- `{id}` en la **URL** representa el **ID** del producto que se eliminará.
- `@PathVariable Long id`: Extrae el valor del **ID** desde la **URL** y lo pasa como parámetro al método.
- `service.deleteById(id)`: Busca el producto en la base de datos y lo elimina si existe.
- Devuelve un `Optional<Product>` con el producto eliminado o un `Optional.empty()` si no se encontró.
- Verificación `if (optionalProduct.isPresent())`
	- Si el producto existe y fue eliminado, se devuelve en la respuesta.
	- Si no existe, se devuelve un código 404 Not Found.
- `ResponseEntity.status(HttpStatus.OK).body(productDeleted)`: Devuelve el producto eliminado y el código de estado 200 OK.

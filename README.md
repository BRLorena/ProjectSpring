# First Java web project in Spring Boot

## Summary

- [Prerequisites](#Prerequisites)
- [Links about REST](#Links-sobre-REST)
- [Steps](#Passos)
- [Diagrams](#Diagramas)

## What will be done

- Creating a simple Java web project in Spring Boot and Maven.
- Introduction to dependency injection in Spring Boot
- Introduction to REST / web services
- Introduction to Spring Data JPA with H2 Database

## Links to learn about REST

- https://restfulapi.net/
- https://martinfowler.com/articles/richardsonMaturityModel.html
- https://pt.stackoverflow.com/questions/45783/o-que-%C3%A9-rest-e-restful/45787

## Prerequisites

- Programming Logic
- Basic OO
  - Object Composition
- Basic DB

## Steps

- Create Maven project using Spring Initializr and import into STS

- Suggestion: add to .gitignore:

```yml
.DS_Store
.vscode
.metadata
.mvn

mvnw
mvnw.cmd
```

- Create the Category entity

- Create CategoryResource

```java
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@GetMapping
	public ResponseEntity<...> findAll() {
		...
		return ResponseEntity.ok().body(...);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<...> findById(@PathVariable Long id) {
		...
		return ResponseEntity.ok().body(...);
	}
}
```

- Create CategoryRepository

```java
@Component
public class CategoryRepository {

	public void save(Category obj) {
		...
	}

	public Category findById(Long id) {
		...
	}

	public List<Category> findAll() {
		...
	}
}
```

- Implement CommandLineRunner to instantiate categories at application startup. Use Spring Boot's **dependency injection** mechanism to get an instance of CategoryRepository.

```java
Category cat1 = new Category(1L, "Electronics");
Category cat2 = new Category(2L, "Books");
```

- Optional: **save a commit**

- Add Product entity to project

```java
Category cat1 = new Category(1L, "Electronics");
Category cat2 = new Category(2L, "Books");

Product p1 = new Product(1L, "TV", 2200.00, cat1);
Product p2 = new Product(2L, "Domain Driven Design", 120.00, cat2);
Product p3 = new Product(3L, "PS5", 2800.00, cat1);
Product p4 = new Product(4L, "Docker", 100.00, cat2);

cat1.getProducts().addAll(Arrays.asList(p1, p3));
cat2.getProducts().addAll(Arrays.asList(p2, p4));
```

- Optional: **save a commit**

- Add Maven dependencies for Spring Data JPA and H2 database

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
```

- Add the H2 settings in application.properties

```yml
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

- Do the object-relational mappings

```java
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
```

- Remove the ID's of the instances in CommandLineRunner (set as null)

- Change the code of the repositories: use JpaRepository<Entity, ID>

- End: **save a commit**

## Diagrams

### Conceptual model

![myImage](https://github.com/devsuperior/aulao005/raw/master/domain-model.png)

### Instância

![myImage](https://github.com/devsuperior/aulao005/raw/master/domain-instance.png)

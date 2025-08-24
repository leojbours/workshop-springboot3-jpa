### workshop-springboot3-jpa
A simple API built with Spring Boot 3 and JPA for a Java course.

### 🚀 About this project
Simple project I made for my Java course to learn how to use Spring Boot, with data persisted in a PostgreSQL database via Hibernate.

### 🛠️ Tech Stack
* Java 21

* Spring Boot 3

* Hibernate

* PostgreSQL

* Maven

### ⚙️ Getting Started
To run this project locally, you'll need a few things.

1. Prerequisites:
   * Java 21
   * Maven
   * PostgreSQL installed and running.


2. Database Setup:
   * Before running the app, you need to create a database in PostgreSQL. You can name it whatever you like, for example workshop_db.


3. Configure the Connection:
   * Open the src/main/resources/application.properties file. You need to update the database URL, username, and password to match your local PostgreSQL setup.

#### Properties:
```Properties
# Example for PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/workshop_db
spring.datasource.username=your_postgres_username
spring.datasource.password=your_postgres_password

# This tells Hibernate to update the database schema automatically
spring.jpa.hibernate.ddl-auto=update
```

4. Clone and Run the App:

```Properties
# Clone this repository
git clone https://github.com/[seu-usuario]/workshop-springboot3-jpa.git

# Go into the repository folder
cd workshop-springboot3-jpa

# Run the app
./mvnw spring-boot:run
```
Now you can run the application.

The app should now be running on http://localhost:8080.
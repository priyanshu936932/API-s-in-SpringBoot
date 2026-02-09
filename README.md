# API-s-in-SpringBoot

A Spring Boot REST API application demonstrating CRUD operations with PostgreSQL database integration.

## 📋 Description

This is a learning project built with Spring Boot 4.0.2 that demonstrates building RESTful APIs with database integration. The project showcases best practices for building modern Java web applications using Spring Boot framework.

## 🛠️ Technologies Used

- **Spring Boot 4.0.2** - Main application framework
- **Spring Data JPA** - Database access and ORM
- **Spring Web MVC** - RESTful API development
- **PostgreSQL** - Relational database
- **Lombok** - Reduce boilerplate code
- **ModelMapper 3.2.6** - Object mapping
- **Jakarta Validation 3.1.1** - Bean validation
- **Java 17** - Programming language

## 📦 Project Structure

```
API-s-in-SpringBoot/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── pom.xml
└── README.md
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL database

### Installation

1. Clone the repository
```bash
git clone https://github.com/priyanshu936932/API-s-in-SpringBoot.git
cd API-s-in-SpringBoot
```

2. Configure PostgreSQL database settings in `application.properties` or `application.yml`

3. Build the project
```bash
./mvnw clean install
```

4. Run the application
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## 🔧 Configuration

Update the database configuration in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## 📚 API Endpoints

(Add your API endpoints documentation here)

## 🧪 Testing

Run tests using Maven:

```bash
./mvnw test
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📝 License

This project is open source and available for learning purposes.

## 👤 Author

**priyanshu936932**

- GitHub: [@priyanshu936932](https://github.com/priyanshu936932)

## 🙏 Acknowledgments

- Spring Boot documentation
- Spring Data JPA guides
- PostgreSQL documentation

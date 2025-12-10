# Exquisite Loop Marketing Website

A modern, responsive marketing website for Exquisite Loop built with Spring Boot and Tailwind CSS.

## About

Exquisite Loop provides full-stack web and mobile application development for the modern business. Our primary focus is on Java/Spring web applications, complemented by native iPhone and Android mobile applications.

## Features

- **About Us Page**: Company description, mission statement, services overview, and technology stack
- **Portfolio Page**: Showcase of six sample projects across different domains
- **Contact Us Page**: Functional contact form with validation and success messaging
- **Responsive Design**: Mobile-friendly navigation and layouts
- **Modern UI**: Clean, professional design using Tailwind CSS

## Technology Stack

- **Java 17**
- **Spring Boot 3.2.0**
  - Spring Web
  - Spring Boot Thymeleaf
  - Spring Boot Validation
- **Tailwind CSS** (via CDN)
- **Maven** for build management

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/richthibault/exqloop-web.git
   cd exqloop-web
   ```

2. Build the application:
   ```bash
   mvn clean package
   ```

3. Run the application:
   ```bash
   java -jar target/exqloop-web-1.0.0.jar
   ```

   Or use Maven:
   ```bash
   mvn spring-boot:run
   ```

4. Open your browser and navigate to:
   ```
   http://localhost:8080
   ```

## Project Structure

```
exqloop-web/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/exquisiteloop/website/
│       │       ├── ExqloopWebApplication.java
│       │       ├── controller/
│       │       │   └── WebController.java
│       │       └── model/
│       │           └── ContactForm.java
│       └── resources/
│           ├── application.properties
│           ├── static/
│           │   └── css/
│           │       └── styles.css
│           └── templates/
│               ├── about.html
│               ├── portfolio.html
│               ├── contact.html
│               └── layout.html
└── pom.xml
```

## Configuration

The application runs on port 8080 by default. You can change this in `application.properties`:

```properties
server.port=8080
```

## Pages

- **/** or **/about** - About Us page
- **/portfolio** - Portfolio showcase
- **/contact** - Contact form

## Contact Form

The contact form includes validation for:
- Name (required)
- Email (required, valid email format)
- Subject (required)
- Message (required)

Upon successful submission, a success message is displayed. In a production environment, you would integrate email sending or database storage.

## Development

To enable hot reloading during development, the application includes Spring Boot DevTools. Any changes to templates or static resources will be automatically reloaded.

## License

© 2025 Exquisite Loop. All rights reserved.
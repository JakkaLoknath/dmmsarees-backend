# Use Java 17 (recommended for Spring Boot 3)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and config
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Give execute permission to mvnw (important for Linux/Render)
RUN chmod +x mvnw

# Download dependencies (cache layer)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the application (creates JAR inside target/)
RUN ./mvnw clean package -DskipTests

# Expose port (Render will override with PORT env)
EXPOSE 8080

# Run the Spring Boot application
CMD ["java","-jar","target/DMMSAREES-0.0.1-SNAPSHOT.jar"]

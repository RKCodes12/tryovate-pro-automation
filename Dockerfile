FROM maven:3.9.5-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /backend_code

# Copy pom.xml and download dependencies
COPY pom.xml .
COPY src ./src

# Copy the entire project and build it
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application with JDK 17
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /backend_code

# Set environment variables
ENV DB_URL=jdbc:mysql://tryovate.co.in:3306/TryovateApp_Db
ENV CORS_ALLOWED_ORIGINS=https://tryovate.co.in

# Copy the built jar from the first stage
COPY --from=build /backend_code/target/TryovateApp-0.0.1-SNAPSHOT.jar app.jar

# Expose port used in application.properties
EXPOSE 2020

# Run the application
ENTRYPOINT ["java", "-jar","app.jar"]


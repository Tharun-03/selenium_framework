# Use Maven + Java 17 image
FROM maven:3.9.6-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Install dependencies
RUN mvn clean install -DskipTests

# Default command
CMD ["mvn", "test", "-Pgrid"]

# Use Maven + Java 21 (matches your pom.xml compiler target)
FROM maven:3.9.9-eclipse-temurin-21

WORKDIR /app

# Copy everything into the container
COPY . .

# Build the WAR file
RUN mvn clean package -DskipTests

# Start the embedded Jetty server via Main.java
CMD ["mvn", "exec:java", "-Dexec.mainClass=Main"]

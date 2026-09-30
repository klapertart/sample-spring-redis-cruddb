# Sample Spring Boot Redis CRUD

This is a sample Spring Boot application demonstrating how to perform CRUD (Create, Read, Update, Delete) operations using Redis as the primary database.

## Technologies Used
*   Java 1.8
*   Spring Boot 2.7.8
*   Spring Data Redis
*   Jedis (Redis Client) 3.9.0
*   Lombok
*   Maven

## Configuration
The application connects to a Redis server running on `0.0.0.0` at port `6379`. Ensure you have a local Redis instance running before starting the application. 
Redis configuration can be found in `src/main/java/klapertart/lab/redisdb/config/RedisConfig.java`.

## API Endpoints
The application provides a set of REST endpoints for managing `Product` entities.

### Product Structure
```json
{
  "id": 1,
  "name": "Product Name",
  "qty": 10,
  "price": 50000
}
```

### Endpoints
*   **Create Product**: `POST /api/product`
    *   Request Body: Product JSON
*   **Get All Products**: `GET /api/product`
*   **Get Product By ID**: `GET /api/product/{id}`
*   **Delete Product**: `DELETE /api/product/{id}`

## How to Run
1. Make sure you have a Redis server running locally on port 6379.
2. Run the application using Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
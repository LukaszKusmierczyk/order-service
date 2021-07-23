export DB_URL=jdbc:postgresql://localhost:5432/db_order
export DB_USER=u_order
export DB_PASSWORD=order
export CUSTOMER_SERVICE_URL=http://localhost:8081/customer

cd build/libs

java -jar order-service-1.0-SNAPSHOT.jar
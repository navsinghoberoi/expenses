# Expenses

App for tracking the expenses in order to check total and category spends.

# Getting Started :
Below mentioned instructions will get you a copy of the project up and running on your local machine for testing purposes.

# Prerequisites :
IntelliJ Idea<br>
Java 17<br>
Mysql<br>

Clone the repository via ssh/http using URL -->
https://github.com/navsinghoberoi/expenses.git

# DB Setup :
In application.properties file, specify correct db url value for the key spring.datasource.url 
The name of the database mentioned in the application.properties file must be created on the local mysql database. (No need to create any table, that will be created automatically)

# Running application :
To start the application on the server, run the following command -
mvn spring-boot:run

# CRUD api endpoints for student application :
POST endpoint to add expense: http://localhost:8080/api/v1/expenses <br>
GET endpoint to get total expenses:  http://localhost:8080/api/v1/expenses/total <br>
GET endpoint to get total expenses category wise : http://localhost:8080/api/v1/expenses?category=Food <br>
GET endpoint to get expenses for month/year : http://localhost:8080/api/v1/expenses/date?year=2024&month=01 <br>
DELETE endpoint to delete expense: http://localhost:8080/api/v1/expenses/{id} <br>
PATCH endpoint to update expense: http://localhost:8080/api/v1/expenses/{id} <br>

# Built With :
Spring Boot <br>
Java <br>
Maven<br>
Git<br>
my-sql<br>

# Author :
Navpreet Singh


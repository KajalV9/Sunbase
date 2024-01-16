# Customer Management Application
This is a CRUD (Create, Read, Update, Delete) application for managing customer information. The application uses a MySQL database for data storage, Spring Boot for the backend, and HTML/CSS/JS for the frontend. JWT authentication is implemented to secure the backend APIs.

Backend
Clone the repository:
# Navigate to the backend directory:
cd customer-management/backend

# No specific dependencies required
For Spring Boot:
cd spring-boot-backend
mvn clean install

# Navigate to the project root directory
cd spring-boot-backend
mvn spring-boot:run

# Frontend
Open the frontend HTML files in a web browser : CustomerListScreen.html

# Backend APIs
CRUD Operations
Create a Customer:
Endpoint: /api/customers
API : http://localhost:8080/api/customers
Method: POST
Request Body: {
"firstName": "Jane",
"lastName": "Doe",
"street": "Elvnu Street",
"address": "H no 2 ",
"city": "Delhi",
"state": "Delhi",
"email": "sam@gmail.com",
"phoneno": "1234567891"
}

Response Body : 
{
    "id": 18,
    "firstName": "Jane",
    "lastName": "Doe",
    "street": "Elvnu Street",
    "address": "H no 2 ",
    "city": "Delhi",
    "state": "Delhi",
    "email": "sam@gmail.com",
    "phoneno": "1234567891"
}

Update a Customer:
Endpoint: /api/customers/{customerId}
Example API : http://localhost:8080/api/customers/18
Method: PUT
Request Body: 
{
    "id": 18,
    "firstName": "Jane",
    "lastName": "Doe",
    "street": "Elvnu Street",
    "address": "H no 2 ",
    "city": "Delhi",
    "state": "Delhi",
    "email": "sam@gmail.com",
    "phoneno": "8888888888"
}


Get a List of Customers:
Endpoint: /api/customers
API : http://localhost:8080/api/customers
Method: GET
Response Body : 
{
    "content": [
        {
            "id": 15,
            "firstName": "Kajal",
            "lastName": "Varma",
            "street": "789 Pine Lane",
            "address": "Apt 101",
            "city": "Pune",
            "state": "Maharashtra",
            "email": "ki@gmail.com",
            "phoneno": "9176667777"
        },
        {
            "id": 17,
            "firstName": "John",
            "lastName": "sdf",
            "street": "789 Pine Lane",
            "address": "Apt 101",
            "city": "Greenville",
            "state": "SC",
            "email": "john@gmail.com",
            "phoneno": "1111111111"
        },
        {
            "id": 18,
            "firstName": "Jane",
            "lastName": "Doe",
            "street": "Elvnu Street",
            "address": "H no 2 ",
            "city": "Delhi",
            "state": "Delhi",
            "email": "sam@gmail.com",
            "phoneno": "1234567891"
        }
    ],
    "pageNo": 0,
    "pageSize": 10,
    "totalElements": 3,
    "totalPages": 1,
    "last": true
}

Get a Single Customer by ID:
Endpoint: /api/customers/{customerId}
Method: GET

Delete a Customer:
Endpoint: /api/customers/{customerId}
Method: DELETE


# Frontend Screens
1. Login Screen
Basic login form.
Authenticate user with the provided API.

2. Customer List Screen
Display a list of customers in an HTML table.
Ability to search and sync with the remote API.

3. Add a New Customer
Simple form for adding a new customer.
Accessed when clicked on add Customer button on Customer List Screen

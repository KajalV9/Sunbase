function getAllCustomers() {
            fetch('http://localhost:8080/api/customers')
                .then(response => response.json())
                .then(data => {
                    populateCustomerTable(data.content);
                })
                .catch(error => console.error('Error:', error));
        }

  function searchCustomers(){
         const selectedOption = document.getElementById('searchByDropdown').value;

        // Get the search term from the input field
        const searchTerm = document.getElementById('searchBar').value;

        // Make a GET request to search for customers based on the selected option and search term
        fetch(`http://localhost:8080/api/customers/${selectedOption}/${searchTerm}`)
            .then(response => response.json())
            .then(data => {
                // Handle the data received from the backend
                console.log(data);
             if (Array.isArray(data)) {
                        // For array response (list of customers)
                        populateCustomerTable(data);
                    } else {
                        // For single object response (e.g., when editing a customer)
                        populateCustomerTable([data]);
                }
            })
            .catch(error => console.error('Error:', error));
    }
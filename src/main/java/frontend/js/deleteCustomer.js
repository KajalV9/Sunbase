  //Delete customer :
        function deleteCustomer(id) {
            fetch(`http://localhost:8080/api/customers/${id}`, {
            method: 'DELETE',
            })
            .then(response => {
                // Ensure successful response before handling data
                if (!response.ok) {
                    throw new Error(`Failed to delete customer: ${response.statusText}`);
                }
                return response.json();
            })
            .then(data => {
                const customerRow = document.getElementById(`customerRow-${id}`);
                if (customerRow) {
                    customerRow.remove(); // Use `remove()` for modern browsers
                } else {
                    console.error(`Customer row with id ${id} not found.`);
                }

            // Provide feedback to the user
            alert('Customer deleted successfully!');

            })
            .catch(error => {
                console.error('Error:', error);
                alert(`An error occurred while deleting the customer: ${error.message}`);
            });
        }

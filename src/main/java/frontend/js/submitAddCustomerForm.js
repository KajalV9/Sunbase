 function submitAddCustomerForm() {
            const formData = {
                firstName: document.getElementById('firstName').value,
                lastName: document.getElementById('lastName').value,
                address: document.getElementById('address').value,
                city: document.getElementById('city').value,
                state: document.getElementById('state').value,
                email: document.getElementById('email').value,
                phoneno: document.getElementById('phone').value,
                street : document.getElementById('street').value
            };

           fetch('http://localhost:8080/api/customers', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        })
        .then(response => {
            // Ensure successful response before handling data
            if (!response.ok) {
                throw new Error('Failed to create customer: ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            // Handle the data received from the backend
            console.log(data);

            const customerList = document.getElementById('customerList');
            if (customerList) {
                const newCustomerElement = document.createElement('li');
                newCustomerElement.textContent = `${data.first_name} ${data.last_name} - ${data.city}, ${data.state}, ${data.phoneno}, ${data.email}, ${data.address}, ${data.street}`;
                customerList.appendChild(newCustomerElement);
            } else {
                console.error("'customerList' element not found.");
            }

             const customerDataRow = document.createElement('tr');
             customerDataRow.innerHTML = `
            <td>${data.firstName}</td>
            <td>${data.lastName}</td>
            <td>${data.address}</td>
            <td>${data.city}</td>
            <td>${data.state}</td>
            <td>${data.email}</td>
            <td>${data.phoneno}</td>
            <td class="action-buttons">
                <button onclick="editCustomer()">✏</button>
                <button onclick="deleteCustomer(${data.id})">-</button>
            </td>
        `;
        document.getElementById('customerTableBody').appendChild(customerDataRow);
        })
        .catch(error => {
            console.error('Error:', error);

            alert(`An error occurred while adding the customer: ${error.message}`);
        });

            // Close the modal
            closeAddCustomerModal();
        }

        window.onload = () => {
            getAllCustomers();
        };

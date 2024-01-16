function populateCustomerTable(customers) {
            const customerTableBody = document.getElementById('customerTableBody');
            customerTableBody.innerHTML = ''; // Clear any existing rows

            customers.forEach(customer => {
                const customerDataRow = document.createElement('tr');
                customerDataRow.innerHTML = `
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.address}</td>
                    <td>${customer.city}</td>
                    <td>${customer.state}</td>
                    <td>${customer.email}</td>
                    <td>${customer.phoneno}</td>
                    <td class="action-buttons">
                        <button onclick="editCustomer()">✏</button>
                        <button onclick="deleteCustomer(${customer.id})">-</button>
                    </td>
                `;
                customerTableBody.appendChild(customerDataRow);
            });
        }
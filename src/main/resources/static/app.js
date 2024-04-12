window.onload = function() {
    fetchVehicles();
};

function fetchVehicles() {
    fetch('http://localhost:8080/api/vehicles')
        .then(response => response.json())
        .then(data => {
            const table = document.getElementById('vehicleTable').getElementsByTagName('tbody')[0];
            table.innerHTML = ''; // Clear the table first
            data.forEach(vehicle => {
                let row = table.insertRow();
                row.insertCell(0).innerHTML = vehicle.brand;
                row.insertCell(1).innerHTML = vehicle.model;
                row.insertCell(2).innerHTML = vehicle.yearOfManufacture;
                row.insertCell(3).innerHTML = vehicle.hasTrailer ? 'Yes' : 'No';
                let actions = row.insertCell(4);
                actions.innerHTML = `<button onclick="deleteVehicle(${vehicle.id})">Delete</button>
                                      <button onclick="editVehicle(${vehicle.id})">Edit</button>`;
            });
        });
}

function addVehicle() {
    const vehicleData = {
        brand: document.getElementById('brand').value,
        model: document.getElementById('model').value,
        yearOfManufacture: document.getElementById('year').value,
        hasTrailer: document.getElementById('trailer').checked
    };
    fetch('http://localhost:8080/api/vehicles', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(vehicleData)
    }).then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            fetchVehicles(); // Refresh the list after adding
        })
        .catch(error => console.error('Error:', error));
}

function deleteVehicle(id) {
    fetch(`http://localhost:8080/api/vehicles/${id}`, {
        method: 'DELETE'
    }).then(() => {
        fetchVehicles(); // Refresh the list after deleting
    });
}

function editVehicle(id) {
    fetch(`http://localhost:8080/api/vehicles/${id}`)
        .then(response => response.json())
        .then(vehicle => {
            document.getElementById('editBrand').value = vehicle.brand;
            document.getElementById('editModel').value = vehicle.model;
            document.getElementById('editYear').value = vehicle.yearOfManufacture;
            document.getElementById('editTrailer').checked = vehicle.hasTrailer;
            document.getElementById('editId').value = vehicle.id;
            toggleEditForm(); // Show the edit form
        });
}

function submitEdit() {
    const id = document.getElementById('editId').value;
    const updatedVehicle = {
        brand: document.getElementById('editBrand').value,
        model: document.getElementById('editModel').value,
        yearOfManufacture: parseInt(document.getElementById('editYear').value),
        hasTrailer: document.getElementById('editTrailer').checked
    };
    fetch(`http://localhost:8080/api/vehicles/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedVehicle)
    }).then(response => response.json())
        .then(data => {
            console.log('Update successful:', data);
            fetchVehicles(); // Refresh the list
            toggleEditForm(); // Hide the edit form
        });
}


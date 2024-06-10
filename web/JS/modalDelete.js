// Get the modal
var modal = document.getElementById('deleteModal');

// Get the button that opens the modal
var trashIcons = document.querySelectorAll('.fa-trash');

// Get the <span> element that closes the modal
var span = document.getElementsByClassName('close')[0];

// Get the confirm and cancel buttons
var confirmBtn = document.getElementById('confirmDelete');
var cancelBtn = document.getElementById('cancelDelete');

// When the user clicks on the trash icon, open the modal
trashIcons.forEach((icon) => {
    icon.onclick = function(event) {
        event.preventDefault();
        modal.style.display = 'block';
        
        // Store the ID of the car to be deleted
        var carId = icon.parentElement.getAttribute('data-id');
        
        // Set the action of the confirm button to call the deleteCar function with the carId
        confirmBtn.onclick = function() {
            deleteCar(carId);
        };
    };
});

// When the user clicks on <span> (x) or cancel button, close the modal
span.onclick = cancelBtn.onclick = function() {
    modal.style.display = 'none';
};

// When the user clicks on the confirm button, proceed with delete action
function deleteCar(carId) {
    // Create an XMLHttpRequest object
    var xhr = new XMLHttpRequest();

    // Configure the request
    xhr.open('POST', 'ServletDeletaVeiculo', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    // Define the callback function
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                // If deletion is successful, show alert and reload the page
                alert('Veículo deletado com sucesso!');
                window.location.reload();
            } else {
                // If deletion fails, show error message
                alert('Erro ao deletar veículo: ' + xhr.responseText);
            }
        }
    };

    // Send the request with the carId as parameter
    xhr.send('codigo=' + encodeURIComponent(carId));
}

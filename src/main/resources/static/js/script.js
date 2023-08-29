$(document).ready(function() {
    $("#cadastro-form").submit(function(event) {
        event.preventDefault();
        
        var nome = $("#nome").val();
        var senha = $("#senha").val();
        var cargoSelect = document.getElementById("cargo");
        var selectedValueCargo = cargoSelect.value;
        
        var user = {
            name: nome,
            password: senha,
            positionValue: selectedValueCargo
        };
        
        $.ajax({
            type: "POST",
            url: "/create",
            data: JSON.stringify(user),
            contentType: "application/json",
            success: function() {
                getAllUsers();
            },
            error: function(error) {
                alert("Erro ao cadastrar usuário.");
            }
        });
    });
});


function getAllUsers(){
    $.ajax({
        type: "GET",
        url: "/listAll",
        contentType: "application/json",
        success: function(response) {
        $('#user-table-container').html(response);
        },  
        error: function(error) {
            alert("Erro ao listar usuários cadastrados.");
        }
    });
}

getAllUsers();
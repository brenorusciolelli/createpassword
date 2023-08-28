$(document).ready(function() {
    $("#cadastro-form").submit(function(event) {
        event.preventDefault();
        
        var nome = $("#nome").val();
        var senha = $("#senha").val();
        
        var user = {
            name: nome,
            password: senha,
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
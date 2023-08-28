$(document).ready(function() {
    $("#cadastro-form").submit(function(event) {
        event.preventDefault();
        
        var nome = $("#nome").val();
        var senha = $("#senha").val();
        
        var user = {
            name: nome,
            password: senha,
            score: 0
        };
        
        $.ajax({
            type: "POST",
            url: "/create",
            data: JSON.stringify(user),
            contentType: "application/json",
            success: function(response) {
                console.log(response)
                alert("Usuário cadastrado com sucesso!");
            },
            error: function(error) {
                alert("Erro ao cadastrar usuário.");
            }
        });
    });
});
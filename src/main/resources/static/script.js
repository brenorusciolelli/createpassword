$(document).ready(function() {
    $("#cadastro-form").submit(function(event) {
        event.preventDefault();
        
        var nome = $("#nome").val();
        var senha = $("#senha").val();
        let value = "";
        value = evaluatePassword(senha);
        var score = getScorePassword(value);
        
        var user = {
            name: nome,
            password: senha,
            score: score,
            passwordStatus: value
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

function getScorePassword(evaluatePassword) {
    let score;
    switch (evaluatePassword) {
        case "RUIM": 
            score = "20";
            break;
        case "MEDIANA": 
            score = "50";
            break;    
        case "BOM": 
            score = "70";
            break; 
        case "FORTE": 
            score = "100";
            break; 
        default:
            score = "0";
            break;
    }
    return score;
}

function evaluatePassword(password) {
    if (password.length < 6) {
        return "RUIM";
    } else if (/[a-z]/.test(password) && /[A-Z]/.test(password) && /\d/.test(password) && /[!@#$%^&*]/.test(password)) {
        return "FORTE";
    } else if (/[a-z]/.test(password) && /[A-Z]/.test(password) && /\d/.test(password)) {
        return "BOM";
    } else if (/[a-z]/.test(password) && /\d/.test(password)) {
        return "MEDIANA";
    } else {
        return "FRACA";
    }
}

getAllUsers();
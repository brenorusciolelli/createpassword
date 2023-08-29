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

function setClickTable(){
const linhas = document.querySelectorAll(".table_colaboradores tr");

linhas.forEach((linha) => {
  linha.addEventListener("click", () => {
    const id = linha.id;
    $.ajax({
        type: "GET",
        url: "/id/" + id,
        contentType: "application/json",
        success: function(response) {
        $('#modal_usuario').html(response);
        closeUserModal();
        },  
        error: function(error) {
            alert("Erro ao listar usuários cadastrados.");
        }
    });
  });
});
}

getAllUsers();

setTimeout(function() { 
    setClickTable();
}, 2000);


function closeUserModal(){
const closeModal = document.querySelector(".close");
let modalUser = document.getElementById('userModal');

if(closeModal){
    closeModal.addEventListener("click", () => {
        modalUser.style.display = "none";
      });
}
}
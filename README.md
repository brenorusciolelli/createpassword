# Sistema de Cadastro de Colaboradores

O Sistema de Cadastro de Colaboradores é uma aplicação web desenvolvida em Java 17 utilizando o framework Spring Data e MongoDB. A aplicação permite criar, deletar, listar e ler informações de colaboradores, além de possibilitar a criação de hierarquias entre os colaboradores.

## Pré-requisitos

* Docker

Para iniciar o banco de dados MongoDB, execute o seguinte comando na pasta `infrastructure`:

docker-compose up -d

## Iniciando a Aplicação

1. Clone este repositório para o seu ambiente local.
2. Navegue até a pasta raiz do projeto.
3. Execute o seguinte comando para iniciar a aplicação:

./mvnw spring-boot:run

ou rode direto pelo eclipse.

Acesse a aplicação no seu navegador usando o seguinte endereço:

http://localhost:8080

Funcionalidades
Cadastro de Colaboradores: Adicione novos colaboradores com informações como nome, cargo e hierarquia.
Deletar Colaboradores: Remova colaboradores da base de dados.
Listar Colaboradores: Visualize a lista de todos os colaboradores cadastrados.
Ler Informações de Colaborador: Leia detalhes sobre um colaborador específico.
Tecnologias Utilizadas
Java 17
Spring Data
MongoDB
HTML
CSS
JavaScript
jQuery
Thymeleaf

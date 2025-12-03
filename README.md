Projeto To-Do List JPA com Java e Spring Boot
Visão Geral do Projeto
Este projeto consiste em uma API RESTful para gerenciamento de tarefas (To-Do List), desenvolvida como parte da disciplina de Programação Orientada a Objetos do curso de Análise e Desenvolvimento de Sistemas da FATEC. 
A aplicação permite a criação, listagem, atualização e exclusão de tarefas, utilizando uma arquitetura robusta e tecnologias modernas do ecossistema Java.

O desenvolvimento seguiu as melhores práticas de mercado, com ênfase na qualidade de código, organização e manutenibilidade, refletindo os conhecimentos adquiridos ao longo do curso.

Tecnologias Utilizadas
•	Java 21: Versão mais recente da linguagem Java, garantindo acesso aos recursos mais modernos da plataforma.
•	Spring Boot 3.x: Framework para criação de aplicações Java de forma rápida e configurável.
•	Spring Data JPA: Para persistência de dados em banco de dados relacional.
•	MySQL: Sistema de gerenciamento de banco de dados relacional.
•	Maven: Ferramenta para gerenciamento de dependências e build do projeto.
•	Lombok: Biblioteca para reduzir a verbosidade do código Java.
•	Docker: Para containerização da aplicação e do banco de dados, facilitando a configuração do ambiente de desenvolvimento.

Funcionalidades
•	Criação de Tarefas: Endpoint para criar novas tarefas com título, descrição, data de início e fim, prioridade e status.
•	Listagem de Tarefas: Endpoint para listar todas as tarefas cadastradas.
•	Atualização de Tarefas: Endpoint para atualizar todas as informações de uma tarefa existente.
•	Atualização Parcial de Tarefas: Endpoint para atualizar o status de uma tarefa específica.
•	Validação de Dados: Validações para garantir a integridade dos dados de entrada.
•	Tratamento de Exceções: Tratamento global de exceções para fornecer respostas de erro claras e consistentes.

Como Executar o Projeto
Pré-requisitos
•	Java 21 ou superior
•	Maven 3.6 ou superior
•	Docker e Docker Compose

Passos para Execução
1	Clone o repositório:
git clone https://github.com/Artursrossi/projeto-todo-list-java-jpa.git
cd projeto-todo-list-java-jpa
2	Inicie o banco de dados com Docker Compose:
docker-compose up -d
3	Execute a aplicação com Maven:
mvn spring-boot:run

A API estará disponível em http://localhost:8080.

Endpoints da API
Método HTTP	Rota	Descrição
GET	/tasks/	Lista todas as tarefas cadastradas.
POST	/tasks/	Cria uma nova tarefa.
PUT	/tasks/{id}	Atualiza uma tarefa existente.
PATCH	/tasks/{id}/status	Atualiza o status de uma tarefa existente.
Schema do Banco de Dados
A aplicação utiliza uma única tabela, tb_tasks, para armazenar as tarefas. A estrutura da tabela é a seguinte:

Coluna	Tipo	Descrição
id	UUID	Identificador único da tarefa (Chave Primária).
title	VARCHAR(48)	Título da tarefa.
description	VARCHAR(512)	Descrição detalhada da tarefa.
status	VARCHAR	Status da tarefa (TODO, IN_PROGRESS, DONE).
priority	VARCHAR	Prioridade da tarefa (LOW, NORMAL, HIGH).
start_at	DATETIME	Data e hora de início da tarefa.
end_at	DATETIME	Data e hora de término da tarefa.
created_at	DATETIME	Data e hora de criação da tarefa.
updated_at	DATETIME	Data e hora da última atualização da tarefa.
Contribuidores:
Artur S. Rossi
Isabella Mantovani Rottoli
Marjory Harumi Barbosa Hito
Vinicius Allejandro da Silva Teixeira

•	Artur Schincariol Rossi
•	Isabella Rottoli

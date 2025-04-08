# 📋 Desafio Attornatus - Gerenciamento de Pessoas e Endereços

Este projeto foi desenvolvido como parte do [Desafio da Attornatus](https://github.com/kennedybrito/Desafio_Attornatus), com o objetivo de construir uma API REST para gerenciar pessoas e seus endereços.

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.4
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 Database (ambiente de desenvolvimento)
- JUnit 5
- Mockito

## 🎯 Objetivo do Projeto

Criar uma API capaz de:

- ✅ Criar pessoas
- ✅ Editar pessoas
- ✅ Listar pessoas
- ✅ Consultar uma pessoa por ID
- ✅ Criar endereços para uma pessoa
- ✅ Listar todos os endereços de uma pessoa
- ✅ Permitir que um dos endereços seja marcado como principal

  ## 🔄 Funcionalidades

### Pessoa
- `POST /pessoas`: Criar uma nova pessoa.
  <br>
  
  ![Image](https://github.com/user-attachments/assets/9296a95a-46f2-4a27-9f11-13f62436819c)
  <br>
- `GET /pessoas`: Listar todas as pessoas com seus endereços.
  <br>
  
![Image](https://github.com/user-attachments/assets/51cd700c-5763-463a-8b46-c9ddd9fa6cbe)
  <br>

- `GET /pessoas/{id}`: Buscar uma pessoa pelo ID.
  <br>
  
  ![Image](https://github.com/user-attachments/assets/fbcc5077-4f18-40e3-bcb0-1432913636b1)
  <br>
  
- `PUT /pessoas/{id}`: Atualizar nome e data de nascimento da pessoa.
  <br>
  
 ![Image](https://github.com/user-attachments/assets/07d4e34a-ed4b-4b66-b8f5-faa1a28e2a7b)
 <br>
  
- `DELETE /pessoas/{id}`: Deletar uma pessoa.
 <br>
  
![Image](https://github.com/user-attachments/assets/87f26fe6-874e-4235-a05c-9430219d84b2)
 <br>

### Endereço
- `POST /endereco/pessoa/{personId}`: Criar um novo endereço para uma pessoa. Apenas um pode ser principal.
 <br>
  
![Image](https://github.com/user-attachments/assets/48498a95-034e-4fcc-aec7-14af8e7c655f)
 <br>
- `GET /endereco`: Listar todos os endereços com o nome da pessoa associada.
<br>
  
![Image](https://github.com/user-attachments/assets/34138fb4-ee67-455d-91aa-405b5eee19c8)
 <br>
  
- `GET /endereco/{id}`: Buscar um endereço pelo ID.
<br>
  
![Image](https://github.com/user-attachments/assets/b2213410-9bcc-4923-8c99-501d384a8320)
 <br>
- `DELETE /endereco/{id}`: Remover um endereço pelo ID.
<br>
  
![Image](https://github.com/user-attachments/assets/3170e7de-0909-4d86-96cd-bc0ffe2ad581)
 <br>

## ▶️ Como rodar o projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
Execute o projeto:

./mvnw spring-boot:run

Acesse a API via http://localhost:8080


🧪 Banco de dados

A aplicação utiliza o banco H2 (em memória) durante o desenvolvimento.

Você pode acessar o console do H2 em:

🔗 http://localhost:8080/h2-console

Use as credenciais padrão:

JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (em branco)

# Explorando o Protocolo HTTP com Java Servlets

**Instituto Federal do Sul de Minas Gerais – Campus Machado**

**Disciplina:** Tecnologias de Desenvolvimento para Internet III

**Professor:** Dr. Emerson A. Carvalho

## Sobre o projeto

Este projeto foi desenvolvido como atividade acadêmica com o objetivo de explorar o funcionamento do protocolo HTTP utilizando Java Servlets.

A aplicação demonstra métodos HTTP, cabeçalhos de requisição e resposta, manipulação do corpo das requisições, cookies e códigos de status.

## Tecnologias utilizadas

- Java
- Jakarta Servlet 6.1
- Apache Tomcat 11
- Eclipse IDE
- HTML

## Funcionalidades

### 1. Análise de cabeçalhos HTTP
**Método:** GET  
**URL:** `/headers`

Exibe os cabeçalhos enviados pelo navegador, o endereço IP e a versão do protocolo HTTP.

### 2. Manipulação do corpo da requisição
**Método:** POST  
**URL:** `/request-body`

Recebe um formulário HTML com nome, e-mail e mensagem e exibe o corpo da requisição recebida.

### 3. Controle de cookies
**Método:** GET  
**URL:** `/session`

Armazena um cookie para identificar o usuário e reconhece visitas posteriores.

### 4. Testes de status HTTP
**Método:** GET  
**URL:** `/status?code=200`

Permite testar diferentes códigos de resposta HTTP, como 200, 404 e 500.

### 5. Métodos HTTP suportados
**Método:** OPTIONS  
**URL:** `/methods`

Retorna os métodos HTTP disponibilizados pela aplicação por meio do cabeçalho `Allow`.

## Como executar

1. Importe o projeto no Eclipse como projeto Web.
2. Configure o Apache Tomcat 11.
3. Execute a aplicação no servidor.
4. Acesse `http://localhost:8080/AtividadeHTTP/`.

## Testes

Para testar o método OPTIONS pelo terminal:

```bash
curl.exe -i -X OPTIONS http://localhost:8080/AtividadeHTTP/methods
```

## Autor

Nome: Ágabo Monteiro
Curso: Sistemas de Informação

Instituição: IFSULDEMINAS – Campus Machado
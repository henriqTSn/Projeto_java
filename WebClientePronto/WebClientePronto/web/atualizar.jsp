<%-- 
    Author     : Henriq
--%>

<%@page import="model.ClienteRepository"%>
<%@page import="model.Cliente"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Cliente" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Atualizar Cliente</title>
    <link rel="stylesheet" href="newcss.css">
</head>
<body>
    <h1>Atualizar Cliente</h1>
    <form action="atualizar" method="post">
        <input type="hidden" name="id" value="${cliente.id}">

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${cliente.nome}" required placeholder="Ex: João da Silva"><br><br>

        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" value="${cliente.cpf}" required maxlength="11" pattern="\d+" title="Insira apenas números" placeholder="Ex: 12345678901"><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${cliente.email}" required maxlength="30" placeholder="Ex: joao@example.com"><br><br>

        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" value="${cliente.telefone}" required maxlength="11" pattern="\d+" title="Insira apenas números" placeholder="Ex: 11987654321"><br><br>

        <label for="genero">Gênero:</label>
        <select id="genero" name="genero">
            <option value="Masculino" ${cliente.genero == "Masculino" ? "selected" : ""}>Masculino</option>
            <option value="Feminino" ${cliente.genero == "Feminino" ? "selected" : ""}>Feminino</option>
            <option value="Outro" ${cliente.genero == "Outro" ? "selected" : ""}>Outro</option>
        </select><br><br>

        <label for="dataDeNascimento">Data de Nascimento:</label>
        <input type="date" id="dataDeNascimento" name="dataDeNascimento" value="${cliente.dataDeNascimento}" required><br><br>

        <label for="estadoCivil">Estado Civil:</label>
        <select id="estadoCivil" name="estadoCivil">
            <option value="Solteiro(a)" ${cliente.estadoCivil == "Solteiro(a)" ? "selected" : ""}>Solteiro(a)</option>
            <option value="Casado(a)" ${cliente.estadoCivil == "Casado(a)" ? "selected" : ""}>Casado(a)</option>
            <option value="Divorciado(a)" ${cliente.estadoCivil == "Divorciado(a)" ? "selected" : ""}>Divorciado(a)</option>
            <option value="Viúvo(a)" ${cliente.estadoCivil == "Viúvo(a)" ? "selected" : ""}>Viúvo(a)</option>
        </select><br><br>

        <label for="dataCadastro">Data de Cadastro:</label>
        <input type="date" id="dataCadastro" name="dataCadastro" value="${cliente.dataCadastro != null ? cliente.dataCadastro : ''}" required><br><br>

        <label for="endereco">Endereço:</label>
        <input type="text" id="endereco" name="endereco" value="${cliente.endereco}" required maxlength="30" placeholder="Ex: Rua ABC, 123"><br><br>

        <button type="submit">Atualizar Cliente</button>
    </form>
    <a href="consultarTodos.jsp"><button> Voltar </button></a>
</body>
</html>

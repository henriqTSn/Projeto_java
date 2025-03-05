<%-- 
    Author     : Henriq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Cliente</title>
    <link rel="stylesheet" href="newcss.css">
</head>
<body>
    <h1>Cadastro de Cliente</h1>
    <form action="cadastrar" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" maxlength="20" required placeholder="Ex: Pedro Toledo"><br><br>

        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" maxlength="11" required pattern="\d+" title="Insira apenas números" placeholder="Ex: 12345678901"><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" maxlength="30" required placeholder="Ex: pedro@example.com"><br><br>

        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" maxlength="11" required pattern="\d+" title="Insira apenas números" placeholder="Ex: 11987654321"><br><br>

        <label for="genero">Gênero:</label>
        <select id="genero" name="genero">
            <option value="Masculino">Masculino</option>
            <option value="Feminino">Feminino</option>
            <option value="Outro">Outro</option>
        </select><br><br>

        <label for="dataDeNascimento">Data de Nascimento:</label>
        <input type="date" id="dataDeNascimento" name="dataDeNascimento" required><br><br>

        <label for="estadoCivil">Estado Civil:</label>
        <select id="estadoCivil" name="estadoCivil">
            <option value="Solteiro(a)">Solteiro(a)</option>
            <option value="Casado(a)">Casado(a)</option>
            <option value="Divorciado(a)">Divorciado(a)</option>
            <option value="Viúvo(a)">Viúvo(a)</option>
        </select><br><br>

        <label for="dataCadastro">Data de Cadastro:</label>
        <input type="date" id="dataCadastro" name="dataCadastro" required><br><br>

        <label for="endereco">Endereço:</label>
        <input type="text" id="endereco" name="endereco" maxlength="30" required placeholder="Ex: Rua ABC, 123"><br><br>

        <button type="submit">Cadastrar</button>
    </form>
    <a href="index.html"><button>Voltar</button></a>
</body>
</html>


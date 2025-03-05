<%-- 
    Author     : Henriq
--%>

<%@ page import="java.util.List" %>
<%@ page import="model.ClienteRepository" %>
<%@ page import="controller.ConsultarTodosServlet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Cliente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Consultar Cliente por ID</title>
    <link rel="stylesheet" href="newcss.css">
</head>
<body>
    <h1>Consultar Cliente por ID</h1>
    <form method="get" action="consultarById">
        <label for="id">ID do Cliente:</label>
        <input type="text" id="id" name="id" required maxlength="15" pattern="\d+" title="Insira apenas números">
        <button type="submit">Consultar</button>
    </form>

    <%
        Cliente cliente = (Cliente) request.getAttribute("cliente");
        if (cliente != null) {
    %>
        <h2>Detalhes do Cliente</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <td><%= cliente.getId() %></td>
            </tr>
            <tr>
                <th>Nome</th>
                <td><%= cliente.getNome() %></td>
            </tr>
            <tr>
                <th>Gênero</th>
                <td><%= cliente.getGenero() %></td>
            </tr>
            <tr>
                <th>CPF</th>
                <td><%= cliente.getCpf() %></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><%= cliente.getEmail() %></td>
            </tr>
            <tr>
                <th>Telefone</th>
                <td><%= cliente.getTelefone() %></td>
            </tr>
            <tr>
                <th>Data de Nascimento</th>
                <td><%= cliente.getDataDeNascimento() %></td>
            </tr>
            <tr>
                <th>Estado Civil</th>
                <td><%= cliente.getEstadoCivil() %></td>
            </tr>
            <tr>
                <th>Data de Cadastro</th>
                <td><%= cliente.getDataCadastro() %></td>
            </tr>
            <tr>
                <th>Endereço</th>
                <td><%= cliente.getEndereco() %></td>
            </tr>
        </table>
    <%
        } else {
    %>
        <p>Insira o ID de um cliente para consultar seus detalhes.</p>
    <%
        }
    %>
    
    <a href="index.html"><button> Voltar ao início </button></a>
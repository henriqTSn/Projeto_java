<%-- 
    Author     : Henriq
--%>

<%@ page import="java.util.List" %>
<%@ page import="model.ClienteRepository" %>
<%@ page import="controller.ConsultarTodosServlet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Cliente" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Clientes</title>
    <link rel="stylesheet" href="newcss.css">
</head>
<body>
    <h1>Lista de Clientes</h1>
    <%
        ClienteRepository dao = new ClienteRepository();
        List<Cliente> clientes = null;
        try {
            clientes = dao.consultarTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Gênero</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (clientes != null) {
                for (Cliente cliente : clientes) {
        %>
        <tr>
            <td><%= cliente.getId() %></td>
            <td><%= cliente.getNome() %></td>
            <td><%= cliente.getGenero() %></td>
            <td>
                <!-- Botão Deletar -->
                <form method="post" action="DeletarServlet" style="display:inline;">
                    <input type="hidden" name="id" value="<%= cliente.getId() %>">
                    <button type="submit">Deletar</button>
                </form>

                <!-- Botão Editar -->
                <form method="get" action="editar" style="display:inline;">
                    <input type="hidden" name="id" value="<%= cliente.getId() %>">
                    <button type="submit">Editar</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>

    <br>

    <a href="cadastrar.jsp"> <button> Cadastrar </button> </a>
    <a href="consultarById.jsp"> <button> ConsultarById </button> </a>
    <a href="index.html"><button> Voltar ao início </button></a>
</body>
</html>

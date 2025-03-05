
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Resultado</title>
        <link rel="stylesheet" href="newcss.css">
    </head>
    <body>
        <%
           String msg = (String) request.getAttribute("message");
        %>
        
        <h1><%out.println(msg);%> </h1>
        
        
        <a href="index.html"> <button> Voltar </button> </a>
    </body>
</html>

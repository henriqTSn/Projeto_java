/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.ClienteRepository;

/**
 *
 * @author Henriq
 */
@WebServlet("/editar")
public class EditarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); // Obtém o ID do cliente a partir do parâmetro
        ClienteRepository dao = new ClienteRepository(); // Instancia o repositório de cliente

        try {
            // Corrigido o método para buscar cliente por ID
            Cliente cliente = dao.consultarById(id);
            request.setAttribute("cliente", cliente); // Define o cliente como atributo para o JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar.jsp");
            dispatcher.forward(request, response); // Encaminha para o JSP de atualização
        } catch (Exception e) {
            response.sendRedirect("consultarTodos.jsp?error=Erro ao buscar cliente."); // Redireciona em caso de erro
        }
    }
}


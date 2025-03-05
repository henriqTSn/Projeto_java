/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 * henrique t.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import model.Cliente;
import model.ClienteRepository;

@WebServlet(name= "DeletarServlet", urlPatterns={"/DeletarServlet"})
public class DeletarServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Cliente cliente = new Cliente();
        cliente.setId(id);

        ClienteRepository dao = new ClienteRepository();
        try {
            dao.deletar(cliente);
            request.setAttribute("message", "Cliente deletado com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("message", "Erro ao deletar cliente: " + e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("consultarTodos.jsp");
        dispatcher.forward(request, response);
    }
}


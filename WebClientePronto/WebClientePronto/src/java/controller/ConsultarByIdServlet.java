/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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

@WebServlet("/consultarById")
public class ConsultarByIdServlet extends HttpServlet {

    /**
     * Processa requisições do tipo GET para consultar cliente por ID.
     *
     * @param request O objeto HttpServletRequest.
     * @param response O objeto HttpServletResponse.
     * @throws ServletException Em caso de falha ao encaminhar a requisição.
     * @throws IOException Em caso de falha na entrada/saída.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Cliente cliente = new Cliente();
        cliente.setId(id);

        ClienteRepository dao = new ClienteRepository();
        try {
            Cliente resultado = dao.consultarByld(cliente);
            request.setAttribute("cliente", resultado);
            RequestDispatcher dispatcher = request.getRequestDispatcher("consultarById.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("message", "Erro ao consultar cliente: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
    }
}

package controller;

import model.ClienteRepository;
import model.Cliente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet para consultar todos os clientes.
 */
@WebServlet("/consultarTodos")
public class ConsultarTodosServlet extends HttpServlet {

    /**
     * Processa requisições do tipo GET para consultar todos os clientes.
     *
     * @param request O objeto HttpServletRequest.
     * @param response O objeto HttpServletResponse.
     * @throws ServletException Em caso de falha ao encaminhar a requisição.
     * @throws IOException Em caso de falha na entrada/saída.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteRepository dao = new ClienteRepository();
        try {
            List<Cliente> clientes = dao.consultarTodos();
            System.out.println("Número de clientes encontrados: " + clientes.size()); // Adicione esta linha
            request.setAttribute("clientes", clientes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaClientes.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("message", "Erro ao consultar clientes: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
    }
}

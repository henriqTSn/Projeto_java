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

@WebServlet("/atualizar")
public class AtualizarServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            // Continue validando os outros campos...

            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setNome(nome);
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setGenero(request.getParameter("genero"));
            cliente.setDataDeNascimento(request.getParameter("dataDeNascimento"));
            cliente.setEstadoCivil(request.getParameter("estadoCivil"));
            cliente.setDataCadastro(request.getParameter("dataCadastro"));
            cliente.setEndereco(request.getParameter("endereco"));

            ClienteRepository dao = new ClienteRepository();
            dao.atualizar(cliente);

            request.setAttribute("message", "Cliente atualizado com sucesso!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Erro ao atualizar cliente: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
            dispatcher.forward(request, response);
        }
    }
}

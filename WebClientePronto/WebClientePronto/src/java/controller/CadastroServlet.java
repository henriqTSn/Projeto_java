package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import model.ClienteRepository;
import model.Cliente;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
/**
 *
 * @author henrique
 */
public class CadastroServlet extends HttpServlet {
    //olhar esse override com o professor 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String genero = request.getParameter("genero");
        String dataDeNascimento = request.getParameter("dataDeNascimento");
        String estadoCivil = request.getParameter("estadoCivil");
        String dataCadastro = request.getParameter("dataCadastro");
        String endereco = request.getParameter("endereco");

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setGenero(genero);
        cliente.setDataDeNascimento(dataDeNascimento);
        cliente.setEstadoCivil(estadoCivil);
        cliente.setDataCadastro(dataCadastro);
        cliente.setEndereco(endereco);

        ClienteRepository dao = new ClienteRepository();

        try {
            dao.cadastrar(cliente);
            request.setAttribute("message", "Cliente cadastrado com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("message", "Erro ao cadastrar cliente: " + e.getMessage());  
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp"); 
        dispatcher.forward(request, response);

    }
}
////ta funcionando

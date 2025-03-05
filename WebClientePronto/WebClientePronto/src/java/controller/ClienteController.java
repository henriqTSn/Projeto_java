/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClienteRepository;

@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your pageh ere. You may use following sample code. */

            String op = request.getParameter("op");
            ClienteRepository cdao = new ClienteRepository();
            Cliente c = new Cliente();
            try {
                cdao.cadastrar(c);
                System.out.println("Cadastro bem sucedido.");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
            if (op.equals("CADASTRAR")) {
                String nome = request.getParameter("txtnome");
                String cpf = request.getParameter("txtcpf");
                String email = request.getParameter("txtemail");
                String telefone = request.getParameter("txttelefone");
                String genero = request.getParameter("txtgenero");
                String dataDeNascimento = request.getParameter("txtdataDeNascimento");
                String estadoCivil = request.getParameter("txtestadoCivil");
                String dataCadastro = request.getParameter("txtdataCadastro");
                String endereco = request.getParameter("txtendereco");
                c.setNome(nome);
                c.setCpf(cpf);
                c.setEmail(email);
                c.setTelefone(telefone);
                c.setGenero(genero);
                c.setDataDeNascimento(dataDeNascimento);
                c.setEstadoCivil(estadoCivil);
                c.setDataCadastro(dataCadastro);
                c.setEndereco(endereco);
                String msg = "Cadastrar";
                try {
                    cdao.cadastrar(c);
                    System.out.println("Cadastrado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);

                }
            } else if (op.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                c.setId(id);
                String msg = "Deletar";
                try {
                    cdao.deletar(c);
                    List<Cliente> lcli = cdao.consultarTodos();
                    request.setAttribute("lcrod", lcli);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else if (op.equals("CONSULTAR BY ID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                c.setId(id);
                try {
                    c = cdao.consultarByld(c);
                    request.setAttribute("c", c);
                    request.getRequestDispatcher("resultadocosultarbyid.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR TODOS")) {
                //NÃO IMPLEMENTADO
                try {
                    List<Cliente> lcli = cdao.consultarTodos();
                    request.setAttribute("lcli", lcli);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }

            } else if (op.equals("ATUALIZAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                c.setId(id);
                try {
                    c = cdao.consultarByld(c);
                    request.setAttribute("c", c);
                    request.getRequestDispatcher("resultadocosultaratualizar.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }/////
            } else if (op.equals("EFETIVAR ATUALIZAÇÃO")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                String nome = request.getParameter("txtdescricao");
                String cpf = request.getParameter("txtcpf");
                String email = request.getParameter("txtemail");
                String telefone = request.getParameter("txttelefone");
                String genero = request.getParameter("txtgenero");
                String dataDeNascimento = request.getParameter("txtdataDeNascimento");
                String estadoCivil = request.getParameter("txtestadoCivil");
                String dataCadastro = request.getParameter("txtdataCadastro");
                String endereco = request.getParameter("txtendereco");
                c.setId(id);
                c.setNome(nome);
                c.setCpf(cpf);
                c.setEmail(email);
                c.setTelefone(telefone);
                c.setGenero(genero);
                c.setDataDeNascimento(dataDeNascimento);
                c.setEstadoCivil(estadoCivil);
                c.setDataCadastro(dataCadastro);
                c.setEndereco(endereco);
                String msg = "Atualizar";
                try {
                    cdao.atualizar(c);
                    System.out.println("Atuaizado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

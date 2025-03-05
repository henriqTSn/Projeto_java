package model;

import util.ConexaoDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Henriq
 */
public class ClienteRepository {
    public void cadastrar (Cliente cli)throws ClassNotFoundException, SQLException{
    Connection con = ConexaoDB.getConexao();
    PreparedStatement comando = con.prepareStatement("insert into cliente(nome, cpf, email, telefone, genero, dataDeNascimento, estadoCivil, dataCadastro, endereco) values(?,?,?,?,?,?,?,?,?)");
    comando.setString(1,cli.getNome());
    comando.setString(2,cli.getCpf());
    comando.setString(3,cli.getEmail());
    comando.setString(4,cli.getTelefone());
    comando.setString(5,cli.getGenero());
    comando.setString(6,cli.getDataDeNascimento());
    comando.setString(7,cli.getEstadoCivil());
    comando.setString(8,cli.getDataCadastro());
    comando.setString(9,cli.getEndereco());
    comando.execute();
    con.close();    
    }
    
    public void deletar(Cliente cli)throws ClassNotFoundException,SQLException{
    Connection con = ConexaoDB.getConexao();
    PreparedStatement comando = con.prepareStatement("delete from cliente where id = ?");
    comando.setInt(1, cli.getId());
    comando.executeUpdate();
    con.close();
    }  
    
    public void atualizar(Cliente cli)throws ClassNotFoundException,SQLException{
    Connection con = ConexaoDB.getConexao();
    PreparedStatement comando = con.prepareStatement("update cliente set nome = ?, cpf = ?, email = ?, telefone = ?, genero = ?, dataDeNascimento = ?, estadoCivil = ?, dataCadastro = ?, endereco = ? where id = ?");
    comando.setString(1,cli.getNome());
    comando.setString(2,cli.getCpf());
    comando.setString(3,cli.getEmail());
    comando.setString(4,cli.getTelefone());
    comando.setString(5,cli.getGenero());
    comando.setString(6,cli.getDataDeNascimento());
    comando.setString(7,cli.getEstadoCivil());
    comando.setString(8,cli.getDataCadastro());
    comando.setString(9,cli.getEndereco());
    comando.setInt(10, cli.getId());
    comando.executeUpdate();
    con.close();  
    }
    
    public Cliente consultarByld(Cliente cli)throws ClassNotFoundException,SQLException{
    Connection con = ConexaoDB.getConexao();
    PreparedStatement comando = con.prepareStatement("select * from cliente where id = ?");
    comando.setInt(1, cli.getId());
    ResultSet rs = comando.executeQuery();
    Cliente c = new Cliente();
    if(rs.next()){
        c.setId(rs.getInt("id"));
        c.setNome(rs.getString("nome"));
        c.setCpf(rs.getString("cpf"));
        c.setEmail(rs.getString("email"));
        c.setTelefone(rs.getString("telefone"));
        c.setGenero(rs.getString("genero"));
        c.setDataDeNascimento(rs.getString("dataDeNascimento"));
        c.setEstadoCivil(rs.getString("estadoCivil"));
        c.setDataCadastro(rs.getString("dataCadastro"));
        c.setEndereco(rs.getString("endereco"));
    }
    con.close();
    return c;
    }
    public List<Cliente> consultarTodos() throws ClassNotFoundException, SQLException {
    Connection con = ConexaoDB.getConexao();
    PreparedStatement comando = con.prepareStatement("select * from cliente");
    ResultSet rs = comando.executeQuery();
    List<Cliente> Icli = new ArrayList<>();
    while (rs.next()) {
        Cliente cli = new Cliente();
        cli.setId(rs.getInt("id"));
        cli.setNome(rs.getString("nome"));
        cli.setCpf(rs.getString("cpf"));
        cli.setEmail(rs.getString("email"));
        cli.setTelefone(rs.getString("telefone"));
        cli.setGenero(rs.getString("genero"));
        cli.setDataDeNascimento(rs.getString("dataDeNascimento"));
        cli.setEstadoCivil(rs.getString("estadoCivil"));
        cli.setDataCadastro(rs.getString("dataCadastro"));
        cli.setEndereco(rs.getString("endereco"));

        Icli.add(cli); // Adiciona o cliente na lista
        System.out.println(cli);

    }
    con.close();
    return Icli;
    }

    public Cliente consultarById(int id) throws ClassNotFoundException, SQLException {
    Connection con = ConexaoDB.getConexao();
    PreparedStatement comando = con.prepareStatement("select * from cliente where id = ?");
    comando.setInt(1, id);
    ResultSet rs = comando.executeQuery();
    Cliente cliente = null;
    if (rs.next()) {
        cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setEmail(rs.getString("email"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setGenero(rs.getString("genero"));
        cliente.setDataDeNascimento(rs.getString("dataDeNascimento"));
        cliente.setEstadoCivil(rs.getString("estadoCivil"));
        cliente.setDataCadastro(rs.getString("dataCadastro"));
        cliente.setEndereco(rs.getString("endereco"));
    }
    con.close();
    return cliente;
}

}
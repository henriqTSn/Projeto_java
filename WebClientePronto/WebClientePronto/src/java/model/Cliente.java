/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Henriq.
 */
public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String genero;
    private String dataDeNascimento;
    private String estadoCivil;
    private String dataCadastro;
    private String endereco;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getGenero() {
        return genero;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public String getEndereco() {
        return endereco;
    }
  
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public String toString(){
        return"\nId..:"+ id+"\nNome..:"+ nome +"\nCpf..:"+ cpf +"\nEmail..:"+ email +"\nTelefone..:"+ telefone +"\nGenero"+ genero +"\nDataDeNascimento"+ dataDeNascimento +"\nEstadoCivil"+ estadoCivil +"\nDataCadastro"+ dataCadastro +"\nEndereco"+ endereco;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vo;

import java.sql.Date;

/**
 *
 * @author brunacm
 */
public class Senha {
    private int id_senha;    
    private Date data_senha;
    private int cpf_cliente;
    private String nome_cliente;
    private String senha_cliente;
    private String status_atendimento;
    private Date data_atendimento_ini;
    private Date data_atendimento_fim;
    private int id_usuario_atendente;

    public int getId_senha() {
        return id_senha;
    }

    public void setId_senha(int id_senha) {
        this.id_senha = id_senha;
    }

    public Date getData_senha() {
        return data_senha;
    }

    public void setData_senha(Date data_senha) {
        this.data_senha = data_senha;
    }

    public int getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(int cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getSenha_cliente() {
        return senha_cliente;
    }

    public void setSenha_cliente(String senha_cliente) {
        this.senha_cliente = senha_cliente;
    }

    public String getStatus_atendimento() {
        return status_atendimento;
    }

    public void setStatus_atendimento(String status_atendimento) {
        this.status_atendimento = status_atendimento;
    }

    public Date getData_atendimento_ini() {
        return data_atendimento_ini;
    }

    public void setData_atendimento_ini(Date data_atendimento_ini) {
        this.data_atendimento_ini = data_atendimento_ini;
    }

    public Date getData_atendimento_fim() {
        return data_atendimento_fim;
    }

    public void setData_atendimento_fim(Date data_atendimento_fim) {
        this.data_atendimento_fim = data_atendimento_fim;
    }

    public int getId_usuario_atendente() {
        return id_usuario_atendente;
    }

    public void setId_usuario_atendente(int id_usuario_atendente) {
        this.id_usuario_atendente = id_usuario_atendente;
    }
 
    
}

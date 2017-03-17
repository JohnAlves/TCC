/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dao;

import edu.vo.Senha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author brunacm
 */
public class SenhaDao extends Dao {
    
    public int geraSenha() {
        Connection conn = null;
        int id_sequencia = 0;
        
        try {
            //obtem conexao com o banco de dados
            conn = getConnection();
            conn.setAutoCommit(false);
            //antes de gerar senha chama metodo cadastro cliente 
            //define SQL para inser��o
            String sql = "INSERT INTO tab_senhas(id_senha, data_senha, cpf_cliente, nm_cliente, senha_cliente, status_atendimento) VALUES (? , curdate(), ?, ?, ?, 'Ativo'); ";    
            //instance Prepared statement especificando os par�metros do SQL
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            stmt.setInt(1, getProximaSenha());
            stmt.setInt(2, 122); //informar CPF digitado pelo usuário
            stmt.setString(3, "nome"); //informar nome digitado pelo usuário
            stmt.setString(4, "senha"); //informar senha digitado pelo usuário                      

            //executa a opera��o no banco de dados
            int affectedRows = stmt.executeUpdate();
            //verifica se deu certo. Se sim, obtem a chave id_senha gerada 
            if (affectedRows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()){
                    id_sequencia = rs.getInt(1);
                    System.out.println("if senha: " + id_sequencia);
                }else {
                    System.out.println("erro"); 
                }
            } else {
                //cancela as modifica��es no banco de dados
                conn.rollback();
                return 0;
            }
                //confirma as modifica��es no banco de dados
                conn.commit();
                return id_sequencia;

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception closeEx) {
                    //do nothing
                }
            }
        }
    }    
    
    public int getProximaSenha() {
        Connection conn = null;

        try {
            conn = getConnection();

            String sql = "SELECT IFNULL(max(id_senha+1),1) id_senha FROM tab_senhas WHERE data_senha = CURDATE()";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                int id_senha = result.getInt("id_senha");
                return id_senha;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception closeEx) {
                    //do nothing
                }
            }
        }
    }

    public Senha retornaSenha(int id_sequencia) {
        Connection conn = null;
        Senha senha = new Senha();

        try {
            conn = getConnection();

            String sql = "SELECT id_sequencia, id_senha, data_senha, cpf_cliente, nm_cliente, senha_cliente, status_atendimento, data_atendimento_ini, data_atendimento_fim, id_usuario FROM tab_senhas WHERE id_sequencia = ?";
            
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_sequencia);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {                
                senha.setId_sequencia(result.getInt(1));
                senha.setId_senha(result.getInt(2));
                senha.setData_senha(result.getDate(3));
                senha.setCpf_cliente(result.getInt(4));
                senha.setNome_cliente(result.getString(5));
                senha.setSenha_cliente(result.getString(6));
                senha.setStatus_atendimento(result.getString(7));
                senha.setData_atendimento_ini(result.getDate(8));
                senha.setData_atendimento_fim(result.getDate(9));
                senha.setId_usuario_atendente(result.getInt(10));
                return senha;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception closeEx) {
                    //do nothing
                }
            }
        }
    }
    
    public boolean cancelaSenha(int id_senha) {
        Connection conn = null;
        
        try {
            //obtem conexao com o banco de dados
            conn = getConnection();
            conn.setAutoCommit(false);
            //antes de gerar senha chama metodo cadastro cliente 
            //define SQL para inser��o
            String sql = "UPDATE tab_senhas set status_atendimento = 'Cancelado' WHERE id_senha = ? and data_senha = CURDATE();";    
            //instance Prepared statement especificando os par�metros do SQL
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            stmt.setInt(1, id_senha);
            
            //executa a opera��o no banco de dados
            int affectedRows = stmt.executeUpdate();
            //verifica se deu certo. Se sim, obtem a chave id_senha gerada 
            if (affectedRows > 0) {
                conn.commit();
                return true;
            } else {
                //cancela as modifica��es no banco de dados
                conn.rollback();
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception closeEx) {
                    //do nothing
                }
            }
        }
    }
}
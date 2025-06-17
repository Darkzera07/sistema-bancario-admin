/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.dao;

import com.mysql.cj.protocol.Resultset;
import com.unincor.sistema.bancario.admin.configurations.Mysql;
import com.unincor.sistema.bancario.admin.model.domain.Funcionario;
import com.unincor.sistema.bancario.admin.model.domain.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunos
 */
public class FuncionarioDao  {
	public Funcionario inserirFuncionario(Funcionario funcionario){
		String sql ="INSERT INTO funcionarios(nome, cpf, data_nascimento,"
			+ "email, telefone, senha_hash, turno)VALUES (?, ?, ?, ?, ?, ?, ?,)";
		try {Connection con = Mysql.connect(); PreparedStatement ps = con.prepareStatement(sql);{
			ps.setString(1, "nome");
			ps.setString(2, "cpf");
			ps.setDate(3,Date.valueOf("data_nascimento"));
			ps.setString(4, "email");
			ps.setString(5, "telefone");
			ps.setString(6, "senha_hash");
			ps.setString(7, "turno");
			
		}
			
		} catch (SQLException ex) {
			Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	return funcionario;	
		
	}
	
	public Funcionario buscarFuncionarioPorId(Long id_funcionario){
		String sql = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
                try {Connection con = Mysql.connect(); PreparedStatement ps = con.prepareStatement(sql);{
                   ps.setLong(1, id_funcionario);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                     return construirFuncionarioSql(rs);
                    } 
                }
                
            } catch (SQLException ex) {
                
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
	return null;	
		
	}

        public List<Funcionario> buscarTodosFuncionarios(){
            List<Funcionario> funcionarios = new ArrayList<>();
            String sql = "SELECT * FROM funcionarios";
            try {Connection con = Mysql.connect(); PreparedStatement ps = con.prepareStatement(sql);{
             ResultSet rs = ps.executeQuery();
               while (rs.next()) {
                   var funcionaario = construirFuncionarioSql(rs);
                   funcionarios.add(funcionaario);
               }
            }
                
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return funcionarios;
        }
        public Funcionario construirFuncionarioSql(ResultSet rs) throws SQLException{
            Funcionario funcionario = new Funcionario();
       funcionario.setIdFuncionario(rs.getLong("id_funcionario"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
            funcionario.setEmail(rs.getString("email"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionario.setSenhaHash(rs.getString("senha_hash"));
            funcionario.setTurno(rs.getString("turno"));
            return funcionario;
        }
        
}

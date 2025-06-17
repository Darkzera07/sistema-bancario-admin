/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.dao;

import com.unincor.sistema.bancario.admin.configurations.Mysql;
import com.unincor.sistema.bancario.admin.model.domain.Funcionario;
import com.unincor.sistema.bancario.admin.model.domain.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunos
 */
public class FuncionarioDao extends Pessoa {
	public void inserirFuncionario(Funcionario funcionario){
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
	}
}

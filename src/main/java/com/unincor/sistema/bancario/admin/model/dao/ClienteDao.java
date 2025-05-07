/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.dao;

import com.unincor.sistema.bancario.admin.model.domain.Cliente;
import java.sql.Connection;

/**
 *
 * @author alunos
 */
public class ClienteDao {
	public Cliente inserirCleinte(Cliente cliente){
	String sql = "INSERT INTO clientes(nome, cpf, data_nascimento, email, "
		+ "telefone, senha_hash) VALUES ( ?, ? ,? ,? ,? ,? )";
	try(Connection con = MySQL.connect();preparedStatement ps = con.prepareStatement(sql)){ 
		
	}
	}
	
}

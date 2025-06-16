/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.dao;

import com.unincor.sistema.bancario.admin.configurations.Mysql;
import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import com.unincor.sistema.bancario.admin.model.domain.Gerente;
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
 * @author Gabriel
 */
public class GerenteDao {

    
    
    public void inserirGerente(Gerente gerente){
        String sql = "INSERT INTO gerentes(nome, cpf, data_nascimento, email, telefone, senha_hash, agencia) VALUES (?, ?, ?, ?, ?, ?, ?) ";
        try (Connection con = Mysql.connect(); PreparedStatement ps = con.prepareStatement(sql)){
        ps.setString(1, gerente.getNome());
        ps.setString(2, gerente.getCpf());
        ps.setDate(3, Date.valueOf(gerente.getDataNascimento()));
        ps.setString(4, gerente.getEmail());
        ps.setString(5, gerente.getTelefone());
        ps.setString(6, gerente.getSenhaHash());
        ps.setLong(7, gerente.getAgencia().getIdAgencia());
        ps.execute();
            
        } catch (Exception ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Gerente> listarTogosGerentes(){
       String sql = "SELECT * FROM gerentes";
       List<Gerente> gerentes = new ArrayList<>();
        try {Connection con = Mysql.connect(); PreparedStatement ps = con.prepareStatement(sql); {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gerentes.add(construirGenrenteSql(rs));
            }
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);  
    }
        return gerentes;
    }
    
    
 
 
    public Gerente buscarGerentePorId(Long id_gerente){
        String sql ="SELECT * FROM gerentes WHERE id_gerente = ?";
        try {Connection con = Mysql.connect(); PreparedStatement ps = con.prepareStatement(sql); {
            ps.setLong(1, id_gerente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return construirGenrenteSql(rs);
            }
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Gerente construirGenrenteSql(ResultSet rs) throws SQLException {
        Gerente gerente = new Gerente();
        gerente.setIdGerente(rs.getLong("id_gerente"));
        gerente.setNome(rs.getString("nome"));
        gerente.setCpf(rs.getString("cpf"));
        gerente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        gerente.setEmail(rs.getString("email"));
        gerente.setTelefone(rs.getString("telefone"));
        gerente.setSenhaHash(rs.getString("senha_hash"));
        
        Agencia agencia = new Agencia();
        agencia.setIdAgencia(rs.getLong("agencia"));
        gerente.setAgencia(agencia);
        
        return gerente;
        
    }
}









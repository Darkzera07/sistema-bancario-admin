/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.model.dao.GerenteDao;
import com.unincor.sistema.bancario.admin.model.domain.Gerente;
import com.unincor.sistema.bancario.admin.model.exception.CadastroException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class GerenteService {
    private final GerenteDao gerenteDao = new GerenteDao();
    public void ValidarIdGerente(Long id) throws CadastroException {
    if (id == null || id <= 0) {
        throw new CadastroException("ID inválido.");
    }
     Gerente gerenteExistente = gerenteDao.buscarGerentePorId(id);
     if (gerenteExistente != null){
         throw new CadastroException("Já existe um gerente cadastrado com este ID.");
     }
     gerenteDao.inserirGerente(gerenteExistente);
    }
    public List<Gerente> BuscarGerentes (){
        return gerenteDao.listarTogosGerentes();
    }
}

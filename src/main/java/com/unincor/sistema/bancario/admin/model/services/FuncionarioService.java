/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.model.dao.FuncionarioDao;
import com.unincor.sistema.bancario.admin.model.domain.Funcionario;
import com.unincor.sistema.bancario.admin.model.exception.CadastroException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class FuncionarioService {
    private final FuncionarioDao funcionarioDao = new FuncionarioDao();
    public void salvarFuncionario(Funcionario funcionario) throws CadastroException{
        if(funcionario.getNome() == null || funcionario.getNome().isBlank()){
            throw new CadastroException("Funcionário não possui nome.");
        }
        
        if(funcionario.getCpf() == null || funcionario.getCpf().isBlank()){
            throw new CadastroException("Funcionário não informou email.");
        }
        funcionarioDao.inserirFuncionario(funcionario);
    }
    public List<Funcionario> BuscarFuncionario(){
      return funcionarioDao.buscarTodosFuncionarios();
    }
            
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.model.dao.ClienteDao;
import com.unincor.sistema.bancario.admin.model.domain.Cliente;
import com.unincor.sistema.bancario.admin.model.exception.CadastroException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class ClienteService {
    private final ClienteDao clienteDao = new ClienteDao();
    public void salvarCliente(Cliente cliente) throws CadastroException{
        if(cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new CadastroException("o cliente não possui um código cliente.");
          
        }
        if(cliente.getCpf() == null || cliente.getCpf().isBlank()){
            throw new CadastroException("o cliente não possui cpf");
        }
        clienteDao.inserirCliente(cliente);
    }
    public List<Cliente> buscarCliente(){
       return clienteDao.buscarTodosClientes();
    }
            
}

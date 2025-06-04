/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.model.dao.AgenciaDao;
import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import com.unincor.sistema.bancario.admin.model.exception.CadastroException;
import java.util.List;

/**
 *
 * @author alunos
 */
public class AgenciaServices {

	private final AgenciaDao agenciaDao = new AgenciaDao();

	public void salvarAgencia(Agencia agencia) throws CadastroException {
		if (agencia.getCodigoAgencia() == null
			|| agencia.getCodigoAgencia().isBlank()) {
			throw new CadastroException("A agencia não possui "
				+ "um codigo de agência!");
		}

		//criar uma validação se o código de agência já está cadastrado
		if(agenciaDao.buscarAgenciaPorCodigoAgencia(agencia.getCodigoAgencia())
			!= null){
			throw new ClassCastException("codigo da Agencia já está"
			+ "cadastrado!");
		}
		
		agenciaDao.inserirAgencia(agencia);
	}
	
	public List<Agencia> buscarAgencias () {
		return agenciaDao.listarTodasAgencias();
	}
	
	
}

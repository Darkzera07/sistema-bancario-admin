/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.model.dao.AgenciaDao;
import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import com.unincor.sistema.bancario.admin.model.exception.CadastroException;

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
	//public static void main(String[] args) {
		//AgenciaServices agenciaServices = new AgenciaServices();
		
		//Agencia agencia = new Agencia( null, null, "Três Corações", "MG",
		//"Rei Pelé", "468798", "374100000" );
		
		//try {
			//agenciaServices.salvarAgencia(agencia);
		//} catch (CadastroException) {
			
		//}
	//}
}

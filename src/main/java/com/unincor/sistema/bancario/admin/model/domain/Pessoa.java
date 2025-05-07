/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.domain;

import java.time.LocalDate;

/**
 *
 * @author alunos
 */
public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected LocalDate dataNascimento;
	protected String email;
	protected String telefone;
	protected String senha_hash;
	
	

	public Pessoa() {
	}
	

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getSenha_hash() {
		return senha_hash;
	}
	
	
}

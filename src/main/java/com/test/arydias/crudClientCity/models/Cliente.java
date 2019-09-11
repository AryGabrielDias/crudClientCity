package com.test.arydias.crudClientCity.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private String sexo;
	
	private String data_nascimento;
	
	private int idade;
	
	private int cidade_id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(int cidade_id) {
		this.cidade_id = cidade_id;
	}
	
	
}

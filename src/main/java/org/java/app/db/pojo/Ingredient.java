package org.java.app.db.pojo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	//RELAZIONE TABELLA INGREDIENTI
	@ManyToMany(mappedBy = "ingredients")
	private List<Pizza> pizze;

	//COSTRUTTORE
	public Ingredient() {}
	public Ingredient(String nome) {
		
		setNome(nome);
	}
	
	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//NOME
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//PIZZA
	public List<Pizza> getPizze() {
		return pizze;
	}
	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}
	
	
	@Override
	public String toString() {
		
		return "[" + getId() + "]" + getNome();
	}

}
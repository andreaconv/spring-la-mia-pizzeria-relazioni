package org.java.app.db.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Special {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private LocalDate specialDate;
	
	@Column(nullable = false)
	private LocalDate returnDate;
	
	@Column(nullable = false)
	private String titolo;
	
	//RELAZIONE TABELLA PIZZA
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pizza pizza;
	
	//COSTRUTTORE
	public Special() {}
	public Special(int id, LocalDate specialDate, LocalDate returnDate, String titolo, Pizza pizza) {
		
		setId(id);
		setSpecialDate(specialDate);
		setReturnDate(returnDate);
		setTitolo(titolo);
		setPizza(pizza);
	}

	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	//SPECIAL DATE
	public LocalDate getSpecialDate() {
		return specialDate;
	}
	public void setSpecialDate(LocalDate specialDate) {
		this.specialDate = specialDate;
	}

	//RETURN DATE
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	//TITOLO
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	//PIZZA
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getTitolo() + "\nDate: " + getSpecialDate() + " ~ " + getReturnDate();
	}
	
	
}

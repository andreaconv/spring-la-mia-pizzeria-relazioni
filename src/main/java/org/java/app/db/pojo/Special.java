package org.java.app.db.pojo;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

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

	//TITOLO
	@Column(nullable = false)
	@Length(min = 3, max = 255)
	private String titolo;

	//DATA INIZIO
	@Column(nullable = false)
	private LocalDate specialDate;
	
	//DATA FINE
	@Column(nullable = false)
	private LocalDate returnDate;
	
	//RELAZIONE TABELLA PIZZA
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pizza pizza;
	
	//COSTRUTTORE
	public Special() {}
	public Special(String titolo, Pizza pizza, LocalDate specialDate, LocalDate returnDate) {
		
		setTitolo(titolo);
		setSpecialDate(specialDate);
		setReturnDate(returnDate);
		setPizza(pizza);
	}

	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	//TITOLO
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
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

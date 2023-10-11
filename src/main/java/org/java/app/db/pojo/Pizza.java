package org.java.app.db.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//NOME
	@Column(length = 128, nullable = false)
	@NotBlank(message = "Il nome non può essere vuoto")
	@Length(
		min = 3, 
		max = 255, 
		message = "Il nome deve essere composte da 3~128 caratteri"
	)
	private String nome;
	
	
	//DESCRIZIONE
	@Column(length = 255, nullable = false)
	@Length(
		min = 3, 
		max = 255, 
		message = "Gli ingredienti devono essere composti da 3~255 caratteri"
	)
	private String descrizione;
	
	
	//FOTO
	@Column(unique = true)
	@Nullable
	private String foto;
	
	
	//PREZZO
	@NotNull(message = "Inserire il prezzo")
	@DecimalMin(value = "0.00", inclusive = false, message="Il prezzo non può essere inferiore o uguale a 0")
	private float prezzo;
	

	//COSTRUTTORE
	public Pizza() { }
	public Pizza(String nome, String descrizione, String foto, float prezzo) {

		setId(id);
		setNome(nome);
		setDescrizione(descrizione);
		setFoto(foto);
		setPrezzo(prezzo);
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

	//DESCRIZIONE
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	//FOTO(URL)
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	//PREZZO
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public String getFormattedPrice() {
		return String.format("%.2f", prezzo);
	}

	@Override
	public String toString() {
		return "[" + getId() + "] Pizza: \n"
				+ "nome: " + getNome() + "\n"
				+ "descrizione: " + getDescrizione() + "\n"
				+ "nome foto: " + getFoto() + "\n"
				+ "prezzo: " + getPrezzo();
		
	}

}

package com.montassar.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
public class Developpeur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDeveloppeur;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nom;
	@Min(value = 300)
	@Max(value = 10000)
	private Double salaire;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@PastOrPresent
	private Date dateEmbauche;
	
	public Developpeur()
	{
		super();
	}
	public Developpeur(String nom, Double salaire, Date dateEmbauche) {
		super();
		this.nom = nom;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
	}
	public Long getIdDeveloppeur() {
		return idDeveloppeur;
	}
	public void setIdDeveloppeur(Long idDeveloppeur) {
		this.idDeveloppeur = idDeveloppeur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	@Override
	public String toString() {
		return "Developpeur [idDeveloppeur=" + idDeveloppeur + ", nom=" + nom + ", salaire=" + salaire
				+ ", dateEmbauche=" + dateEmbauche + "]";
	}
	
	

}

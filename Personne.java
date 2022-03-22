package com.formation.rookie08.heritage.bibliotheque;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Personne {
	private int numPersonne;
	private String nom;
	private String prenom;
	private Date dateNaissance;

	public Personne(){
		
	}
	/**
	 * 
	 * @param numPersonne
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 */
	public Personne(int numPersonne, String nom, String prenom, Date dateNaissance){
		this.numPersonne=numPersonne;
		this.nom=nom;
		this.prenom=prenom;
		this.dateNaissance=dateNaissance;
	}
	/**
	 * 
	 * @param numPersonne
	 * @param nom
	 * @param Prenom
	 */
	public Personne(int numPersonne, String nom, String prenom){
		
		this.numPersonne=numPersonne;
		this.nom=nom;
		this.prenom=prenom;
	}
	public int getNumPersonne(){
		return numPersonne;
	}
	public void setNumPersonne(int numPersonne){
		this.numPersonne=numPersonne;
	}
	public String getNom(){
		return nom;
	}
	public void setNom(String nom){
		this.nom=nom;
	}
	public String getPrenom(){
		return prenom;
	}
	public void setPrenom(String prenom){
		this.prenom=prenom;
	}
	public Date getDate(){
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance){
		this.dateNaissance=dateNaissance;
	}
	@Override
	public String toString() {
		return "Personne [numPersonne=" + numPersonne + ", nom=" + nom
				+ ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ "]";
	}
}

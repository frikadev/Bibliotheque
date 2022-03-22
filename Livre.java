package com.formation.rookie08.heritage.bibliotheque;

import java.util.Date;

public class Livre {
	private int numLivre;
	private String isbnLivre;
	private String titreLivre;
	private Date datePublication;
	private Personne auteur;
	/**
	 * 
	 * @param numLivre
	 */
	public void setNumLivre(int numLivre){
		this.numLivre=numLivre;
	}
	public int getNumLivre(){
		return numLivre;
	}
	public void setIsbnLivre(String isbnLivre){
		this.isbnLivre=isbnLivre;
	}
	public String getIsbnLivre(){
		return isbnLivre;
	}
	public void setTitreLivre(String titreLivre){
		this.titreLivre=titreLivre;
	}
	public String getTitreLivre(){
		return titreLivre;
	}
	public void setDatePublication(Date datePublication){
		this.datePublication=datePublication;
	}
	public Date getDatePublication(){
		return datePublication;
	}
	public void setAuteur(Personne adherent){
		this.auteur=adherent;
	}
	public Personne getAuteur(){
		return auteur;          
	}
	@Override
	public String toString() {
		return "Livre [numLivre=" + numLivre + ", isbnLivre=" + isbnLivre
				+ ", titreLivre=" + titreLivre + ", datePublication="
				+ datePublication + ", auteur=" + auteur + "]";
	}
	

}

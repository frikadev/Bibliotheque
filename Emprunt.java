package com.formation.rookie08.heritage.bibliotheque;

import java.util.Date;

public class Emprunt {
	private int numEmprunt;
	private Personne adherent;
	private Livre book;
	private Date dateEmprunt;
	private Date dateRetour;
	
	public Emprunt(){
		
	}
	/**
	 * 
	 * @param numEmprunt
	 * @param adherent
	 * @param book
	 * @param dateEmprunt
	 * @param dateRetour
	 */
	public Emprunt(int numEmprunt, Personne adherent, Livre book, Date dateEmprunt, Date dateRetour){
		this.adherent=adherent;
		this.book=book;
		this.dateEmprunt=dateEmprunt;
		this.dateRetour=dateRetour;
	}
	public int getNumEmprunt(){
		return numEmprunt;
	}
	public void setNumEmprunt(int numEmprunt) {
		this.numEmprunt = numEmprunt;
	}
	public Personne getAdherent() {
		return adherent;
	}
	public void setAdherent(Personne adherent) {
		this.adherent = adherent;
	}
	public Livre getBook() {
		return book;
	}
	public void setBook(Livre book) {
		this.book = book;
	}
	public Date getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	//@Override
	public String toString() {
		return "Emprunt [numEmprunt=" + numEmprunt + ", adherent=" + adherent
				+ ", book=" + book + ", dateEmprunt=" + dateEmprunt
				+ ", dateRetour=" + dateRetour + "]";
	}
	
	
}

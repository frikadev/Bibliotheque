package com.formation.rookie08.heritage.bibliotheque;

import java.util.ArrayList;

public class FrikaBook implements IBibliotheque{
	private ArrayList books=new ArrayList();
	private ArrayList adherents=new ArrayList();
	private ArrayList emprunts=new ArrayList();
	
	@Override
	public void enregistrerLivre(Livre book){
		this.books.add(book);
	}
	@Override
	public void enregistrerAdherent(Personne adherent){
		this.adherents.add(adherent);
	}
	@Override
	public void emprunterLivre(Emprunt emprunt){
		this.emprunts.add(emprunt);
	}
	@Override
	public void rendreLivre(Livre book){
		this.emprunts.remove(book);
		
	}
	@Override
	public void sortirLivre(Livre book){
		this.books.remove(book);
	}
	@Override
	public void radierAdherent(Personne adherent){
		this.adherents.remove(adherent);
		
	}
	
	public ArrayList getBooks(){
		return books;
	}
	public void setBooks(ArrayList books){
		this.books=books;
	}
	public void setAdherent(ArrayList adherents){
		this.adherents=adherents;
	}
	public ArrayList getAdherents(){
		return adherents;
	}
	public ArrayList getEmprunts(){
		return emprunts;
	}
	public void setEmprunts(ArrayList emprunts){
		this.emprunts=emprunts;
	}
	
	

}

package com.formation.rookie08.heritage.bibliotheque;

public interface IBibliotheque {
	/**
	 * 
	 * @param book
	 */
	public void enregistrerLivre(Livre book);
	/**
	 * 
	 * @param adherent
	 */
	public void enregistrerAdherent(Personne adherent);
	/**
	 * 
	 * @param book
	 * @param adherent
	 */
	public void emprunterLivre(Emprunt emprunteur);
	/**
	 * 
	 * @param book
	 */
	public void rendreLivre(Livre book);
	/**
	 * 
	 * @param book
	 */
	public void sortirLivre(Livre book);
	/**
	 * 
	 * @param adherent
	 */
	public void radierAdherent(Personne adherent);
		
	

}

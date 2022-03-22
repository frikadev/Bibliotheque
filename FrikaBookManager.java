package com.formation.rookie08.heritage.bibliotheque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class FrikaBookManager {
	Scanner clavier=new Scanner(System.in);
	private Hashtable idProviderHT=new Hashtable();
	FrikaBook bibliotheque=new FrikaBook();
	protected static final SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * 
	 */
	public FrikaBookManager(){
		initializeIdgen();
	}
	/**
	 * 
	 */
	private void initializeIdgen(){
		idProviderHT.put("idAuteur", new Integer(1));
		idProviderHT.put("idLivre", new Integer(1));
		idProviderHT.put("idAdherent", new Integer(1));
		idProviderHT.put("idEmprunt", new Integer(1));
	}
	/**
	 * 
	 */
	public void generateMainMenu(){
		boolean loopApp=true;
		while(loopApp){
			int choixMenu;
			System.out.println("1 - Gestion des livres");
			System.out.println("2 - Gestion des adhérents");
			System.out.println("3 - Gestion des emprunts");
			choixMenu=this.clavier.nextInt();
			if(choixMenu!=1 && choixMenu!=2 && choixMenu!=3)
				choixMenu=-1;
			menuDispatcher(choixMenu);
			System.out.println("Continuer d'utiliser l'Application ? oui(o)/non(n)");
			String response=clavier.next();
			if(response.equalsIgnoreCase("n")|| response.equalsIgnoreCase("non"))
				loopApp=false;
		}
	}
	private void menuDispatcher(int menuItem){
		switch(menuItem){
		case 1: checkBookSubMenu();
		break;
		case 2: checkSubscriberSubMenu();
		break;
		case 3: checkEmpruntSubMenu();
		break;
		case 11: enregistrerLivre();
		break;
		case 12: sortirLivre();
		break;
		case 21: enregistrerAdherent();
		break;
		case 22: radierAdherent();
		break;
		case 31: emprunterLivre();
		break;
		case 32: retourEmprunt();
		break;
		default: System.out.println("Choix incorrect!!!");
		}
	}
	/**
	 * 
	 */
		private void checkBookSubMenu(){
			boolean loopApp=true;
				System.out.println("1 - Gestion des livres");
				System.out.println("\t 11 - Entrer un livre");
				System.out.println("\t 12 - Sortir un livre");
				int choixMenu=this.clavier.nextInt();
				if(choixMenu!=11 && choixMenu!=12)
					choixMenu=-1;
				menuDispatcher(choixMenu);
		}
		/**
		 * 
		 * @return
		 */
		public FrikaBook getBibliotheque(){
			return bibliotheque;
		}
		/**
		 * 
		 * @param bibliotheque
		 */
		public void setBibliotheque(FrikaBook bibliotheque){
			this.bibliotheque=bibliotheque;
		}
		
		private void enregistrerLivre(){
			System.out.println("============== Enregistrement d'un livre=================");
			boolean loopOnBook=true;
			while(loopOnBook){
				Livre book=new Livre();
				Integer id=(Integer)this.idProviderHT.get("idLivre");
				this.idProviderHT.put("idLivre", id.intValue()+1);
				book.setNumLivre(id.intValue());
				System.out.println("Veuillez saisir l'isbn du livre: ");
				book.setIsbnLivre(this.clavier.next());
				System.out.println("Veuillez saisir le titre du livre: ");
				book.setTitreLivre(this.clavier.next());
				
				Integer id2=(Integer)this.idProviderHT.get("idAuteur");
				this.idProviderHT.put("idAuteur", id2.intValue()+1);//explication
				Personne auteur=new Personne();
				auteur.setNumPersonne(id2.intValue());
				System.out.println("Veuillez saisir le nom de l'auteur:");
				auteur.setNom(this.clavier.next());
				System.out.println("Veuillez saisir le prénom de l'auteur:");
				auteur.setPrenom(this.clavier.next());
				System.out.println("Veuillez saisir la date de naissance de l'auteur:");
				/*try {
					book.setDateNaissance(this.dateFormat.parse(this.clavier.next()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				book.setAuteur(auteur);
				System.out.println("Veuillez saisir la date de publication 'jj/mm/AAAA'");
				try {
					book.setDatePublication(this.dateFormat.parse(this.clavier.next()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bibliotheque.enregistrerLivre(book);
				System.out.println("Continuer de saisir des livres? oui(o)/non(n)");
				String response=clavier.next();
				if(response.equalsIgnoreCase("n")|| response.equalsIgnoreCase("non")){
					loopOnBook=false;
				}
			}
		}
		private void sortirLivre(){
			System.out.println("============== Suppression d'un livre=================");
			boolean loopOnBook=true;
			while(loopOnBook){
				Livre book=new Livre();
				System.out.println("Veuillez saisir le titre du livre à supprimer: ");
				book.setTitreLivre(this.clavier.next());
				bibliotheque.sortirLivre(book);
				System.out.println("Livre supprimé de la bibliothèque!!!");
				System.out.println("Continuer la suppression de livres? oui(o)/non(n)");
				String response=clavier.next();
				if(response.equalsIgnoreCase("n")|| response.equalsIgnoreCase("non")){
					loopOnBook=false;
				}
			}
		}
		
		/**
		 * 
		 */
		private void checkSubscriberSubMenu(){
			System.out.println("2 - Gestion des adhérents");
			System.out.println("\t 21 - Enregistrer un adhérent");
			System.out.println("\t 22 - Radier un adhérent");
			int choixMenu=this.clavier.nextInt();
			if(choixMenu!=21 && choixMenu!=22)
				choixMenu=-1;
			menuDispatcher(choixMenu);
		}
		private void enregistrerAdherent(){
			System.out.println("============== Enregistrement d'un adhérent=================");
			boolean loopOnAdherent=true;
			while(loopOnAdherent){
				Personne adherent=new Personne();
				Integer id=(Integer)this.idProviderHT.get("idAdherent");
				this.idProviderHT.put("idAdherent", id.intValue()+1);
				adherent.setNumPersonne(id.intValue());
				System.out.println("Veuillez saisir le nom de l'adhérent");
				adherent.setNom(this.clavier.next());
				System.out.println("Veuillez saisir le prénom de l'adhérent");
				adherent.setPrenom(this.clavier.next());
				System.out.println("Veuillez saisir la date de naissance de l'adhérent au format 'jj/mm/AAAA'");
				try {
					adherent.setDateNaissance(this.dateFormat.parse(this.clavier.next()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bibliotheque.enregistrerAdherent(adherent);
				System.out.println("Continuer de saisir des adhérents? oui(o)/non(n)");
				String response=clavier.next();
				if(response.equalsIgnoreCase("n")|| response.equalsIgnoreCase("non")){
					loopOnAdherent=false;
				}
			}
		}
		private void radierAdherent(){
			System.out.println("============== Radier un adhérent=================");
			boolean loopOnAdherent=true;
			while(loopOnAdherent){
				Personne adherent=new Personne();
				System.out.println("Veuillez saisir le numéro de l'adhérent à supprimer");
				adherent.setNumPersonne(this.clavier.nextInt());
				System.out.println("Veuillez saisir le nom de l'adhérent à supprimer: ");
				adherent.setNom(this.clavier.next());
				System.out.println("Veuillez saisir le prénom de l'adhérent à supprimer: ");
				adherent.setPrenom(this.clavier.next());
				//adherent.getNom();
				//adherent.getPrenom();
				
				System.out.println("Continuer la radiation d'adhérents? oui(o)/non(n)");
				String response=clavier.next();
				if(response.equalsIgnoreCase("n")|| response.equalsIgnoreCase("non")){
					loopOnAdherent=false;
					return;
				}
			}
		}

		private void checkEmpruntSubMenu(){
			System.out.println("3 - Gestion des emprunts");
			System.out.println("\t 31 - Enregistrer un emprunt");
			System.out.println("\t 32 - Retour d'un emprunt");
			int choixMenu=this.clavier.nextInt();
			if(choixMenu!=31 && choixMenu!=32)
				choixMenu=-1;
			menuDispatcher(choixMenu);
			
		}
		private void emprunterLivre(){
			System.out.println("============== Enregistrement d'un emprunt=================");
			boolean loopOnEmprunt=true;
			while(loopOnEmprunt){
				Emprunt emprunt=new Emprunt();
				Integer id=(Integer)this.idProviderHT.get("idEmprunt");
				this.idProviderHT.put("idEmprunt", id.intValue()+1);
				emprunt.setNumEmprunt(id.intValue()+1);
				System.out.println("Saisir le numéro d'adhérent : ");
				int numAdherent= clavier.nextInt();
				Personne adherent=(Personne)this.bibliotheque.getAdherents().get(numAdherent);
				System.out.println("Saisir le numéro du livre : ");
				int numLivre=clavier.nextInt();
				Livre book=(Livre)this.bibliotheque.getBooks().get(numLivre);
				Date dateEmprunt=new Date();
				System.out.println(dateEmprunt);
				System.out.println("Veuillez saisir la date de retour d'emprunt au format 'jj/mm/AAAA'");
				try {
					emprunt.setDateRetour(this.dateFormat.parse(this.clavier.next()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				bibliotheque.emprunterLivre(emprunt);	
				System.out.println("Continuer de saisir des emprunts? oui(o)/non(n)");
				String response=clavier.next();
				if(response.equalsIgnoreCase("n")|| response.equalsIgnoreCase("non")){
					loopOnEmprunt=false;
					return;
				}
			}
		}
		private void retourEmprunt(){
			System.out.println("============== Retour d'Emprunt=================");
			boolean loopOnEmprunt=true;
			while(loopOnEmprunt){
				Livre book =new Livre();
				System.out.println("Veuillez saisir le numéro d'emprunt: ");
			
			
				System.out.println("Continuer le retour d'emprunts? oui(o)/non(n)");
				String response=clavier.next();
				if(response.equalsIgnoreCase("n")|| response.equalsIgnoreCase("non")){
					loopOnEmprunt=false;
					return;
				}
			}
		}
		public void unloadList(ArrayList coll){
			Iterator iter = coll.iterator();
			Object objCree;
			while(iter.hasNext()){
				objCree=iter.next();
				if(objCree instanceof Personne){
					Personne adherentCree=(Personne)objCree;
					System.out.println(adherentCree);
				}
				else if(objCree instanceof Emprunt){
					Emprunt empruntCree=(Emprunt)objCree;
					System.out.println(empruntCree);
				}
				else if(objCree instanceof Livre){
					Livre livreCree=(Livre)objCree;
					Livre adherentCree=(Livre)objCree;
					System.out.println(livreCree);
				}
			}
		}
		
		public static void main(String[] args){
			FrikaBookManager bookManager=new FrikaBookManager();
			bookManager.generateMainMenu();
			bookManager.unloadList(bookManager.getBibliotheque().getAdherents());
			bookManager.unloadList(bookManager.getBibliotheque().getBooks());
			bookManager.unloadList(bookManager.getBibliotheque().getEmprunts());
		}
}

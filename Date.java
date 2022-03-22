package com.formation.rookie08.heritage.bibliotheque;

public class Date {
		private int jour;
		private int mois;
		private int annee;

		public Date(int jour, int mois, int annee) {
			this.jour=jour;
			this.mois=mois;
			this.annee=annee;
		}

		public int getJour() {
			return this.jour;
		}

		public int getMois() {
			return this.mois;
		}

		public int getAnnee() {
			return this.annee;
		}
}

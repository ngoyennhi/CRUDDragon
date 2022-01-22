package crudDRAGON;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnexion {
	static Connection accessDataBase = null;
	/**
	 * Testons la connexion
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		openConnection();
		testConnection();
		// La fermeture doit �tre fait � la fin du script principal. Evitez d'ouvrir et
		// fermer pour de petite requete
		closeConnection();
	}
	/**
	 * Connexion � ma base de donn�e crudDRAGON Ouverture de la connexion
	 * 
	 * @throws SQLException
	 */
	public static void openConnection() {
		/* Parametres de connexion */
		// pour Window
       //	String url = "jdbc:mysql://127.0.0.1/crudDRAGON";
		// pour Mac
		String url = "jdbc:mysql://localhost:8889/crudDRAGON";
		// crudDRAGON = nom de ma bdd
		String utilisateur = "root";
//	// pour Windows
//	String motDePasse = "";
		// pour Mac
		String motDePasse = "root";
		try {
			System.out.println("try to connect");
			// on ajoute nos param�tres
			accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException ex) {
			Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	/**
	 * True si la connexion est OK Tester la connexion
	 * 
	 * @return
	 */
	public static boolean testConnection() {
		boolean flag = false;
		try {
			if (accessDataBase != null) {
				if (!accessDataBase.isClosed()) {
					System.out.println("Connexion au serveur... OK");
					flag = true;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		return flag;
	}

	public static void closeConnection() {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection");
			} catch (SQLException e) {
				System.err.println("Erreur fermreture: " + e.getMessage());
			}
		}
	}
}

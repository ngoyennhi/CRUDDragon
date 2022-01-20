package crudDRAGON;


public class MainCRUDDragon {

	public static void main(String[] args) {
		MyConnexion.openConnection();
		System.out.println("Hello! your database dragons is already ");
		System.out.println("what do you want to do something with your database? 1-yes  0-no");
		int doSomething = Clavier.lireInt();
		while (doSomething == 1) {
			System.out.println("1-Add a new dragon ; 2-Read your database");
			System.out.println("3-Update your dragon ; 4-Delete your dragon");
			System.out.println("5-Exit");
			int action = Clavier.lireInt();
			switch (action) {
			//Add a new dragon
			case 1:
				QuerryDragon.create();
				System.out.println("what do you want to do somthing else? 1-yes  0-no");
				doSomething = Clavier.lireInt();
				break;
			//Read your database
			case 2:
				QuerryDragon.readAll();
				System.out.println("what do you want to do somthing else? 1-yes  0-no");
				doSomething = Clavier.lireInt();
				break;
			//Update your dragon
			case 3:
				System.out.println("Here's the list of Dragons in your database");
				QuerryDragon.readName();
				QuerryDragon.updateDragon();
				System.out.println("what do you want to do somthing else? 1-yes  0-no");
				doSomething = Clavier.lireInt();
				break;
			//Delete your dragon
			case 4:
				QuerryDragon.deleteDragon();
				System.out.println("what do you want to do somthing else? 1-yes  0-no");
				doSomething = Clavier.lireInt();
				break;
				//Exit
			case 5:
				doSomething = 0;
				break;
				default:
					System.out.println("oh non, your number is not our option, pls try another!");
				break;
			}
		}
		MyConnexion.closeConnection();
	}

}

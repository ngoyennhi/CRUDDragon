package crudDRAGON;

public class MainCRUDDragon {

	public static void main(String[] args) {
		System.out.println("Hello! your database dragons is already ");
		System.out.println("what do you want to do with it? 1-yes  0-no");
		int doSomething = Clavier.lireInt();
		while (doSomething == 1) {
			System.out.println("1-Add a new dragon ; 2-Read your database");
			System.out.println("3-Update your dragon ; 4-Delete your dragon");
			int action = Clavier.lireInt();
			switch (action) {
			//Add a new dragon
			case 1:
				QuerryDragon.create();
				System.out.println("what do you want to do with it? 1-yes  0-no");
				doSomething = Clavier.lireInt();
				break;
			//Read your database
			case 2:
				QuerryDragon.readAll();
				System.out.println("what do you want to do with it? 1-yes  0-no");
				doSomething = Clavier.lireInt();
				break;
			//Update your dragon
			case 3:
				QuerryDragon.updateDragon();
				System.out.println("what do you want to do with it? 1-yes  0-no");
				doSomething = Clavier.lireInt();
				break;
			//Delete your dragon
			case 4:
				QuerryDragon.deleteDragon();
				System.out.println("what do you want to do with it? 1-yes  0-no");
				doSomething = Clavier.lireInt();
				break;
			default:
				System.out.println("what do you want to do with it? 1-yes  0-no");
				doSomething = Clavier.lireInt();
				break;
			}
		}
	}

}

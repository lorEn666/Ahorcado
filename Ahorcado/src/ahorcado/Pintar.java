package ahorcado;

public class Pintar {

	// M�todo que pintar� el mu�eco en base al n�mero de intentos restantes

	public static void pintaMuneco(int vidas) {

		switch (vidas) {
		case 6:
			break;
		case 5:
			System.out.println(" |");
			System.out.println("_|_");
			break;
		case 4:
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|_");
			break;
		case 3:
			System.out.println("  ___");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|_");
			break;
		case 2:
			System.out.println("  ___");
			System.out.println(" |   |");
			System.out.println(" |  (_)");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|_");
			break;
		case 1:
			System.out.println("  ___");
			System.out.println(" |   |");
			System.out.println(" |  (_)");
			System.out.println(" |  /|\\");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|_");
			break;
		case 0:
			System.out.println("  ___");
			System.out.println(" |   |");
			System.out.println(" |  (_)");
			System.out.println(" |  /|\\");
			System.out.println(" |   |");
			System.out.println(" |  / \\");
			System.out.println(" |");
			System.out.println("_|_");

		}
	}

}

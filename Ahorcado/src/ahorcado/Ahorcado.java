package ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

	// Método que define la palabra que tendrá que adivinar el usuario

	public static String estableceSolucion() {
		String palabraSolucion[] = { "hola", "adios", "memoria", "microprocesador", "ventilador", "teclado", "pantalla",
				"raton", "torre", "chipset", "radiador", "alimentacion" };
		Random solucionAleatoria = new Random();
		int num = solucionAleatoria.nextInt(palabraSolucion.length - 1);

		return palabraSolucion[num];
	}

	// Método que rellena el vector vSolucion con la palabra a adivinar y el vector
	// vHuecos con un número de "_" igual a la longitud de la solución.

	public static void rellenaVectores(String vSol[], String vHue[], String palabra) {
		for (int i = 0; i < vSol.length; i++) {
			vSol[i] = palabra.substring(i, i + 1);
			vHue[i] = " _ ";
		}

	}

	// Método llamado al ganar el juego que nos ofrecerá jugar de nuevo

	public static void ganasJuego() {
		Scanner leer = new Scanner(System.in);
		String opcion = "";

		Utilidades.clean();
		System.out.println("\n\n\n");
		System.out.println("¡Enhorabuena! ¡Ha ganado!");
		System.out.println("\n\n\n");
		System.out.println("¿Quiere jugar de nuevo? (S/N)");
		opcion = leer.nextLine().toUpperCase();
		do {
			if (opcion.equalsIgnoreCase("S")) {
				break;
			}
			if (opcion.equalsIgnoreCase("N")) {
				Utilidades.clean();
				System.err.println("Juego terminado.");
				System.exit(0);
			}
		} while (!opcion.equalsIgnoreCase("S") && (!opcion.equalsIgnoreCase("N")));

	}

	// Método llamado al perder el juego que nos ofrecerá jugar de nuevo

	public static void pierdesJuego(int intent) {
		Scanner leer = new Scanner(System.in);
		String opcion = "";

		Utilidades.clean();
		Pintar.pintaMuneco(intent);
		System.out.println("\n\n\n");
		System.out.println("¡Ha perdido!");
		System.out.println("\n\n\n");
		System.out.println("¿Quiere jugar de nuevo? (S/N)");
		opcion = leer.nextLine().toUpperCase();
		do {
			if (opcion.equalsIgnoreCase("S")) {
				break;
			}
			if (opcion.equalsIgnoreCase("N")) {
				Utilidades.clean();
				System.err.println("Juego terminado.");
				System.exit(0);
			}
		} while (!opcion.equalsIgnoreCase("S") && (!opcion.equalsIgnoreCase("N")));

	}

	public static void main(String[] args) {

		do {
			String palabraSecreta = estableceSolucion().toUpperCase();

			String vSolucion[] = new String[palabraSecreta.length()];
			String vHuecos[] = new String[palabraSecreta.length()];
			String vFallos[] = new String[palabraSecreta.length()];

			rellenaVectores(vSolucion, vHuecos, palabraSecreta);
			Jugar.iniciaJuego(vSolucion, vHuecos, vFallos, palabraSecreta);
		} while (true);

	}

}

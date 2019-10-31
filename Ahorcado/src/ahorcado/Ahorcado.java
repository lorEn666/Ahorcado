package ahorcado;

import java.util.Scanner;

public class Ahorcado {

	// Método para limpiar la consola

	public static void clean() {
		for (int i = 0; i < 39; i++) {
			System.out.println();
		}
	}

	// Método que no dejará seguir hasta pulsar "Enter"

	public static void enterParaContinuar() {
		String seguir = "";

		Scanner leer = new Scanner(System.in);

		System.out.println("Pulse Enter para continuar...");
		try {
			seguir = leer.nextLine();

		} catch (Exception error) {

		}
	}

	// Método que define la palabra que tendrá que adivinar el usuario

	public static String estableceSolucion() {
		Scanner leer = new Scanner(System.in);
		String palabraSolucion = "HOLA";

		return palabraSolucion;
	}

	// Método que rellena el vector vSolucion con la palabra a adivinar y el vector
	// vHuecos con un número de "_" igual a la longitud de la solución.

	public static void rellenaVectores(String vSol[], String vHue[], String palabra) {
		for (int i = 0; i < vSol.length; i++) {
			vSol[i] = palabra.substring(i, i + 1);
			vHue[i] = " _ ";
		}

	}

	public static void iniciaJuego(String vSoluc[], String vHueco[], String vFallo[], String secretWord) {
		Scanner leer = new Scanner(System.in);
		int intentos = 6;
		String intentoUsuario = "";
		boolean acierto = false;

		repite: do {
			clean();
			acierto = false;
			System.out.println("Intentos restantes: " + intentos);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

			for (int i = 0; i < vHueco.length; i++) {
				System.out.print(vHueco[i]);
			}

			System.out.println("\n\n");

			for (int i = 0; i < vFallo.length; i++) {
				if (vFallo[i] != null) {
					System.out.print(vFallo[i]);
				}
			}

			System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Introduzca letra para jugar:");
			intentoUsuario = leer.nextLine().toUpperCase();

			for (int i = 0; i < vFallo.length; i++) {
				if (vFallo[i].equalsIgnoreCase(intentoUsuario)) {
					System.out.println("¡Ya ha probado esa letra! Introduzca otra.");
					continue repite;
				}
			}

			for (int i = 0; i < vSoluc.length; i++) {
				if (intentoUsuario.equalsIgnoreCase(vSoluc[i].substring(0, 1))) {
					vHueco[i] = (" " + intentoUsuario + " ");
					acierto = true;
				}
			}

			if (acierto) {
				clean();
				System.out.println("¡Acierto! La letra está incluida dentro de la palabra.");
				enterParaContinuar();
			} else {
				for (int i = 0; i < vFallo.length; i++) {
					if (vFallo[i] == null) {
						vFallo[i] = (" " + intentoUsuario + " ");
						break;
					}
				}
				clean();
				System.out.println("¡Intento fallido! Pruebe de nuevo.");
				intentos--;
				enterParaContinuar();
			}

		} while (intentos > 0);
	}

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		String palabraSecreta = estableceSolucion().toUpperCase();

		String vSolucion[] = new String[palabraSecreta.length()];
		String vHuecos[] = new String[palabraSecreta.length()];
		String vFallos[] = new String[palabraSecreta.length()];

		rellenaVectores(vSolucion, vHuecos, palabraSecreta);
		iniciaJuego(vSolucion, vHuecos, vFallos, palabraSecreta);

	}

}

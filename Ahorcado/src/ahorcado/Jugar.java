package ahorcado;

import java.util.Scanner;

public class Jugar {

	// Método que inicia el juego. Si introducimos una letra que ya estaba dentro de
	// la solución, nos avisará y nos permitirá introducir otra. Igualmente con las
	// letras con las que ya habíamos errado previamente, sin descontar intentos.

	public static void iniciaJuego(String vSoluc[], String vHueco[], String vFallo[], String secretWord) {
		Scanner leer = new Scanner(System.in);
		int intentos = 6, contadorVictoria = 0;
		String intentoUsuario = "";
		boolean acierto = false;

		repite: do {
			Utilidades.clean();
			acierto = false;
			System.out.println("Intentos restantes: " + intentos);
			System.out.println("\n\n");
			Pintar.pintaMuneco(intentos);
			System.out.println("\n\n\n\n");

			for (int i = 0; i < vHueco.length; i++) {
				System.out.print(" " + vHueco[i] + " ");
			}

			System.out.println("\n\n");

			for (int i = 0; i < vFallo.length; i++) {
				if (vFallo[i] != null) {
					System.out.print(" " + vFallo[i] + " ");
				}
			}

			System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Introduzca letra para jugar:");
			intentoUsuario = leer.nextLine().toUpperCase();

			for (int i = 0; i < vFallo.length; i++) {
				if ((vFallo[i] != null) && (vFallo[i].equalsIgnoreCase(intentoUsuario))) {
					System.out.println("¡Ya ha probado esa letra! Introduzca otra.");
					Utilidades.enterParaContinuar();
					continue repite;
				}
			}

			for (int i = 0; i < vHueco.length; i++) {
				if ((vHueco[i] != null) && (vHueco[i].equalsIgnoreCase(intentoUsuario))) {
					System.out.println("¡La letra ya está dentro de la solución! Introduzca otra.");
					Utilidades.enterParaContinuar();
					continue repite;
				}
			}

			for (int i = 0; i < vSoluc.length; i++) {
				if (intentoUsuario.equalsIgnoreCase(vSoluc[i].substring(0, 1))) {
					vHueco[i] = (intentoUsuario);
					contadorVictoria++;
					acierto = true;
				}
			}

			if (acierto) {
				Utilidades.clean();
				System.out.println("¡Acierto! La letra está incluida dentro de la palabra.");
				Utilidades.enterParaContinuar();
			} else {
				for (int i = 0; i < vFallo.length; i++) {
					if (vFallo[i] == null) {
						vFallo[i] = intentoUsuario;
						break;
					}
				}
				Utilidades.clean();
				System.out.println("¡Intento fallido! Pruebe de nuevo.");
				intentos--;
				Utilidades.enterParaContinuar();
			}

			if (contadorVictoria == vSoluc.length) {
				Ahorcado.ganasJuego();
				intentos = -1;
			}

		} while (intentos > 0);

		if (intentos == 0) {
			Ahorcado.pierdesJuego(intentos);

		}

	}

}

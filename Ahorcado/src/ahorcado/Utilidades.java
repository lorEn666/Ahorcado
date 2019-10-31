package ahorcado;

import java.util.Scanner;

public class Utilidades {
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

}

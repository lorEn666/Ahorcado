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

	// Método que define la palabra que tendra que adivinar el usuario

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
			vHue[i] = "_";
		}

	}

	// Método que pintará muñeco mediante matriz según valores en vector vFallos. Si
	// no hay un null,
	// se entiende que se ha agotado un intento.

	public static void pintaMuneco(String vIntentos[]) {
		String mAhorcado[][] = { { " ", " ", "_", "_", " ", " " }, { " ", "|", " ", " ", "|", " " },
				{ " ", "|", " ", "(", "_", ")" }, { " ", "|", " ", "/", "|", "\\" }, { " ", "|", " ", " ", "|", " " },
				{ " ", "|", " ", "/", " ", "\\" }, { "_", "|", "_", " ", " ", " " } };

		if (!vIntentos[0].equalsIgnoreCase(null)) {
			for (int i = 6; i < mAhorcado.length; i++) {
				for (int j = 0; j < 3; j++) {
					System.err.println(mAhorcado[i][j]);
				}
				System.err.println(" ");
			}
		} else {
			if (!vIntentos[1].equalsIgnoreCase(null)) {
				for (int i = 1; i < mAhorcado.length; i++) {
					for (int j = 0; j < 3; j++) {
						System.err.println(mAhorcado[i][j]);
					}
					System.err.println(" ");
				}
			} else {
				if (!vIntentos[2].equalsIgnoreCase(null)) {
					for (int i = 0; i < mAhorcado.length; i++) {
						
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		String vFallos[] = new String[6];
		String palabraSecreta = estableceSolucion();

		String vSolucion[] = new String[palabraSecreta.length()];
		String vHuecos[] = new String[palabraSecreta.length()];

		rellenaVectores(vSolucion, vHuecos, palabraSecreta);
		pintaMuneco(vFallos);

	}

}

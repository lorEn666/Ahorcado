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

	//	Método que pintará muñeco según valores en vector vFallos. Si no hay un null, se entiende que se ha agotado un intento.
	
	public static void pintaMuneco(String vIntentos[]) {
		String mAhorcado[][] = { { " ", " ", "_", "_", " ", " " }, { " ", "|", " ", " ", "|", " " },
				{ " ", "|", " ", "(", "_", ")" }, { " ", "|", " ", "/", "|", "\\" }, { " ", "|", " ", " ", "|", " " },
				{ " ", "|", " ", "/", " ", "\\" }, { "_", "|", "_", " ", " ", " " } };

		if (!vIntentos[0].equalsIgnoreCase(null)) {
			for (int i = 0; i < 4; i++) {
				System.err.print(mAhorcado[6][i]);
			}
		} else {
			if (!vIntentos[1].equalsIgnoreCase(null)) {
				for (int i = 0; i < 4; i++) {
					System.out.println(mAhorcado[5][i]);
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

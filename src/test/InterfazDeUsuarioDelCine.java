package test;

import java.util.Scanner;
import app.SalaDeCine;
import app.Butaca;

public class InterfazDeUsuarioDelCine {

	public static void main(String[] args) {
		Scanner leerDatos = new Scanner(System.in);
		SalaDeCine cineMark = new SalaDeCine("Cinemark");
		int opcionElegida;
		do {
			opcionElegida = operacionARealizarEn(cineMark, leerDatos);
		} while (opcionElegida != 6);
	}

	private static void butacasOcupadas(SalaDeCine cineActual, Scanner leerDatos) {
		System.out.println("---------- Butacas Ocupadas ----------");
		System.out.println("Total de butacas ocupadas: " + cineActual.cantidadButacasOcupadas());
	}

	private static void disponibilidadDeButaca(SalaDeCine cineActual, Scanner leerDatos) {
		System.out.println("------------------ Consulta de estado de Butaca ------------------");
		int fila = seleccionarFila(leerDatos), col = seleccionarColumna(leerDatos);
		if (cineActual.butacaOcupada(fila, col) != true)
			System.out.println("Butaca disponible.");
		else
			System.out.println("La butaca no está disponible.");
	}

	private static int menuDelCine(Scanner leerDatos) {
		int opcionElegida;
		System.out.println("------------ CineMark San Justo --------------");
		System.out.println("1. Vender entrada.");
		System.out.println("2. Consultar disponibilidad de una butaca.");
		System.out.println("3. Ocupar una butaca.");
		System.out.println("4. Consultar butacas ocupadas.");
		System.out.println("5. Vender múltiples entradas.");
		System.out.println("6. Salir.");

		System.out.print("\nIngrese la opción elegida: ");
		opcionElegida = leerDatos.nextInt();

		return opcionElegida;
	}

	private static void ocuparButaca(SalaDeCine cineEnUso, Scanner leerDatos) {
		System.out.println("\n------------------ Ocupar butacas -------------------");
		int fila = seleccionarFila(leerDatos);
		int col = seleccionarColumna(leerDatos);

		if (cineEnUso.butacaOcupada(fila, col) != true) {
			Butaca nuevaButaca = new Butaca();
			cineEnUso.ocuparButaca(fila, col, nuevaButaca);
			System.out.println("\nSe ha ocupado la butaca exitosamente.");
		} else
			System.out.println("\nLa butaca no se encuentra disponible. Por favor, seleccione otra butaca.");

	}

	private static final int VENDER_ENTRADA = 1, CONSULTAR_DISPONIBILIDAD_DE_BUTACA = 2, OCUPAR_BUTACA = 3,
			CONSULTAR_BUTACAS_OCUPADAS = 4, VENDER_MULTIPLES_ENTRADAS = 5, SALIR = 6;

	private static int operacionARealizarEn(SalaDeCine cineActual, Scanner leerDatos) {
		int opcionElegida;
		do {
			opcionElegida = menuDelCine(leerDatos);
			switch (opcionElegida) {
			case VENDER_ENTRADA:
				venderEntrada(cineActual, leerDatos);
				break;

			case CONSULTAR_DISPONIBILIDAD_DE_BUTACA:
				disponibilidadDeButaca(cineActual, leerDatos);
				break;

			case OCUPAR_BUTACA:
				ocuparButaca(cineActual, leerDatos);
				break;

			case CONSULTAR_BUTACAS_OCUPADAS:
				butacasOcupadas(cineActual, leerDatos);
				break;

			case VENDER_MULTIPLES_ENTRADAS:
				venderMultiplesEntradas(cineActual, leerDatos);
				break;

			case SALIR:
				System.out.println("Ha salido del sistema.");
				System.out.println("\n------------- Hasta pronto -------------");
				break;

			default:
				System.out.println("\nOPCIÓN INCORRECTA. REINGRESE LA OPCIÓN NUEVAMENTE.");
			}
		} while (opcionElegida != 6);
		return opcionElegida;
	}

	private static int seleccionarColumna(Scanner leerDatos) {
		int columnaElegida = 0;
		do {
			System.out.print("\nIngrese la columna de la butaca: ");
			columnaElegida = leerDatos.nextInt();

			if (columnaElegida < 0 || columnaElegida > 9)
				System.out.println(
						"\nEl número de columna debe ser un número entre 0 y 9.\nReingrese la fila nuevamente.");

		} while (columnaElegida < 0 || columnaElegida > 9);

		return columnaElegida;
	}

	private static int seleccionarFila(Scanner leerDatos) {
		int filaElegida = 0;
		do {
			System.out.print("\nIngrese la fila de la butaca: ");
			filaElegida = leerDatos.nextInt();

			if (filaElegida < 0 || filaElegida > 9)
				System.out
						.println("\nEl número de fila debe ser un número entre 0 y 9.\nReingrese la fila nuevamente.");

		} while (filaElegida < 0 || filaElegida > 9);

		return filaElegida;
	}

	private static void venderEntrada(SalaDeCine cineActual, Scanner leerDatos) {
		System.out.println("Butacas disponibles: ");
		cineActual.butacasDisponibles();
		int fila = seleccionarFila(leerDatos), col = seleccionarColumna(leerDatos);

		if (cineActual.butacaOcupada(fila, col) != true) {
			Butaca nuevaButacaOcupada = new Butaca();
			cineActual.ocuparButaca(fila, col, nuevaButacaOcupada);
			System.out.println("Entrada vendida exitosamente.");
		} else
			System.out.println("\nLa butaca no está disponible.");
	}

	private static void venderMultiplesEntradas(SalaDeCine cineActual, Scanner leerDatos) {
		int cantClientes = 0;
		System.out.println("\n------------- Venta múltiple de entradas -------------");
		System.out.print("Ingrese el número de entradas a vender: ");
		cantClientes = leerDatos.nextInt();

		if (cineActual.hayLugarPara(cantClientes))
			System.out.println("\nEntradas vendidas con éxito.");
		else
			System.out.println("\nNo se pueden vender las entradas.");

	}
}

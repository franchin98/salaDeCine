package test;

import java.util.Scanner;
import app.SalaDeCine;
import app.Butaca;

public class InterfazDeUsuarioDelCine {
	private static final int VENDER_ENTRADA = 1, CONSULTAR_DISPONIBILIDAD_DE_BUTACA = 2, OCUPAR_BUTACA = 3,
			CONSULTAR_BUTACAS_OCUPADAS = 4, VENDER_MULTIPLES_ENTRADAS = 5, SALIR = 6;

	public static void main(String[] args) {
		Scanner leerDatos = new Scanner(System.in);
		SalaDeCine cineMark = new SalaDeCine("Cinemark");
		int opcionElegida = 0;

		do {
			opcionElegida = menuDelCine(leerDatos);
			switch (opcionElegida) {
			case VENDER_ENTRADA:
				venderEntrada(cineMark, leerDatos);
				break;

			case CONSULTAR_DISPONIBILIDAD_DE_BUTACA:
				disponibilidadDeButaca(cineMark, leerDatos);
				break;

			case OCUPAR_BUTACA:
				ocuparButaca(cineMark, leerDatos);
				break;

			case CONSULTAR_BUTACAS_OCUPADAS:
				butacasOcupadas(cineMark, leerDatos);
				break;

			case VENDER_MULTIPLES_ENTRADAS:
				venderMultiplesEntradas(cineMark, leerDatos);
				break;

			case SALIR:
				System.out.println("Ha salido del sistema.");
				System.out.println("\n------------- Hasta pronto -------------");
				break;

			default:
				System.out.println("\nOPCIÓN INCORRECTA. REINGRESE LA OPCIÓN NUEVAMENTE.");
			}

		} while (opcionElegida != 6);

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

	private static void venderEntrada(SalaDeCine cineActual, Scanner leerDatos) {
		System.out.println("Butacas disponibles: ");
		cineActual.butacasDisponibles();
		int fila = 0, col = 0;
		do {
			System.out.print("Ingrese la fila de la butaca: ");
			fila = leerDatos.nextInt();
			if (fila < 0 || fila > 9)
				System.out.println("\nLa fila debe ser un número comprendido entre 0 y 9");
		} while (fila < 0 || fila > 9);

		do {
			System.out.print("Ingrese la columna de la butaca: ");
			col = leerDatos.nextInt();
			if (col < 0 || col > 9)
				System.out.print("\nLa columna debe ser un número comprendido entre 0 y 9");
		} while (col < 0 || col > 9);

		if (cineActual.butacaOcupada(fila, col)) {
			Butaca nuevaButacaOcupada = new Butaca();
			nuevaButacaOcupada.setOcupado(true);
			cineActual.ocuparButaca(fila, col, nuevaButacaOcupada);
			System.out.println("Entrada vendida exitosamente.");
		} else {
			System.out.println("\nLa butaca no está disponible.");
		}
	}

	private static void butacasOcupadas(SalaDeCine cineActual, Scanner leerDatos) {
		System.out.println("---------- Butacas Ocupadas ----------");
		System.out.println("Total de butacas ocupadas: " + cineActual.cantidadButacasOcupadas());
	}

	private static void disponibilidadDeButaca(SalaDeCine cineActual, Scanner leerDatos) {
		int fila = 0, col = 0;
		System.out.println("------------------ Consulta de estado de Butaca ------------------");

		do {
			System.out.print("\nIngrese la fila de la butaca: ");
			fila = leerDatos.nextInt();

			if (fila < 0 || fila > 9)
				System.out.println("El número de fila debe ser un número comprendido entre 0 y 9");
		} while (fila < 0 || fila > 9);

		do {
			System.out.println("\nIngrese la columna de la butaca: ");
			col = leerDatos.nextInt();

			if (col < 0 || col > 9)
				System.out.println("El número de columna debe ser un número comprendido entre 0 y 9");
		} while (col < 0 || col > 9);

		if (cineActual.butacaOcupada(fila, col))
		    System.out.println("La butaca no está disponible.");
		else
		    System.out.println("Butaca disponible.");

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
		int fila = 0, col = 0;

		System.out.println("\n------------------ Ocupar butacas -------------------");

		do {
			System.out.print("Ingrese el número de fila de la butaca: ");
			fila = leerDatos.nextInt();

			if (fila < 0 || fila > 9)
				System.out.println("El número de fila debe ser un número comprendido entre 0 y 9\n");

		} while (fila < 0 || fila > 9);

		do {
			System.out.print("Ingrese la columna de la butaca: ");
			col = leerDatos.nextInt();

			if (col < 0 || col > 9)
				System.out.println("El número de columna debe ser un número comprendido entre 0 y 9\n");
		} while (col < 0 || col > 9);
		
		if(cineEnUso.butacaOcupada(fila, col)) {
		    System.out.println("\nLa butaca ya está ocupada. Por favor, seleccione otra butaca.");
		} else {
		    Butaca nuevaButaca = new Butaca();
		    nuevaButaca.setOcupado(true);
		    cineEnUso.ocuparButaca(fila, col, nuevaButaca);
		    System.out.println("\nSe ha ocupado la butaca exitosamente.");		    
		}

	}

//	private static SalaDeCine operacionARealizar(SalaDeCine)
}

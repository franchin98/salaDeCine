package app;

public class SalaDeCine {
	private String nombreDeCine;
	private Butaca butacas[][];

	// constructor
	public SalaDeCine(String nombreDelCine) {
		setNombreDeCine(nombreDelCine);
		butacas = new Butaca[10][10];
	}

	// se verifica en la fila y col dentro de la matriz si es null o si esta
	// ocupado.
	public Boolean butacaOcupada(int fila, int col) {
		return butacas[fila][col] == null;
	}

	public String getNombreDeCine() {
		return nombreDeCine;
	}

	public void setNombreDeCine(String nombreDeCine) {
		this.nombreDeCine = nombreDeCine;
	}

	public void ocuparButaca(int fila, int col, Butaca pButaca) {
		if (butacaOcupada(fila, col))
			butacas[fila][col] = pButaca;
	}

	public Butaca[][] getButacas() {
		return butacas;
	}

	public void butacasDisponibles() {
		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[i].length; j++) {
				if (butacas[i][j] == null)
					System.out.print("L ");
				else
					System.out.print("O ");
			}
			System.out.println();
		}
	}

	public Boolean hayLugarPara(int cantidadPersonas) {
		Integer lugaresEnFila;

		for (int i = 0; i < butacas.length; i++) {
			lugaresEnFila = 0;
			for (int j = 0; j < butacas[i].length; j++) {
				lugaresEnFila = butacas[i][j] == null ? ++lugaresEnFila : lugaresEnFila;
				if (lugaresEnFila == cantidadPersonas) {
					venderButacasPorFila(i, cantidadPersonas);
					return true;
				}
			}
		}

		return false;
	}

	private void venderButacasPorFila(int fila, int cantidadButacas) {
		for (int i = 0; i < butacas[fila].length; i++) {
			if (butacas[fila][i] == null) {
				int aux = i;
				for (int j = 0; j < cantidadButacas; j++) {
					Butaca nuevaButacaOcupada = new Butaca();
					butacas[fila][aux] = nuevaButacaOcupada;
					aux++;
				}
				break;
			}
		}
	}

	public Integer cantidadButacasOcupadas() {
		Integer bOcup = 0;

		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[i].length; j++) {
				if (butacas[i][j] != null)
					bOcup++;
			}
		}

		return bOcup;
	}
}

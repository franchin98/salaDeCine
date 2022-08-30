package app;

public class SalaDeCine {
	private String nombreDeCine;
	private Butaca butacas[][];

	// constructor
	public SalaDeCine(String nombreDelCine) {
		setNombreDeCine(nombreDelCine);
		butacas = new Butaca[10][10];
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

	// se verifica en la fila y col dentro de la matriz si es null o si esta
	// ocupado.
	public Boolean butacaOcupada(int fila, int col) {
		return butacas[fila][col] != null;
	}

	public Integer cantidadButacasOcupadas() {
		Integer butacasOcupadas = 0;
		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[i].length; j++) {
				if (butacas[i][j] != null)
					butacasOcupadas++;
			}
		}
		return butacasOcupadas;
	}

	public Butaca[][] getButacas() {
		return butacas;
	}

	private int getFilaIncompleta(int paraLaCantidadDeButacas) {
		for (int i = 0; i < butacas.length; i++) {
			Integer butacasDisponibles = 0;
			for (int j = 0; j < butacas[i].length; j++) {
				butacasDisponibles = butacas[i][j] == null ? ++butacasDisponibles : butacasDisponibles;
				if (butacasDisponibles == paraLaCantidadDeButacas)
					return i;
			}
		}	
		return -1;
	}

	public String getNombreDeCine() {
		return nombreDeCine;
	}


	private int getPrimerButacaVacia(int filaIncompleta) {
		for (int i = 0; i < butacas[filaIncompleta].length; i++) {
			if (butacas[filaIncompleta][i] == null)
				return i;
		}
		return -1;
	}

	public Boolean hayLugarPara(int cantidadPersonas) {
		Integer filaIncompleta = getFilaIncompleta(cantidadPersonas);
		Integer primerButacaDisponible = getPrimerButacaVacia(filaIncompleta);
		if (filaIncompleta != -1 && primerButacaDisponible != -1) {
			venderEntradasPorFila(filaIncompleta, primerButacaDisponible, cantidadPersonas);
			return true;
		}
		return false;
	}

	public void ocuparButaca(int fila, int col, Butaca pButaca) {
		if (butacaOcupada(fila, col) != true)
			butacas[fila][col] = pButaca;
	}

	public void setNombreDeCine(String nombreDeCine) {
		this.nombreDeCine = nombreDeCine;
	}

	private void venderEntradasPorFila(int filaIncompleta, int butacaDesde, int cantidadDeEntradas) {
		int columnaDeButacaVacia = butacaDesde, entradasVendidas = 0;
		while (columnaDeButacaVacia < butacas[filaIncompleta].length && entradasVendidas < cantidadDeEntradas) {
			Butaca nuevaButaca = new Butaca();
			butacas[filaIncompleta][columnaDeButacaVacia] = nuevaButaca;
			columnaDeButacaVacia++;
			entradasVendidas++;
		}
	}

}

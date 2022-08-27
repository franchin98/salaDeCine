package app;

public class Butaca {
	private Boolean ocupado;
	
	// construct
	public Butaca() {
		ocupado = false;
	}
	
	public Boolean getOcupado() {
		return ocupado;
	}
	
	public void setOcupado(boolean seOcupa) {
		ocupado = seOcupa;
	}
}

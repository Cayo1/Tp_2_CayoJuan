package ar.edu.unju.fi.ejercicio3.constantes;

public class Constantes {
	public enum Provincia{
		JUJUY(718971, 53219),
		SALTA(1441351,155488),
		TUCUMAN(1731829, 22524),
		CATAMARCA(429602, 102602),
		LA_RIOJA(383865, 102602),
		SANTIAGO_DEL_ESTERO(1060906, 136351),
	;

	private int poblacion;
	private double superficie;

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	private Provincia(int poblacion, double superficie) {
		this.poblacion=poblacion;
		this.superficie=superficie;
		}

	public double calcularDensidadPoblacional() {
		// TODO Auto-generated method stub
		return (double) poblacion / superficie;
    }
	}
	
}

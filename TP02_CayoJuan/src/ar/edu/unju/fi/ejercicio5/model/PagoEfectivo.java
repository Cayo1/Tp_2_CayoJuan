package ar.edu.unju.fi.ejercicio5.model;
import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.intefaces.Pago;
public class PagoEfectivo implements Pago{
	private LocalDate fechaPago;
	private double montoPagado;
	public void realizarPago(double monto) {
		montoPagado=monto-(monto*0.1);
	}
	public void imprimirRecibo() {
		System.out.println("Fecha de pago: "+fechaPago);
		System.out.println("Monto pagado: "+montoPagado);
	}
	public PagoEfectivo(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
}

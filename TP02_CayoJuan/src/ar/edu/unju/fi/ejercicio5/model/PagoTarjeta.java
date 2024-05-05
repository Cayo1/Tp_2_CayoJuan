package ar.edu.unju.fi.ejercicio5.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.intefaces.Pago;

public class PagoTarjeta implements Pago {
    private String numeroTarjeta;
    private LocalDate fechaPago;
    private double montoPagado;

    public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaPago = fechaPago;
    }

    @Override
    public void realizarPago(double monto) {
        montoPagado = monto * 1.15; 
    }

    @Override
    public void imprimirRecibo() {
        if (fechaPago != null) {
            System.out.println("Número de tarjeta: " + numeroTarjeta);
            System.out.println("Fecha de pago: " + fechaPago.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
        } else {
            System.out.println("Fecha invalida");
        }
        System.out.println("Monto pagado: " + montoPagado);
    }
}

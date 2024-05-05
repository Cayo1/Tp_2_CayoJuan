package ar.edu.unju.fi.ejercicio3.main;


	import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio3.constantes.Constantes.Provincia;
public class Main {
    public static void main(String[] args) {
    	List <Provincia> ListaProv = new ArrayList<Provincia>();
    	ListaProv.add(Provincia.CATAMARCA);
		ListaProv.add(Provincia.JUJUY);
		ListaProv.add(Provincia.LA_RIOJA);
		ListaProv.add(Provincia.SALTA);
		ListaProv.add(Provincia.SANTIAGO_DEL_ESTERO);
		ListaProv.add(Provincia.TUCUMAN);
        for (Provincia provincia : ListaProv) {
            System.out.println("Provincia: " + provincia);
            System.out.println("Cantidad de población: " + provincia.getPoblacion());
            System.out.println("Superficie: " + provincia.getSuperficie());
            System.out.println("Densidad poblacional: " + provincia.calcularDensidadPoblacional());
            System.out.println();
        }
    }
		}


package ar.edu.ujnu.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;
import ar.edu.unu.fi.ejercicio6.interfaces.funcionales.Converter;

public class Main {
	public static void main(String[] args) {
        
		FelinoDomestico garfield = new FelinoDomestico("Tanner", (byte)20, 186f);

        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());

        FelinoSalvaje felinoSalvaje = converter.convert(garfield);

        if (Converter.isNotNull(felinoSalvaje)) {
            converter.mostrarObjeto(felinoSalvaje);
        } else {
            System.out.println("El felino salvaje es nulo.");
        }
		
    }
}

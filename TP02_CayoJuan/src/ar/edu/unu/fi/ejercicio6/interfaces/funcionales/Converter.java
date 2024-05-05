package ar.edu.unu.fi.ejercicio6.interfaces.funcionales;
@FunctionalInterface
public interface Converter<Y, Y1> {
	
	Y1 convert(Y y);
	
	static <Y> boolean isNotNull(Y y) {
		
		return y!= null;
	
	}
	default void mostrarObjeto(Y1 y1) {
	
		System.out.println("Objeto - " + y1.toString());
		
	}
	
}

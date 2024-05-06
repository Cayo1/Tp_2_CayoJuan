package ar.edu.unju.fi.ejercicio7.main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.model.Producto.Categorias;

import ar.edu.unju.fi.ejercicio7.model.Producto.Origenes;
import ar.edu.unju.fi.ejercicio7.model.Producto;

public class Main {
	public static void main(String[] args) {
		List<Producto> Productos = new ArrayList<Producto>();
		Productos = Precarga(Productos);
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			switch(opcion) {
				case 1:{
					Disponible(Productos);
					break;
				}
				case 2:{
					NoDisponible(Productos);
					break;
				}
				case 3:{
					Productos = IncrementarPrecios(Productos);
					break;
				}
				case 4:{
					CategoriaDisponible(Productos);
					break;
				}
				case 5:{
					OrdenadoDescendiente(Productos);
					break;
				}
				case 6:{
					ProductosMayus(Productos);
					break;
				}
				case 7:{
					System.out.println("Saliendo...");
					break;
				}
				default:{
					System.out.println("Opcion invalida ");
					break;
				}
			}
		}while(opcion != 7);
		
		sc.close();
	}
private static List<Producto> OrdenadoDescendiente(List<Producto> productos) {
	Comparator<Producto> c = Comparator.comparing(Producto :: getPrecioUnitario).reversed();
    
	productos.sort(c);
	
	return productos;
}
		
private static void CategoriaDisponible(List<Producto> productos) {
	System.out.println("Productos de Electrohogar Disponibles:");
    productos.stream()
            .filter(producto -> producto.getCategoria() == Categorias.ELECTROHOGAR && producto.isDisponible())
            .forEach(System.out::println);
    System.out.println();
		
	}
private static List<Producto> IncrementarPrecios(List<Producto> productos) {
	Function<Producto,Producto> nuevoPrecio = p -> {
		p.setPrecioUnitario(p.getPrecioUnitario()*1.20f);
		return p;
		};
	        
    return productos.stream()
    		.map(nuevoPrecio)
    		.collect(Collectors.toList());
	}
private static void NoDisponible(List<Producto> productos) {
	System.out.println("Productos Faltantes:");
    productos.stream()
            .filter(producto -> !producto.isDisponible())
            .forEach(System.out::println);
    System.out.println();
		
	}
private static void Disponible(List<Producto> productos) {
	System.out.println("Productos Disponibles:");
    productos.stream()
            .filter(Producto::isDisponible)
            .forEach(System.out::println);
    System.out.println();
		
	}
private static void ProductosMayus(List<Producto> productos) {
	Function<Producto, Producto> Mayus = producto -> {
		String DesMayusculas = producto.getDescripcion().toUpperCase();
		producto.setDescripcion(DesMayusculas);
		return producto;
	};
	List<Producto> productosMayusculas = productos.stream().map(Mayus).collect(Collectors.toList());
	
	productosMayusculas.forEach(producto -> {
	    System.out.println("Producto con código: " + producto.getCodigo());
	    System.out.println("Nombre/descripcion en mayúsculas: " + producto.getDescripcion());
			}
	);
	}
private static void mostrarMenu() {
	System.out.println("***MENU***");
	System.out.println("1 - Mostrar Productos");
	System.out.println("2 - Mostrar los productos faltantes");
	System.out.println("3 - Incrementar los precios de los productos en un 20%");
	System.out.println("4 - Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta");
	System.out.println("5 - Ordenar los productos por precio de forma descendente.");
	System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");
	System.out.println("7 - salir");
	System.out.println("Ingrese una opcion: ");
}
	
private static List<Producto> Precarga(List<Producto> productos) {
	 List<Producto> productos1 = new ArrayList<>();
	productos1.add(new Producto("AB12", "Silla de Oficina", 125000, Origenes.CHINA, Categorias.ELECTROHOGAR, true));
	productos1.add(new Producto("CD34", "Tostadora de Pan", 45000, Origenes.BRASIL, Categorias.ELECTROHOGAR, true));
	productos1.add(new Producto("EF56", "Cámara Deportiva", 80000, Origenes.ARGENTINA, Categorias.INFORMATICA, false));
	productos1.add(new Producto("GH78", "Afeitadora Eléctrica", 75000, Origenes.URUGUAY, Categorias.INFORMATICA, true));
	productos1.add(new Producto("IJ90", "Aspiradora Vertical", 135000, Origenes.BRASIL, Categorias.ELECTROHOGAR, true));
	productos1.add(new Producto("KL12", "Caja de Almacenaje", 55000, Origenes.CHINA, Categorias.HERRAMIENTAS, false));
	productos1.add(new Producto("MN34", "Laptop Ultradelgada", 700000, Origenes.CHINA, Categorias.INFORMATICA, true));
	productos1.add(new Producto("OP56", "Bicicleta Estática", 320000, Origenes.URUGUAY, Categorias.ELECTROHOGAR, true));
	productos1.add(new Producto("QR78", "Taladro Percutor", 180000, Origenes.BRASIL, Categorias.HERRAMIENTAS, true));
	productos1.add(new Producto("ST90", "Cortadora de Césped", 280000, Origenes.ARGENTINA, Categorias.HERRAMIENTAS, false));
	productos1.add(new Producto("UV12", "Licuadora Profesional", 95000, Origenes.CHINA, Categorias.ELECTROHOGAR, true));
	productos1.add(new Producto("WX34", "Telescopio Astronómico", 210000, Origenes.BRASIL, Categorias.INFORMATICA, false));
	productos1.add(new Producto("YZ56", "Plancha de Pelo", 68000, Origenes.CHINA, Categorias.ELECTROHOGAR, true));
	productos1.add(new Producto("AB78", "Smartwatch Deportivo", 140000, Origenes.ARGENTINA, Categorias.TELEFONIA, true));
	productos1.add(new Producto("CD90", "Batería Recargable", 60000, Origenes.URUGUAY, Categorias.TELEFONIA, false));


		return productos1;
	}

}
//6,3,4,7,5
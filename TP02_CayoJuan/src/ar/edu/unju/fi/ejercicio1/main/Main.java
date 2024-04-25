package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {
		
		
		        Scanner scanner = new Scanner(System.in);
		        ArrayList<Producto> listaProductos = new ArrayList<>();

		        int opcion;
		        do {
		            mostrarMenu();
		            opcion = scanner.nextInt();
		            scanner.nextLine(); 
		            try {
		                switch (opcion) {
		                    case 1:
		                        crearProducto(scanner, listaProductos);
		                        break;
		                    case 2:
		                        mostrarProductos(listaProductos);
		                        break;
		                    case 3:
		                        modificarProducto(scanner, listaProductos);
		                        break;
		                    case 4:
		                        System.out.println("Saliendo del programa.");
		                        break;
		                    default:
		                        System.out.println("Opción inválida. Intente de nuevo.");
		                }
		            } catch (Exception e) {
		                System.out.println("Error: " + e.getMessage());
		                scanner.nextLine(); 
		            }
		        } while (opcion != 4);

		        scanner.close();
		    }

		    private static void mostrarMenu() {
		        System.out.println("\nMenu:");
		        System.out.println("1 - Crear Producto");
		        System.out.println("2 - Mostrar Productos");
		        System.out.println("3 - Modificar Producto");
		        System.out.println("4 - Salir");
		        System.out.print("Elija una opción: ");
		    }

		    private static void crearProducto(Scanner scanner, ArrayList<Producto> listaProductos) {
		        System.out.println("\nCrear Producto:");

		        
		        System.out.print("Código: ");
		        String codigo = scanner.nextLine();
		        System.out.print("Descripción: ");
		        String descripcion = scanner.nextLine();
		        System.out.print("Precio Unitario: ");
		        double precioUnitario = scanner.nextDouble();
		        scanner.nextLine(); 

		        
		        System.out.println("\n------ Origen de Fabricación ------");
		        mostrarOpcionesOrigenFabricacion();

		        
		        int opcionOrigen = scanner.nextInt();
		        scanner.nextLine(); 
		        Producto.OrigenFabricacion origenFabricacion = obtenerOrigenFabricacion(opcionOrigen);

		        
		        System.out.println("\n------ Categoría ------");
		        mostrarOpcionesCategoria();

		        
		        int opcionCategoria = scanner.nextInt();
		        scanner.nextLine(); 
		        Producto.Categoria categoria = obtenerCategoria(opcionCategoria);

		        
		        Producto producto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
		        listaProductos.add(producto);

		        System.out.println("Producto creado exitosamente.");
		    }

		    private static void mostrarProductos(ArrayList<Producto> listaProductos) {
		        System.out.println("\nLista de Productos:");
		        if (listaProductos.isEmpty()) {
		            System.out.println("No hay productos para mostrar.");
		        } else {
		            for (Producto producto : listaProductos) {
		                System.out.println(producto);
		            }
		        }
		    }

		    private static void modificarProducto(Scanner scanner, ArrayList<Producto> listaProductos) {
		        System.out.println("\nModificar Producto:");
		        System.out.print("Ingrese el código del producto a modificar: ");
		        String codigo = scanner.nextLine();

		        
		        Producto productoEncontrado = null;
		        for (Producto producto : listaProductos) {
		            if (producto.getCodigo().equals(codigo)) {
		                productoEncontrado = producto;
		                break;
		            }
		        }

		        
		        if (productoEncontrado == null) {
		            System.out.println("No se encontró ningún producto con el código ingresado.");
		            return;
		        }

		        
		        System.out.println("\n------ Modificar Producto ------");
		        System.out.println("1 - Descripción");
		        System.out.println("2 - Precio Unitario");
		        System.out.println("3 - Origen de Fabricación");
		        System.out.println("4 - Categoría");
		        System.out.print("Elija una opción: ");
		        int opcionModificacion = scanner.nextInt();
		        scanner.nextLine(); 

		        
		        switch (opcionModificacion) {
		            case 1:
		                System.out.print("Nueva Descripción: ");
		                String nuevaDescripcion = scanner.nextLine();
		                productoEncontrado.setDescripcion(nuevaDescripcion);
		                break;
		            case 2:
		                System.out.print("Nuevo Precio Unitario: ");
		                double nuevoPrecioUnitario = scanner.nextDouble();
		                productoEncontrado.setPrecioUnitario(nuevoPrecioUnitario);
		                break;
		            case 3:
		                System.out.println("\n------ Origen de Fabricación ------");
		                mostrarOpcionesOrigenFabricacion();
		                System.out.print("Elija una opción: ");
		                int opcionOrigen = scanner.nextInt();
		                scanner.nextLine(); 
		                Producto.OrigenFabricacion nuevoOrigen = obtenerOrigenFabricacion(opcionOrigen);
		                productoEncontrado.setOrigenFabricacion(nuevoOrigen);
		                break;
		            case 4:
		                System.out.println("\n------ Categoría ------");
		                mostrarOpcionesCategoria();
		                System.out.print("Elija una opción: ");
		                int opcionCategoria = scanner.nextInt();
		                scanner.nextLine(); 
		                Producto.Categoria nuevaCategoria = obtenerCategoria(opcionCategoria);
		                productoEncontrado.setCategoria(nuevaCategoria);
		                break;
		            default:
		                System.out.println("Opción inválida.");
		                break;
		        }

		        System.out.println("Producto modificado exitosamente.");
		    }

		    
		    private static void mostrarOpcionesOrigenFabricacion() {
		        System.out.println("1 - Argentina");
		        System.out.println("2 - China");
		        System.out.println("3 - Brasil");
		        System.out.println("4 - Uruguay");
		        System.out.print("Elija una opción: ");
		    }

		    private static void mostrarOpcionesCategoria() {
		        System.out.println("1 - Telefonía");
		        System.out.println("2 - Informática");
		        System.out.println("3 - Electro hogar");
		        System.out.println("4 - Herramientas");
		        System.out.print("Elija una opción: ");
		    }

		    private static Producto.OrigenFabricacion obtenerOrigenFabricacion(int opcion) {
		        switch (opcion) {
		            case 1:
		                return Producto.OrigenFabricacion.ARGENTINA;
		            case 2:
		                return Producto.OrigenFabricacion.CHINA;
		            case 3:
		                return Producto.OrigenFabricacion.BRASIL;
		            case 4:
		                return Producto.OrigenFabricacion.URUGUAY;
		            default:
		                return null;
		        }
		    }

		    private static Producto.Categoria obtenerCategoria(int opcion) {
		        switch (opcion) {
		            case 1:
		                return Producto.Categoria.TELEFONIA;
		            case 2:
		                return Producto.Categoria.INFORMATICA;
		            case 3:
		                return Producto.Categoria.ELECTROHOGAR;
		            case 4:
		                return Producto.Categoria.HERRAMIENTAS;
		            default:
		                return null;
		        }
		    }
}

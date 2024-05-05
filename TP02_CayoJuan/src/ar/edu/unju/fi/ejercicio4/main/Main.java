package ar.edu.unju.fi.ejercicio4.main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;
public class Main {
	public static void main(String[] args) {
		ArrayList<Jugador> jugadores=new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int opcion;
		try {
		do{
			mostrarMenu();
			opcion=scanner.nextInt();
			scanner.nextLine();
			switch(opcion) {
			case 1:
				altajugador(scanner, jugadores);
				break;
			case 2: 
				mostrarJugadores(jugadores);
				break;
			case 3: 
				modificarPosicion(scanner, jugadores);
				break;
			case 4:
				eliminarJugador(scanner, jugadores);
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion invalida, intente nuevamente");					
				}
		}while (opcion!=5);
	}catch (InputMismatchException e) {
		System.out.println("Se esperaba un numero entero");
	}finally {
		scanner.close();
		}
		
	}

	private static void eliminarJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
		 try {
		        System.out.print("Ingrese el nombre del jugador: ");
		        String nombre = scanner.nextLine();
		        System.out.print("Ingrese el apellido del jugador: ");
		        String apellido = scanner.nextLine();

		        boolean jugadorEncontrado = false;
		        for (Iterator<Jugador> iterator = jugadores.iterator(); iterator.hasNext();) {
		            Jugador jugador = iterator.next();
		            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
		                iterator.remove();
		                jugadorEncontrado = true;
		                System.out.println("Jugador eliminado correctamente.");
		                break;
		            }
		        }

		        if (!jugadorEncontrado) {
		            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
		        }
		    } catch (Exception e) {
		        System.out.println("Se esperaba un nombre");
		    }
	}

	private static void modificarPosicion(Scanner scanner, ArrayList<Jugador> jugadores) {
		try {
	        System.out.print("Ingrese el nombre del jugador: ");
	        String nombre = scanner.nextLine();
	        System.out.print("Ingrese el apellido del jugador: ");
	        String apellido = scanner.nextLine();

	        Jugador jugadorEncontrado = null;
	        for (Jugador jugador : jugadores) {
	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                jugadorEncontrado = jugador;
	                break;
	            }
	        }

	        if (jugadorEncontrado != null) {
	            System.out.print("Ingrese la nueva posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
	            String nuevaPosicionStr = scanner.nextLine();
	            Posicion nuevaPosicion = Posicion.valueOf(nuevaPosicionStr.toUpperCase());
	            jugadorEncontrado.setPosicion(nuevaPosicion);
	            System.out.println("Posición modificada correctamente.");
	        } else {
	            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
	        }
	    } catch (Exception e) {
	        System.out.println("Se esperaba una posiscion");
	    }
		
	}

	private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
	        if (jugadores.isEmpty()) {
	            System.out.println("No hay jugadores para mostrar.");
	        } else {
	            System.out.println("Lista de jugadores:");
	            for (Jugador jugador : jugadores) {
	                System.out.println(jugador);
	            }
	        }    
		
	}

	private static void altajugador(Scanner scanner, ArrayList<Jugador> jugadores) {
		try {
	        Jugador jugador = new Jugador();

	        System.out.println("Ingrese los datos del jugador:");
	        System.out.print("Nombre: ");
	        String nombre = scanner.nextLine();
	        jugador.setNombre(nombre);

	        System.out.print("Apellido: ");
	        String apellido = scanner.nextLine();
	        jugador.setApellido(apellido);

	        System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
	        String fechaNacimientoStr = scanner.nextLine();
	        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
	        jugador.setFechaNacimiento(fechaNacimiento);

	        System.out.print("Nacionalidad: ");
	        String nacionalidad = scanner.nextLine();
	        jugador.setNacionalidad(nacionalidad);

	        System.out.print("Estatura (metros): ");
	        float estatura = scanner.nextFloat();
	        jugador.setEstatura(estatura);

	        System.out.print("Peso (kg): ");
	        float peso = scanner.nextFloat();
	        jugador.setPeso(peso);

	        scanner.nextLine();
	        System.out.print("Posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
	        String posicionStr = scanner.nextLine();
	        Posicion posicion = Posicion.valueOf(posicionStr.toUpperCase());
	        jugador.setPosicion(posicion);

	        jugadores.add(jugador);
	        System.out.println("Jugador agregado correctamente.");
	    } catch (Exception e) {
	        System.out.println("Se esperaban datos validos " );
	    } finally {
	        scanner.nextLine();
	    }
		
	}

	private static void mostrarMenu() {
		System.out.println("Menú:");
        System.out.println("1 - Alta de jugador");
        System.out.println("2 - Mostrar todos los jugadores");
        System.out.println("3 - Modificar la posición de un jugador");
        System.out.println("4 - Eliminar un jugador");
        System.out.println("5 - Salir");
        System.out.print("Seleccione una opción: ");
	}
	
}

package ar.edu.unju.fi.ejercicio2.main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio2.model.*;
import ar.edu.unju.fi.ejercicio2.constantes.*;
import ar.edu.unju.fi.ejercicio2.constantes.Constantes.Mes;
public class Main {
public static void main(String[] args) {
	
	ArrayList<Efemeride> efemerides= new ArrayList<>();
	Scanner scanner = new Scanner (System.in);
	int opcion;
	try {
	do {
			mostrarMenu();
			opcion = scanner.nextInt();
			scanner.nextLine();
			switch (opcion) {
			case 1: crearEfe(scanner, efemerides);
			break;
			case 2:
				mostrarEfe(efemerides);
				break;
			case 3: 
				eliminarEfe(scanner, efemerides);
				break;
			case 4:
				modificarEfe(scanner, efemerides);
				break;
			case 5: 
				System.out.println("Saliendo del programa");
				break;
			default:
				System.out.println("Opcion no valida. Intentelo nuevamente");
			}
			
		} while (opcion != 5);
	} catch (InputMismatchException e){
		System.out.println("Opcion invalida. Intente nuevamente");
	}finally {
		scanner.close();
		}
	}

private static void eliminarEfe(Scanner scanner, ArrayList<Efemeride> efemerides) {
	try {
		System.out.println("Ingrese el codigo de la efemeride que desea eliminar");
		String codigo = scanner.nextLine();
		boolean elim=false;
		for (Efemeride efemeride : efemerides) {
			if (efemeride.getCodigo().equals(codigo)) {
				efemerides.remove(efemeride);
				elim=true;
				break;
			}
		}
		if (elim) {
			System.out.println("Efemeride eliminada");
		}else {
			System.out.println("Efemeride no encontrada");
		}
	}catch (InputMismatchException e) {
		System.out.println("Se esperaba un valor numerico");
	}
	
}
private static void modificarEfe(Scanner scanner, ArrayList<Efemeride> efemerides) {
    try {
        System.out.println("Ingrese el código de la efeméride a modificar:");
        String codigo = scanner.nextLine();

        Efemeride efemerideModificar = null;
        for (Efemeride efemeride : efemerides) {
            if (efemeride.getCodigo().equals(codigo)) {
                efemerideModificar = efemeride;
                break;
            }
        }

        if (efemerideModificar != null) {
            System.out.println("Ingrese el nuevo día:");
            int nuevoDia = scanner.nextInt();
            efemerideModificar.setDia(nuevoDia);
            scanner.nextLine();

            System.out.println("Ingrese el nuevo mes (número):");
            int nuevoMesNumero = scanner.nextInt();
            scanner.nextLine();
            Mes nuevoMes = Mes.values()[nuevoMesNumero - 1]; 
            efemerideModificar.setMes(nuevoMes);

            System.out.println("Ingrese el nuevo detalle:");
            String nuevoDetalle = scanner.nextLine();
            efemerideModificar.setDetalle(nuevoDetalle);

            System.out.println("Efeméride modificada con éxito.");
        } else {
            System.out.println("No se encontró ninguna efeméride con el código ingresado.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Se esperaba un valor numérico.");
    }
}


private static void mostrarEfe(ArrayList<Efemeride> efemerides) {
	System.out.println("LISTA DE EFEMERIDES:");
	for(Efemeride efemeride : efemerides) {
		System.out.println("Codigo: "+ efemeride.getCodigo()+ ", Mes: " + efemeride.getMes()+ ", Dia: "+ efemeride.getDia()+ ", Detalle: " + efemeride.getDetalle());
		
	}
	
}

private static void crearEfe(Scanner scanner, ArrayList<Efemeride> efemerides) {
	try {
		System.out.println("Ingrese el codigo de la efemeride:");
		String codigo = scanner.nextLine();
		System.out.println("Ingrese el dia:");
		int dia= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese el mes en numero:");
		int mesNumero= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese el detalle:");
		String detalle= scanner.nextLine();
		Mes mes= Mes.values()[mesNumero - 1];
		Efemeride efemeride = new Efemeride (codigo, mes, dia, detalle);
		efemerides.add(efemeride);
		System.out.println("Efemeride creada");
	}catch (InputMismatchException e) {
		System.out.println("Se esperaba un valor numerico");
	}
	
}

private static void mostrarMenu() {
	System.out.println("***MENU***");
	System.out.println("1. Crear efemeride");
	System.out.println("2. Mostrar efemeride");
	System.out.println("3. Eliminar efemeride");
	System.out.println("4. Modificar efemeride");
	System.out.println("5. Salir");
	System.out.println("Elija su opcion");
	
}

}

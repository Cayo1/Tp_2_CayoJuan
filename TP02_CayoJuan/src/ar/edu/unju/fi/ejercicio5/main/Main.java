package ar.edu.unju.fi.ejercicio5.main;


import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		CargarProductos(productos);
		
		int opcion;

        do {
            System.out.println("Menu");
            System.out.println("1- Mostrar Productos");
            System.out.println("2- Realizar Compra");
            System.out.println("3- Salir del programa");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                       ProductoDisponibles(productos);
                        break;
                    case 2:
                        RealizarCompra(productos);
                        break;
                    case 3:
                        System.out.println("Saliendo del Programa...");
                        break;
                    default:
                        System.out.println("Numero no valido");
                }
            } catch (NumberFormatException e) {
                System.out.println("Se esperaba un numero entero");
                opcion = 0;
            }
        } while (opcion != 3);

        scanner.close();
	}
			
	
	public static void CargarProductos(ArrayList<Producto> productos)
	{
		productos.add(new Producto("AB12", "Silla de Oficina", 125000, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("CD34", "Tostadora de Pan", 45000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("EF56", "Cámara Deportiva", 80000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, false));
		productos.add(new Producto("GH78", "Afeitadora Eléctrica", 75000, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, true));
		productos.add(new Producto("IJ90", "Aspiradora Vertical", 135000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("KL12", "Caja de Almacenaje", 55000, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("MN34", "Laptop Ultradelgada", 700000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("OP56", "Bicicleta Estática", 320000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("QR78", "Taladro Percutor", 180000, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto("ST90", "Cortadora de Césped", 280000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("UV12", "Licuadora Profesional", 95000, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("WX34", "Telescopio Astronómico", 210000, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, false));
		productos.add(new Producto("YZ56", "Plancha de Pelo", 68000, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("AB78", "Smartwatch Deportivo", 140000, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
		productos.add(new Producto("CD90", "Batería Recargable", 60000, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false));
	}
	
	public static void ProductoDisponibles(ArrayList<Producto> productos)
	{
		for(Producto prod : productos)
		{			
				System.out.println("Codigo de Producto: "+prod.getCodigo());
				System.out.println("Descripcion del Producto: "+prod.getDescripcion());
				System.out.println("Precio del Producto: "+prod.getPrecioU());
				System.out.println("Origen de Fabricacion del Producto: "+prod.getOrigenfabricacion());
				System.out.println("Categoria del Producto: "+prod.getCategoria());
				if(prod.isEstado())
				{
					System.out.println("DISPONIBLE");
				}
				else
				{
					System.out.println("SIN STOCK");
				}
		}
	}
	
	public static void RealizarCompra(ArrayList<Producto> productos)
	{
		List<Producto> productoSeleccionado = new ArrayList<Producto>();
		double CompraTotal = 0;
		
		System.out.println("Ingrese el codigo del producto que desea comprar(Para terminar ingrese fin");
		String codigoProducto;
		do {
			codigoProducto = scanner.nextLine();
			if(!codigoProducto.equals("fin"))
			{
				Producto prodSelec = buscarProdCodigo(productos, codigoProducto);
				if(prodSelec != null && prodSelec.isEstado())
				{
					productoSeleccionado.add(prodSelec);
					CompraTotal += prodSelec.getPrecioU();
				}
			}
			
		}while(!codigoProducto.equals("fin"));
		
		System.out.println("Carrito");
		for(Producto producto : productoSeleccionado)
		{
			System.out.println(producto.getDescripcion()+" - $"+producto.getPrecioU());
		}
		System.out.println("Total de la compra: $"+ CompraTotal);
		
		System.out.println("\nSeleccione el metodo de Pago: ");
		System.out.println("1- Pago en Efectivo(10% de descuento): ");
		System.out.println("2- Pago con Tarjeta(15% de aumento): ");
		int metodoPago = scanner.nextInt();
		
		switch(metodoPago)
		{
			case 1: 
				PagoEfectivo pagoEfectivo = new PagoEfectivo(LocalDate.now());
				pagoEfectivo.realizarPago(CompraTotal);
				pagoEfectivo.imprimirRecibo();
			break;
			case 2:
				scanner.nextLine();
				System.out.println("Ingrese el numero de tarjeta: ");
				String NumeroTarjeta = scanner.nextLine();
				PagoTarjeta pagoTarjeta = new PagoTarjeta(NumeroTarjeta, LocalDate.now());
				pagoTarjeta.realizarPago(CompraTotal);
				pagoTarjeta.imprimirRecibo();
			break;
			default:
				System.out.println("Opcion Incorrecta!!!");
			break;
		}
	}

	public static Producto buscarProdCodigo(ArrayList<Producto> productos, String codigo) {
	    for (Producto producto : productos) {
	        if (producto.getCodigo().equals(codigo)) {
	            return producto;
	        }
	    }
	    return null;
	}
}
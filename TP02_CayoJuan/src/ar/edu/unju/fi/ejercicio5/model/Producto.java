package ar.edu.unju.fi.ejercicio5.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private double precioU;
	private OrigenFabricacion origenfabricacion;
	private Categoria categoria;
	private boolean estado;

	public Producto() {

	}

	public Producto(String codigo, String descripcion, double precioU, OrigenFabricacion origenfabricacion, Categoria categoria, boolean estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioU = precioU;
		this.origenfabricacion = origenfabricacion;
		this.categoria = categoria;
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioU() {
		return precioU;
	}
	public void setPrecioU(double precioU) {
		this.precioU = precioU;
	}

	public enum OrigenFabricacion {
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}

	public enum Categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public OrigenFabricacion getOrigenfabricacion() {
		return origenfabricacion;
	}

	public void setOrigenfabricacion(OrigenFabricacion origenfabricacion) {
		this.origenfabricacion = origenfabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}

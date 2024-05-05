package ar.edu.unju.fi.ejercicio6.model;

public class FelinoSalvaje {
	private String Nombre;
	private byte Edad;
	private float Peso;
	public FelinoSalvaje() {
		
	}
	public FelinoSalvaje(String nombre, byte edad, float peso) {
		super();
		Nombre=nombre;
		Edad=edad;
		Peso=peso;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public byte getEdad() {
		return Edad;
	}
	public void setEdad(byte edad) {
		this.Edad = edad;
	}
	public float getPeso() {
		return Peso;
	}
	public void setPeso(float peso) {
		this.Peso = peso;
	}
	@Override
	public String toString() {
		return "FelinoSalvaje [nombre=" + Nombre + ", edad=" + Edad + ", peso=" + Peso + "]";
	}
	
	
}

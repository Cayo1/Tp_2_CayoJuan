package ar.edu.unju.fi.ejercicio6.model;

public class FelinoDomestico {
	private String Nombre;
	private byte Edad;
	private float Peso;
	public FelinoDomestico() {
		
	}
	public FelinoDomestico(String nombre, byte edad, float peso) {
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
		return "FelinoDomestico [nombre=" + Nombre + ", edad=" + Edad + ", peso=" + Peso + "]";
	}
	
	
}

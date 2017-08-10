package ejemplosencillo;

import com.google.gson.Gson;

/**
 * Este es un ejemplo sencillo de como funciona la libreria Gson para 
 * convertir los objetos json a objetos java.
 * 
 * Para convertir los objetos json a objetos java con la libreria Gson,
 * primero se tiene que crear una clase en la que se declaren las mismas 
 * variables y objetos que contiene el objeto json, en este caso esa es
 * la clase Persona. Las variables y los objetos que se creen en la clase
 * deben tener los mismos nombres de los objetos y variables del objeto 
 * json. De esta manera al realizar la convercion los valores de las 
 * variables y los objetos json pasaran a estar en las variables de la 
 * clase creada.
 * 
 * El metodo de la clase Gson que se utiliza para convertir los objetos
 * json a java es fromJson();. A este metodo se le pasa como parametro el
 * objeto json y la clase que almacenara los valores del objeto json.
 * 
 * */


public class EjemploSencillo {

	public static void main(String[] args) {
		
		String json = "{\"nombre\":\"Unai\",\"edad\":28}";

	    Gson gson = new Gson();

	    // Sentencia que convierte los objetos json a objetos java.
	    Persona persona = (Persona) gson.fromJson(json, Persona.class);

	    System.out.println(persona.getNombre());
	    System.out.println(persona.getEdad());

	}
	
	/**
	 * Clase en que se almacenan los valores del archivo json.
	 * */
	public class Persona{
		
	    private String nombre;
	    private int edad;

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    public void setEdad(int edad) {
	        this.edad = edad;
	    }
	    
	}


}

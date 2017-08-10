package gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.google.gson.Gson;

import gson.Familia.Frutas;
import gson.Pokemon.Abilities;
import gson.Pokemon.Forms;
import gson.Pokemon.GameIndices;
import gson.Pokemon.Moves;
import gson.Pokemon.Stats;
import gson.Pokemon.Types;
import gson.Pokemon.Moves.VersionGroupDetails;

/**
 * Clase ejecutable del proyecto.
 * 
 * Los archivos json que se leen en esta clase estan almacenados en la carpeta res del proyecto
 * */
public class Main {

	private static Scanner teclado;

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		bienvenido();
		
		opciones();
		
	}


	/**
	 * Este metodo imprime en consola un mensaje de bienvenida.
	 * */
	public static void bienvenido() {
		
		String log = ""
				+ "\n"
				+ "   ________________________________________________GSON________________________________________________ \n"
				+ "\n"
				+ "    BIENVENIDO!! \n"
				+ "\n"
				+ "    Este es un sencillo ejemplo de como se leen archivos json utilizando la libreria de Google Gson. \n"
				+ "\n"
				+ "    Este ejemplo cuenta con dos archivos archivos json para su lectura, bulbasaur.json y familia.json. \n"
				+ "    Para selecciona el archivo que desea leer, introduzca el numero del archivo. \n"
				+ "\n";
		
		System.out.println(log);
		
	}
	
	
	/**
	 * Este metodo imprime un menu de opciones en consola para que el usuario decida que accion realizar.
	 * Entre las opciones estas las de abrir los archivos json o finalizar el programa. Si el usuario 
	 * selecciona uno de los archivos, se ejecuta el metodo que abre el archivo y se muestra su contenido
	 * en consola. 
	 * */
	public static void opciones() {
		
		boolean ciclo = true;
		
		while(ciclo) {
			
			teclado = new Scanner(System.in);
			
			System.out.println(""
					+ "    SELECCIONE EL ARCHIVO QUE DESEA LEER \n"
					+ "     1. lista de pokemones.json \n"
					+ "     2. bulbasaur.json \n"
					+ "     3. charizard.json \n"
					+ "     4. familia.json \n"
					+ "     5. finalizar");
			
			int respuesta = teclado.nextInt();
						
			switch (respuesta) {
			
				case 1:
					listaDePokemones("lista de pokemones.json");
					break;
				
				case 2:
					pokemon("bulbasaur.json");
					break;
				
				case 3:
					pokemon("charizard.json");
					break;
				
				case 4:
					familia("familia.json");
					break;
					
				case 5:
					ciclo = false;
					
					System.out.println(
							"\n    Programa finalizado\n"
							+ "\n"
							+ "   ____________________________________________________________________________________________________"
							+ "\n");
					
					continue;
					
				default:
					System.out.println("    :( La opcion seleccionada no es valida \n");
					continue;
				
			}
			
			System.out.println(""
					+ "    Desea finalizar el programa? \n"
					+ "    1. si\n"
					+ "    2. no");
			
			respuesta = teclado.nextInt();
			
			if(respuesta == 1) {
				ciclo = false;
				
				System.out.println(
						"\n    Programa finalizado\n"
						+ "\n"
						+ "   ____________________________________________________________________________________________________"
						+ "\n");
			}
			
		}
	
	}
	
	/**
	 * Metodo que obtiene los archivos json de los recursos del proyecto
	 * y retorna un string con el contenido de estos.
	 * 
	 * @param nombre recibe el nombre del archivo json que se leera.
	 *               
	 * @return retorna un string con el contenido del archivo leido.
	 * */
	public static String getResource(String nombre) {

		// string que se retorna
		String contenido = "";
		
		InputStream input = Main.class.getResourceAsStream("/" + nombre);
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		 
		try {
			
			String line = null;
			while ((line = reader.readLine()) != null) {
			
				contenido += line;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				reader.close();
				input.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return contenido;
		
	}
	
	/**
	 * Metodo que lee el archivo json lista de pokemones.json y obtiene su contenido
	 * para mostrarlo en consola.
	 * */
	public static void listaDePokemones(String nombre) {
		
		String json = getResource(nombre);
		
		Gson gson = new Gson();
		ListaDePokemones pokemones = (ListaDePokemones) gson.fromJson(json, ListaDePokemones.class);
		
		String log;
		
		log = "   ________________________________________Lista de pokemones_________________________________________"
			+ "\n"
			+ "\n";
		
		for(int i = 0; i<pokemones.getResults().length; i++) {
			
			int posicion = i + 1;
			
			log += "    " + posicion + ". " + pokemones.getResults()[i].getName() + "\n";
		}
		
		log +="\n"
			+ "   ___________________________________________________________________________________________________"
			+ "\n"
			+ "";
		
		System.out.println(log);
		
	}

	/**
	 * Metodo que lee el archivo json bulbasaur.json o charizard.json(dependiendo de 
	 * la opcion que selecciones el usuario) y obtiene su contenido
	 * para mostrarlo en consola.
	 * */
	public static void pokemon(String nombre) {
		
		String json = getResource(nombre);
	
		Gson gson = new Gson();
		Pokemon pokemon;
		pokemon = (Pokemon) gson.fromJson(json, Pokemon.class);

		String log;
		
			log = "   ______________________________________________POKEMON______________________________________________\n"
				+ "\n"
				+ "    Id: " + pokemon.getId() + "\n"
				+ "    Nombre: " + pokemon.getName() + "\n"
				+ "    Altura: " + pokemon.getHeight() + "\n"
				+ "    Peso: " + pokemon.getWeight() + "\n"
 				+ "    PX: " + pokemon.getBase_experience() + "\n"
 				+ "    Orden: " + pokemon.getOrder() + "\n"
 				+ "    Por defecto: " + pokemon.isIs_default() + "\n"
 				+ "\n"
 				+ "    -------------------------------------------Habilidades-------------------------------------------\n"
 				+ "";
		
		for(Abilities ability : pokemon.getAbilities()) {
			
			log +=""
				+ "\n"
				+ "    Oculta: " + ability.isIs_hidden() + "\n"
				+ "    Espacio: " + ability.getSlot() + "\n"
				+ "\n"
				+ "    Habilidad\n"
				+ "    Nombre: " + ability.getAbility().getName() + "\n"
				+ "    URL: " + ability.getAbility().getUrl() + "\n"
				+ "\n"
				+ "";
		}
		
			log += "    ----------------------------------------------Formas---------------------------------------------\n";
		
		for(Forms form : pokemon.getForms()) {
			
			log +="\n"
				+ "    Nombre: " + form.getName() + "\n"
				+ "    URL: " + form.getUrl() + "\n"
				+ "\n"
				+ "";
		}
		
			log += "    -----------------------------------------Indices de Juego----------------------------------------\n";
		
		for(GameIndices gameIndice : pokemon.getGame_indices()) {
			
			log +="\n"
				+ "    Indice de juego: " + gameIndice.getGame_index() + "\n"
				+ "\n"
				+ "    Version\n"
				+ "    nombre: " + gameIndice.getVersion().getName() + "\n"
				+ "    URL: " + gameIndice.getVersion().getUrl() + "\n"
				+ "\n"
				+ "";
		}
		
		
			log +="    ------------------------------------Areas donde se ah encontrado---------------------------------\n"
				+ "\n"
				+ "    areas: " + pokemon.getLocation_area_encounters() + "\n"
				+ "\n"
				+ "    --------------------------------------------Movimientos------------------------------------------\n";
		
		for(Moves move : pokemon.getMoves()) {
			
			log +="\n"
				+ "                                                Movimiento\n"
				+ "    Nombre: " + move.getMove().getName() + "\n"
				+ "    URL: " + move.getMove().getUrl() + "\n"
				+ "\n";
			
			for(VersionGroupDetails details : move.getVersion_group_details()) {
				
				log +=""
					+ "    Detalles del grupo de verciones\n"
					+ "    Nivel aprendido en: " + details.getLevel_learned_at() + "\n"
					+ "\n"
					+ "    Grupo de versiones\n"
					+ "    Nombre: " + details.getVersion_group().getName() + "\n"
					+ "    URL: " + details.getVersion_group().getUrl() + "\n"
					+ "\n"
					+ "";
			}
		}
		
		log +="    ----------------------------------------------Especie--------------------------------------------\n"
			+ "\n"
			+ "    Nombre: "+ pokemon.getSpecies().getName() + "\n"
			+ "    URL: " + pokemon.getSpecies().getUrl() + "\n"
			+ "\n"
			+ "    --------------------------------------------Estadisticas-----------------------------------------\n"
			+ "";
		
		for(Stats stat : pokemon.getStats()) {
			
			log +="\n"
				+ "    Estadistica base: " + stat.getBase_stat() + "\n"
				+ "    Esfuerzo: " + stat.getBase_stat() + "\n"
				+ "\n"
				+ "    Estadistica\n"
				+ "    Nombre: " + stat.getStat().getName() + "\n"
				+ "    URL: " + stat.getStat().getUrl() + "\n"
				+ "\n"
				+ "";
			
		}
		           
			log +="    -----------------------------------------------Tipos---------------------------------------------\n";
		
		for(Types type : pokemon.getTypes()) {
			
			log +="\n"
				+ "    Espacio: " +type.getSlot() + "\n"
				+ "\n"
				+ "    Tipo\n"
				+ "    Nombre: " + type.getType().getName() + "\n"
				+ "    URL: " + type.getType().getUrl() + "\n"
				+ "\n"
				+ "";
		}
		
			log +="   ___________________________________________________________________________________________________"
				+ "\n";
		
		System.out.println(log);
		
	}
		
	/**
	 * Metodo que lee el archivo json familia.json y obtiene su contenido
	 * para mostrarlo en consola.
	 * */
	public static void familia(String nombre) {
		
		String json = getResource(nombre);
		
		Gson gson = new Gson();
	    Familia familia = (Familia) gson.fromJson(json, Familia.class);
	    
	    String log;
	    
	    	log = ""
	    		+ "   _______________________________________________FAMILIA_____________________________________________\n"
	    		+ "\n"
	    		+ "    Apellido: " + familia.getApellido() + "\n"
	    		+ "    Localidad de origen: " + familia.getLocalidad_de_origen() + "\n"
	    		+ "    Numero de integrantes: " + familia.getNumero_de_integrantes() + "\n"
	    		+ "\n"
	    		+ "    -----------------------------------------------Abuela--------------------------------------------\n"
	    		+ "    Nombre: " + familia.getAbuela().getNombre() + "\n"
	    		+ "    Edad: " + familia.getAbuela().getEdad() + " años \n"
	    		+ "    Viva: " + familia.getAbuela().isViva() + "\n"
	    		+ "\n"
	    		+ "    ------------------------------------------------Hijos--------------------------------------------\n" 
	    		+ "    Nombre: " + familia.getHijos().getHenrry().getNombre() + "\n"
	    		+ "    Edad: " + familia.getHijos().getHenrry().getEdad() + " años \n"
	    		+ "\n"
	    		+ "    Nombre: " + familia.getHijos().getFrank().getNombre() + "\n"
	    		+ "    Edad: " + familia.getHijos().getFrank().getEdad() + " años \n"
	    		+ "\n"
	    		+ "    -----------------------------------------Fechas de reuniones-------------------------------------\n"
	    		+ "";
	    	
	    	
	    	for(String fechas : familia.getFechas_de_reuniones()) {
	    		
	    		log += "    " + fechas + "\n";
	    	}
	    	
	    	log +="\n"
	    		+ "\n"
	    		+ "    -----------------------------------------------FRUTAS--------------------------------------------\n"
	    		+ "\n"
	    		+ "";
	    	
	    	for(Frutas frutas : familia.getFrutas()) {
	    		
	    		log +="     Nombre: " + frutas.getNombre() + "\n"
	    			+ "     Familia: " + frutas.getFamilia() + "\n"
	    			+ "     _________________________________________________  \n"
	    			+ "    |               Caracteristicas                   | \n"
	    			+ "    |_________________________________________________| \n"
	    			+ "    |            |                                    | \n"
	    			+ "    | color      |        "  + frutas.getCaracteristicas().getColor() + "                       | \n"
	    			+ "    |------------|------------------------------------| \n"
	    			+ "    | sabor      |        "  + frutas.getCaracteristicas().getSabor() + "                       | \n"
	    			+ "    |____________|____________________________________| \n"
	    			+ "\n"
	    			+ "\n"
	    			+ "";
	    		
	    	}
	    	
	    	
	    		log +="   ___________________________________________________________________________________________________"
	    			+ "\n";

	    System.out.println(log);

		
	}
	

}














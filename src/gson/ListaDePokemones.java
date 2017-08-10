package gson;

/**
 * Clase que almacena los valores del archivo json lista de pokemones.json.
 * */
public class ListaDePokemones {

	private int count;
	private String previous;
	private Results[] results;
	
	
	// Metodos
	public int getCount() {
		return count;
	}
	
	public String getPrevious() {
		return previous;
	}
	
	public Results[] getResults() {
		return results;
	}
	
	
	// Clase
	public class Results {
		
		private String name;
		private String url;
		
		
		// Metodos
		public String getName() {
			return name;
		}
		
		public String getUrl() {
			return url;
		}

	}

}

package gson;

/**
 * Clase que almacena los valores del archivo json familia.json.
 * */
public class Familia {
	
	private String apellido;
	private int numero_de_integrantes;
	private String localidad_de_origen;
	private Abuela abuela;
	private Hijos hijos;
	private String[] fechas_de_reuniones;
	private Frutas[] frutas;
	

	// Metodos
	public String getApellido() {
		return apellido;
	}

	public int getNumero_de_integrantes() {
		return numero_de_integrantes;
	}

	public String getLocalidad_de_origen() {
		return localidad_de_origen;
	}

	public Abuela getAbuela() {
		return abuela;
	}
	
	public Hijos getHijos() {
		return hijos;
	}

	public String[] getFechas_de_reuniones() {
		return fechas_de_reuniones;
	}

	public Frutas[] getFrutas() {
		return frutas;
	}
	
	
	// Clases
	public class Abuela {
		
		private String nombre;
		private int edad;
		private boolean viva;
		
		
		// Metodos
		public String getNombre() {
			return nombre;
		}
		
		public int getEdad() {
			return edad;
		}
		
		public String isViva() {
			return viva ? "si" : "no" ;
		}

		
	}

	public class Hijos {
		
		private Henrry henrry;
		private Frank frank;
		
		
		// Metodos
		public Henrry getHenrry() {
			return henrry;
		}

		public Frank getFrank() {
			return frank;
		}

		
		// Clases
		public class Henrry {
			
			private String nombre;
			private int edad;
			
			
			// Metodos
			public String getNombre() {
				return nombre;
			}
			
			public int getEdad() {
				return edad;
			}

		}
		
		public class Frank {

			private String nombre;
			private int edad;
			
			
			// Metodos
			public String getNombre() {
				return nombre;
			}
			
			public int getEdad() {
				return edad;
			}

		}

	}

	public class Frutas {

		private String nombre;
		private String familia;
		private Caracteristicas caracteristicas;

		
		// Metodos
		public String getNombre() {
			return nombre;
		}

		public String getFamilia() {
			return familia;
		}

		public Caracteristicas getCaracteristicas() {
			return caracteristicas;
		}
		
		
		// Clase
		public class Caracteristicas {
			
			private String color;
			private String sabor;
			
			// Metodos
			public String getColor() {
				return color;
			}
			
			public String getSabor() {
				return sabor;
			}

		}

	}
}

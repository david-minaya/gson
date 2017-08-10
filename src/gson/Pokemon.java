package gson;

/**
 * Clase que almacena los valores del archivo json bulbasaur.json o 
 * charizard.json. Dependiendo de la opcion que seleccione el usuario.
 * */
public class Pokemon {

	private int id;
	private String name;
	private int base_experience;
	private int height;
	private boolean is_default;
	private int order;
	private int weight;
	private Abilities[] abilities;
	private Forms[] forms;
	private GameIndices[] game_indices;
	private HeldItems[] held_items;
	private String location_area_encounters;
	private Moves[] moves;
	private Species species;
	private Stats[] stats;
	private Types[] types;
	
	
	//-----------------------------------------------------------------
	// Metodos
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBase_experience() {
		return base_experience;
	}

	public int getHeight() {
		return height;
	}

	public boolean isIs_default() {
		return is_default;
	}

	public int getOrder() {
		return order;
	}

	public int getWeight() {
		return weight;
	}

	public Abilities[] getAbilities() {
		return abilities;
	}

	public Forms[] getForms() {
		return forms;
	}
	
	public GameIndices[] getGame_indices() {
		return game_indices;
	}
	
	public HeldItems[] getHeld_items() {
		return held_items;
	}
	
	public String getLocation_area_encounters() {
		return location_area_encounters;
	}

	public Moves[] getMoves() {
		return moves;
	}

	public Species getSpecies() {
		return species;
	}
	
	public Stats[] getStats() {
		return stats;
	}
	
	public Types[] getTypes() {
		return types;
	}
	
	
	//-----------------------------------------------------------------
	// Clases

	public class Abilities {
		
		private boolean is_hidden;
		private int slot;
		private Ability ability;
		
		
		// Metodos
		public boolean isIs_hidden() {
			return is_hidden;
		}

		public int getSlot() {
			return slot;
		}

		public Ability getAbility() {
			return ability;
		}
		

		// Clase
		public class Ability {
			
			private String name;
			private String url;
			
			public String getName() {
				return name;
			}
			
			public String getUrl() {
				return url;
			}

		}

	}

	public class Forms {

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
	
	public class GameIndices {
		
		private int game_index;
		private Version version;
		
		
		// Metodos
		public int getGame_index() {
			return game_index;
		}
		
		public Version getVersion() {
			return version;
		}
		
		
		// Clase
		public class Version {
			
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
	
	public class HeldItems {}
	
	public class LocationAreaEncounters {}
	
	public class Moves {
		
		private Move move;
		private VersionGroupDetails[] version_group_details;
		
		
		// Metodos
		public Move getMove() {
			return move;
		}
		
		public VersionGroupDetails[] getVersion_group_details() {
			return version_group_details;
		}
		
		
		// Clases
		public class Move {
			
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
		
		public class VersionGroupDetails {
			
			private int level_learned_at;
			private VersionGroup version_group;
			
			
			// Metodos
			public int getLevel_learned_at() {
				return level_learned_at;
			}
			
			public VersionGroup getVersion_group() {
				return version_group;
			}
			
			
			// Clase
			public class VersionGroup {
				
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
		
	}
	
	public class Species {
		
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
	
	public class Stats {
		
		private int base_stat;
		private int effort;
		private Stat stat;
		
		
		// Metodos
		public int getBase_stat() {
			return base_stat;
		}
		
		public int getEffort() {
			return effort;
		}
		
		public Stat getStat() {
			return stat;
		}
		
		
		// Clase
		public class Stat {
			
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

	public class Types {
		
		private int slot;
		private Type type;
		
		
		// Metodos
		public int getSlot() {
			return slot;
		}
		
		public Type getType() {
			return type;
		}
		
		
		// Clase
		public class Type {
			
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
	
}

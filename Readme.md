# Gson

Este es un sencillo ejemplo de cómo leer objetos json utilizando la librería Gson de Google. En este proyecto solo se trata el tema de forma muy básica de lectura de archivos json utilizando la librería Gson. 

La librería Gson posee muchas funcionalidades, tales como, la serialización de objetos java a json, las anotaciones, entre otras. En este proyecto solo nos centraremos en la lectura de archivos json de manera sencilla.

Puede encontrar otro ejemplo sencillo de cómo funciona esta librería en [Wikipedia](https://es.wikipedia.org/wiki/Gson).

### Integración de la librería

Para la integración de Gson en su proyecto java primero tiene que descargar la librería. Puede descargarla desde la siguiente [página](http://search.maven.org/#artifactdetails%7Ccom.google.code.gson%7Cgson%7C2.8.1%7C). Al entrar en la página seleccione el enlace que está al lado de donde dice "Browse Central For", al seleccionar el enlace entrara a la página de descarga. En esta le aparecerán diferentes enlaces de descarga, tiene que seleccionar el enlace que dice "gson-X.X.X.jar" (las "X" vendrían a ser el número de versión de la librería). En este caso se descargó la librería "gson-2.8.1.jar". 

Con la librería ya descargada, pasamos a integrarla al proyecto. En este caso el proyecto se desarrolló en el IDE [Eclipse](https://es.wikipedia.org/wiki/Eclipse_(software)). Una de las formas de integrar la librería en Eclipse es seleccionando la opción  "Add External JARs...", para acceder a esta opción siga los siguientes pasos: clic derecho sobre el proyecto>Properties>Java Build Path>Libraries y por ultimo Add External JARs... Al seleccionar la opción se abrirá el explorador de archivos, diríjase a la ubicación donde descargo la librería, selecciónela y de click sobre el botón abrir (o "open" si su computadora esta en inglés). Por último de click en el botón Apply and Close. Con esto la librería Gson quedara integrada en su proyecto.

### Leyendo Archivos Json con Gson

[Gson](https://github.com/google/gson) es una librería proporcionada por Google para la [serializacion](https://es.wikipedia.org/wiki/Serializaci%C3%B3n) y de serialización de objetos json a objetos java y viceversa. 

Un objeto [json](https://es.wikipedia.org/wiki/JSON) puede almacenar valores en variables, objetos y Arrays. Para facilitar la explicación solo nos referiremos a las variables.

> Este es un objeto json con: 2 variables, un objeto y un array.

```json
{
  "nombre": "Juan Pedro",
  "Edad": 20,
  "hijo": {
    "nombre": "manuelito",
    "edad": 10
  },
  "hermanos": ["Josefina", "Andres", "Jose"] 
}
```

Un objeto json puede estar almacenado en una variable de tipo String (como se muestra más adelante), en un archivo de texto (los cuales tienen la extensión .json), etc... Un objeto json se puede identificar fácilmente por las llaves {} que encierran su contenido. Por ejemplo, en el fragmento de código anterior, "hijo" es un objeto, ya que su contenido se encuentra dentro de las llaves. 

La librería Gson facilita la lectura de objetos json, ya que para la serializar objetos json a objetos java solo es necesario crear una clase que contenga las mismas variables, objetos y arrays que contiene el archivo json. Las variables, objetos y arrays que se declaren en la clase deben de ser del mismo tipo y poseer el mismo nombre que las variables, objetos y arrays del objeto json. Por ejemplo, si el objeto json tiene una variables de tipo `String` que se llama `"nombre"`, en la clase se debe declarar una variable de tipo `String` que también se llame `nombre`. 

**Ej:**

Objeto json

```json
{
  "nombre": "Juan Pedro",
  "edad": 30
}
```

Clase java

```java
public class Persona {
  
  String nombre;
  int edad;
  
  public String getNombre() {
    return nombre;
  }
  
  public int getEdad() {
    return edad;
  }
  
}
```

Al realizar la serialización (que se explica más adelante) los valores de las variables, objetos y arrays del objeto json se almacenan en las variables, objetos y arrays que posean el mismo nombre en la clase creada para la serialización. Como se muestra en el ejemplo anterior, el valor de la variable `"nombre"` del objeto json pasaría a almacenarse en la variable `nombre` de la clase Persona. Se debe tener en cuenta que las variables de la clase que almacenan los valores del objeto json deben de ser del mismo tipo, de lo contrario la librería Gson lanzara una excepción.

Como en este proyecto solo se trata la lectura de objetos json, en las clases solo se declararon las variables, objetos y arrays que almacenan los datos del objeto json, y los métodos get para obtener sus valores.

#### Serialización

Para realizar la serialización se debe crear una instancia de la clase Gson. De esta clase se utiliza el método `fromJson()` para realizar la serialización, este método recibe dos parámetros, el objeto json que se serializara (puede ser de tipo String, Reader, JsonReader entre otros) y la clase que almacenara los valores del objeto json.

También es necesario crear una instancia de la clase que almacenara los valores del objeto json, en esta instancia se implementa el método `fromJson()` para realizar la serialización. Y por último solo hay que acceder a las variables de la clase para obtener a los valores.

**Ej:**

```java
// Objeto json almacenado en una variable de tipo String
String json = "{\"nombre\":\"Juan Pedro\",\"edad\":30}";

// Instancia de la Clase Gson
Gson gson = new Gson();

// Instancia de la clase Persona e implementación del método fromJson() 
// para la serialización del objeto json. 
Persona persona = (Persona) gson.fromJson(json, Persona.class);

// Obteniendo los valores del objeto json almacenados en las variables
// de la clase Persona.
System.out.println("nombre: " + persona.getNombre() + "\nedad: " + persona.getEdad());
```



#### Este proyecto

En este proyecto los objetos json están almacenados en los archivos json que se encuentran en la carpeta res del proyecto. Por lo que para su lectura primero se obtiene su contenido y se almacena en variables de tipo String, esas variables son pasadas como parámetro al método fromJson() junto con la clase creada para almacenar los valores del objeto json.

La lógica de este proyecto es sencilla, al ejecutarlo se le mostrara un menú de opciones en consola, donde se le dan las opciones de abrir algún archivo json o finalizar el programa. Si selecciona un archivo se le mostrara el contenido de este, después se le mostrara otro menú en el que se dan las opciones de finalizar el programa o no, si selecciona la opción de no finalizar el programa se le mostrara de nuevo el primer menú de opciones. Si selecciona en cualquiera de los menús la opción de finalizar el programa, el programa finalizara su ejecución.

En la carpeta raíz de este proyecto se encuentra el archivo ejecutable gson.jar. Si tiene java instalado en su computadora lo puede ejecutar fácilmente ejecutando el comando en consola `java -jar gson.jar`. Claro antes de ejecutar el comando primero tiene que descargarlo y abrir la consola en la carpeta que lo ha descargado.

#### Conclusiones

Siéntase libre de probar, modificar y jugar con el código de este proyecto. Si encuentra errores tanto en el proyecto como en este documento, por favor corríjalos. Cualquier modificación que mejore la calidad de este proyecto es bienvenida.

Espero que este pequeño ejemplo le haya sido de ayuda para entender cómo funcionan los objetos json y la librería Gson.

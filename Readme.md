# Gson

Este es un sencillo ejemplo de c�mo leer objetos json utilizando la librer�a Gson de Google. En este proyecto solo se trata el tema de forma muy b�sica de lectura de archivos json utilizando la librer�a Gson. 

La librer�a Gson posee muchas funcionalidades, tales como, la serializaci�n de objetos java a json, las anotaciones, entre otras. En este proyecto solo nos centraremos en la lectura de archivos json de manera sencilla.

Puede encontrar otro ejemplo sencillo de c�mo funciona esta librer�a en [Wikipedia](https://es.wikipedia.org/wiki/Gson).

### Integraci�n de la librer�a

Para la integraci�n de Gson en su proyecto java primero tiene que descargar la librer�a. Puede descargarla desde la siguiente [p�gina](http://search.maven.org/#artifactdetails%7Ccom.google.code.gson%7Cgson%7C2.8.1%7C). Al entrar en la p�gina seleccione el enlace que est� al lado de donde dice "Browse Central For", al seleccionar el enlace entrara a la p�gina de descarga. En esta le aparecer�n diferentes enlaces de descarga, tiene que seleccionar el enlace que dice "gson-X.X.X.jar" (las "X" vendr�an a ser el n�mero de versi�n de la librer�a). En este caso se descarg� la librer�a "gson-2.8.1.jar". 

Con la librer�a ya descargada, pasamos a integrarla al proyecto. En este caso el proyecto se desarroll� en el IDE [Eclipse](https://es.wikipedia.org/wiki/Eclipse_(software)). Una de las formas de integrar la librer�a en Eclipse es seleccionando la opci�n  "Add External JARs...", para acceder a esta opci�n siga los siguientes pasos: clic derecho sobre el proyecto>Properties>Java Build Path>Libraries y por ultimo Add External JARs... Al seleccionar la opci�n se abrir� el explorador de archivos, dir�jase a la ubicaci�n donde descargo la librer�a, selecci�nela y de click sobre el bot�n abrir (o "open" si su computadora esta en ingl�s). Por �ltimo de click en el bot�n Apply and Close. Con esto la librer�a Gson quedara integrada en su proyecto.

### Leyendo Archivos Json con Gson

[Gson](https://github.com/google/gson) es una librer�a proporcionada por Google para la [serializacion](https://es.wikipedia.org/wiki/Serializaci%C3%B3n) y de serializaci�n de objetos json a objetos java y viceversa. 

Un objeto [json](https://es.wikipedia.org/wiki/JSON) puede almacenar valores en variables, objetos y Arrays. Para facilitar la explicaci�n solo nos referiremos a las variables.

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

Un objeto json puede estar almacenado en una variable de tipo String (como se muestra m�s adelante), en un archivo de texto (los cuales tienen la extensi�n .json), etc... Un objeto json se puede identificar f�cilmente por las llaves {} que encierran su contenido. Por ejemplo, en el fragmento de c�digo anterior, "hijo" es un objeto, ya que su contenido se encuentra dentro de las llaves. 

La librer�a Gson facilita la lectura de objetos json, ya que para la serializar objetos json a objetos java solo es necesario crear una clase que contenga las mismas variables, objetos y arrays que contiene el archivo json. Las variables, objetos y arrays que se declaren en la clase deben de ser del mismo tipo y poseer el mismo nombre que las variables, objetos y arrays del objeto json. Por ejemplo, si el objeto json tiene una variables de tipo `String` que se llama `"nombre"`, en la clase se debe declarar una variable de tipo `String` que tambi�n se llame `nombre`. 

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

Al realizar la serializaci�n (que se explica m�s adelante) los valores de las variables, objetos y arrays del objeto json se almacenan en las variables, objetos y arrays que posean el mismo nombre en la clase creada para la serializaci�n. Como se muestra en el ejemplo anterior, el valor de la variable `"nombre"` del objeto json pasar�a a almacenarse en la variable `nombre` de la clase Persona. Se debe tener en cuenta que las variables de la clase que almacenan los valores del objeto json deben de ser del mismo tipo, de lo contrario la librer�a Gson lanzara una excepci�n.

Como en este proyecto solo se trata la lectura de objetos json, en las clases solo se declararon las variables, objetos y arrays que almacenan los datos del objeto json, y los m�todos get para obtener sus valores.

#### Serializaci�n

Para realizar la serializaci�n se debe crear una instancia de la clase Gson. De esta clase se utiliza el m�todo `fromJson()` para realizar la serializaci�n, este m�todo recibe dos par�metros, el objeto json que se serializara (puede ser de tipo String, Reader, JsonReader entre otros) y la clase que almacenara los valores del objeto json.

Tambi�n es necesario crear una instancia de la clase que almacenara los valores del objeto json, en esta instancia se implementa el m�todo `fromJson()` para realizar la serializaci�n. Y por �ltimo solo hay que acceder a las variables de la clase para obtener a los valores.

**Ej:**

```java
// Objeto json almacenado en una variable de tipo String
String json = "{\"nombre\":\"Juan Pedro\",\"edad\":30}";

// Instancia de la Clase Gson
Gson gson = new Gson();

// Instancia de la clase Persona e implementaci�n del m�todo fromJson() 
// para la serializaci�n del objeto json. 
Persona persona = (Persona) gson.fromJson(json, Persona.class);

// Obteniendo los valores del objeto json almacenados en las variables
// de la clase Persona.
System.out.println("nombre: " + persona.getNombre() + "\nedad: " + persona.getEdad());
```



#### Este proyecto

En este proyecto los objetos json est�n almacenados en los archivos json que se encuentran en la carpeta res del proyecto. Por lo que para su lectura primero se obtiene su contenido y se almacena en variables de tipo String, esas variables son pasadas como par�metro al m�todo fromJson() junto con la clase creada para almacenar los valores del objeto json.

La l�gica de este proyecto es sencilla, al ejecutarlo se le mostrara un men� de opciones en consola, donde se le dan las opciones de abrir alg�n archivo json o finalizar el programa. Si selecciona un archivo se le mostrara el contenido de este, despu�s se le mostrara otro men� en el que se dan las opciones de finalizar el programa o no, si selecciona la opci�n de no finalizar el programa se le mostrara de nuevo el primer men� de opciones. Si selecciona en cualquiera de los men�s la opci�n de finalizar el programa, el programa finalizara su ejecuci�n.

En la carpeta ra�z de este proyecto se encuentra el archivo ejecutable gson.jar. Si tiene java instalado en su computadora lo puede ejecutar f�cilmente ejecutando el comando en consola `java -jar gson.jar`. Claro antes de ejecutar el comando primero tiene que descargarlo y abrir la consola en la carpeta que lo ha descargado.

#### Conclusiones

Si�ntase libre de probar, modificar y jugar con el c�digo de este proyecto. Si encuentra errores tanto en el proyecto como en este documento, por favor corr�jalos. Cualquier modificaci�n que mejore la calidad de este proyecto es bienvenida.

Espero que este peque�o ejemplo le haya sido de ayuda para entender c�mo funcionan los objetos json y la librer�a Gson.

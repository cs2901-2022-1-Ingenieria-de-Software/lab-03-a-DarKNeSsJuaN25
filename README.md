# LAB 03 A

Contexto:

Se esta desarrollando una aplicacion que calcule el total con impuestos para generar un reporte para gerencia y revisar el presupuesto.

Para ello se reciben ordenes por cada pais con la cantidad de Widgets a pedir.

# Ejercicio 1: Refactorizar(Hacer que el codigo sea testeable)

Revisar las clases ManageDemand, Tax y Order si consideran que se puede refactorizar el codigo.

Un tip es si su codigo responde: 
- Es testeable ? 
- Encuentro un code smell ?
- Podria aplicar SOLID ? 

Recordar: para correr la app mvn exec:java
--RESPUESTA-----

-El codigo inicialmente responde. Sin embargo, la implementacion usada no es la adecuada, presentandose code smells que se explicaran en el siguiente punto.

-En primer lugar, el duplicado de codigo en el uso de metodos de las clases. Por ejemplo, en el metodo calculateTotaFor...(), se escribe unas condicionales que ya estan implementadas en el metodo calculateTaxes(). Esto tambiene esta presente en el metodo de calculateTotal(), donde se tienen dos for que realizan la misma accion, solo que con "inputs" diferentes. 

Si se podria aplicar SOLID, pero con un cambio de los metodos y clases.
Despues de los cambios, quedaria asi:
-Cada metodo cumple una unica funcion (S)
-No importa que pais o taxes ingresen, la funcion no se alterara (O)
-No existen subclases (L)
-No existe interfaz con implementacion forzada de metodos (I)
-Los modulos de alto nivel no dependen de los de bajo nivel (D) 

# Ejercicio 2: Agregar Pruebas Unitarias ( JUnits )

Agregar todos los tests de los casos que consideren necesarios.

Un tip:
- Consideren primero los happy path o caminos de codigo que si o si deberian ser testeados para asegurarnos que la aplicacion funcione.
- Cubrir Edge Cases(Excepciones, Casos atipicos como cadena vacia, valores invalidos)

Recordar: para correr tests mvn verifyç

=======================================================================================================

GIT:

git clone <repo>
git status
git pull origin <branch>
git add .
git commit -m “<commit message>”
git push origin <branch>

MAVEN:

mvn clean // borra toda la carpeta target
mvn compile // compila archivos java
mvn install // genera el jar(empaquetado)
mvn clean install // genera el jar
mvn verify // corre solo los tests(junit)

CORRER:

mvn exec:java -Dexec.mainClass=“com.lab.Main”
o
mvn exec:java

Librerias Java Utiles:

java.util.Arrays;
java.util.Collections;



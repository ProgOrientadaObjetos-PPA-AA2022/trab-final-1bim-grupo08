# Trabajo Final del Primer Bimestre - Programación Orientada a Objetos

Necesitamos realizar un sistema de gestión de una inmobiliaria. En la empresa se necesita llevar el registro de constructoras, edificios, departamentos, casas

A continuación se definen algunas características de las entidades:

***Una casa tiene propiedades como:***

- propietario (nombres, apellidos, identificación)
- precio por metro cuadrado.
- número de metros cuadrados.
- costo final 
- barrio (nombre del barrio, referencia)
- ciudad (nombre ciudad, nombre provincia)
- numero de cuartos
- constructora (nombre constructora, id de la empresa)

***Un departamento posee características como:***

- propietario (nombres, apellidos, identificación)
- precio por metro cuadrado.
- número de metros cuadrados.
- valor alícuota mensual
- costo final 
- barrio (nombre del barrio, referencia)
- ciudad (nombre ciudad, nombre provincia)
- nombre de edificio
- ubicacion del departamento en edificio
- constructora (nombre constructora, id de la empresa)


### El sistema debe permitir ingresar:

- Propietarios
- Barrio
- Ciudades
- Constructoras
- Casas
- Departamentos

#### Características:

* Todos los objetos de tipo propietario se deben ingresar y guardar en un archivo llamado propietarios.dat
* Todos los objetos de tipo barrio se deben ingresar y guardar en un archivo llamado barrios.dat
* Todos los objetos de tipo ciudad se deben ingresar y guardar en un archivo llamado ciudades.dat
* Todos los objetos de tipo constructora se deben ingresar y guardar en un archivo llamado constructoras.dat
* Todos los objetos de tipo casa se deben ingresar y guardar en un archivo llamado casas.dat
* Para el ingreso de una casa se debe tomar en consideración lo siguiente:
	* El propietario se debe obtener del archivo propietarios.dat a través de la identificacion.
	* El barrio se debe obtener del archivo barrio.dat a través del nombre del barrio.
	* La ciudad se debe obtener del archivo ciudades.dat a través del nombre de la ciudad.
	* La constructora se debe obtener del archivo constructoras.dat a través del id de la empresa.
	* El costo final es igual al número de metros * precio del metro cuadrado.
    
* Todos los objetos de tipo departamento se deben ingresar y guardar en un archivo llamado departamentos.dat
* Para el ingreso de un departamento se debe tomar en consideración lo siguiente:
	* El propietario se debe obtener del archivo propietarios.dat a través de la identificacion.
	* El barrio se debe obtener del archivo barrio.dat a través del nombre del barrio.
	* La ciudad se debe obtener del archivo ciudades.dat a través del nombre de la ciudad.
	* La constructora se debe obtener del archivo constructoras.dat a través del id de la empresa.
	* El costo final es igual al (número de metros * valor del metro cuadrado) + (valor alícuota mensual * 12).
 
* Se debe poder listar los datos ingresados para:
	* Propietarios
	* Barrios
	* Ciudades
	* Constructoras
	* Casas
	* Departamentos

### Herramientas a usar

- Lenguaje de programación Java
- Diagramador - DIAUML
- Git
- Github / GitHub-classroom

### Fecha de presentación

- Semana 8 del primer bimestre

### Importante

- El trabajo es grupal.
- Se debe generar una solución en UML y lenguaje de programación en Java.
- Se ha creado un proyecto de netbeans, en el cual existen creados paquetes y clases; con base al proyecto, seguir con el desarrollo de la solución. 
- Usted debe adicionar las clases que sean necesarias.
- Es importante usar método constructores en las clases.
- Usted debe crear una carpeta donde se ubican los diagramas de las clases.

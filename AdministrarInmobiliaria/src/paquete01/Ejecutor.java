
package paquete01;
import java.util.Scanner;
import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;
import paquete06.*;

public class Ejecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreEdificio; 
        String ubicacionEdificio;
        Propietario propietario;
        Barrio barrio;
        Ciudad ciudad;
        Constructora constructora;
        double precioMetroCuadrado, metrosCuadrados;
        int op;
        int numeroCuartos;
        System.out.println("Inicio del programa");
        do {
            op = menu();
            switch (op) {
                case 1:
                    propietario = encontrarPropietarioBuscado();
                    barrio = encontrarBarrioBuscado();
                    ciudad = encontrarCiudadBuscada();
                    constructora = encontrarConstructoraBuscada();
                    System.out.println("Ingrese el valor del metro cuadrado: ");
                    precioMetroCuadrado = sc.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados de la casa: ");
                    metrosCuadrados = sc.nextDouble();
                    System.out.println("Ingrese el numero de cuartos de la casa: ");
                    numeroCuartos = sc.nextInt();
                    Casa casa = new Casa(precioMetroCuadrado, metrosCuadrados, numeroCuartos, propietario, barrio, ciudad, constructora);
                    casa.establecerCostoFinal();
                    ArchivoEscrituraCasa archivocasa = new ArchivoEscrituraCasa("datos/casas.dat");
                    archivocasa.establecerRegistro(casa);
                    archivocasa.establecerSalida();
                    break;
                case 2:
                    propietario = encontrarPropietarioBuscado();
                    barrio = encontrarBarrioBuscado();
                    ciudad = encontrarCiudadBuscada();
                    constructora = encontrarConstructoraBuscada();
                    System.out.println("Ingrese el precio por metro cuadrado: ");
                    precioMetroCuadrado = sc.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados: ");
                    metrosCuadrados = sc.nextDouble();
                    System.out.println("Ingrese valor alicuota mensual: ");
                    Double valorAlicuota = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del edificio: ");
                    nombreEdificio = sc.nextLine();
                    System.out.println("Ingrese la ubicacion del edificio: ");
                    ubicacionEdificio = sc.nextLine();
                    Departamento departamento = new Departamento(propietario,precioMetroCuadrado,metrosCuadrados,valorAlicuota,barrio,ciudad,nombreEdificio,ubicacionEdificio,constructora);
                    departamento.establecerValorFinal();
                    ArchivoEscrituraDepartamento archivodepar = new ArchivoEscrituraDepartamento("datos/departamentos.dat");
                    archivodepar.establecerRegistro(departamento);
                    archivodepar.establecerSalida();
                    break;
                case 3:
                    System.out.println("Ingrese nombres del propietario: ");
                    String nombresPropietario = sc.nextLine();
                    System.out.println("Ingrese apellidos del propietario: ");
                    String apellidosPropietario = sc.nextLine();
                    System.out.println("Ingrese identificacion del propietario(dni): ");
                    String identificacionPropietario = sc.nextLine();
                    propietario = new Propietario(nombresPropietario, apellidosPropietario, identificacionPropietario);
                    ArchivoEscrituraPropietario archivop = new ArchivoEscrituraPropietario("datos/propietarios.dat");
                    System.out.println(propietario);
                    archivop.establecerRegistro(propietario);
                    archivop.establecerSalida();
                    break;
                case 4:
                    System.out.println("Ingrese nombre del barrio: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese referencia del barrio: ");
                    String referencia = sc.nextLine();
                    barrio = new Barrio(nombre, referencia);
                    ArchivoEscrituraBarrio archivob = new ArchivoEscrituraBarrio("datos/barrios.dat");
                    System.out.println(archivob.toString());
                    archivob.establecerRegistro(barrio);
                    archivob.establecerSalida();
                    break;
                case 5:
                    System.out.println("Ingrese nombre de la ciudad: ");
                    String nombreCiudad = sc.nextLine();
                    System.out.println("Ingrese nombre de la provincia: ");
                    String provincia = sc.nextLine();
                    ciudad = new Ciudad(nombreCiudad, provincia);
                    ArchivoEscrituraCiudad archivociu = new ArchivoEscrituraCiudad("datos/ciudades.dat");
                    archivociu.establecerRegistro(ciudad);
                    archivociu.establecerSalida();
                    break;
                case 6:
                    
                    System.out.println("Ingrese nombre de la constructora: ");
                    String nombreConstructora = sc.nextLine();
                    System.out.println("Ingrese id de la constructora:");
                    String idEmpresa = sc.nextLine();
                    Constructora c1 = new Constructora(nombreConstructora, idEmpresa);
                    ArchivoEscrituraConstructora archivocons = new ArchivoEscrituraConstructora("datos/constructoras.dat");
                    archivocons.establecerRegistro(c1);
                    archivocons.establecerSalida();
                    break;
                case 7:
                    do {                        
                        op = menu2();
                        mostrar(op);
                    } while (op!=0);
                    op = 7;
                    break;
                case 0:
                    System.out.println("Fin del programa");
            }
        } while (op != 0);
    }
     public static int menu() {
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("-------------------------------------+");
        System.out.println("1)Ingresar nueva Casa:               |");
        System.out.println("2)Ingresar nuevo Departamento:       |");
        System.out.println("3)Ingresar nuevo Propietario:        |");
        System.out.println("4)Ingresar nuevo Barrio:             |");
        System.out.println("5)Ingresar nueva Ciudad:             |");
        System.out.println("6)Ingresar nueva Constructora:       |");
        System.out.println("7)Observar Listas:                   |");
        System.out.println("0)Salir del Programa:                |");
        System.out.println("-------------------------------------+");
        op = sc.nextInt();
        return op;
    }
     public static int menu2() {
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("--------------------------------------+");
        System.out.println("1)Obervar Lista casas:                |");
        System.out.println("2)Obervar Lista departamentos:        |");
        System.out.println("3)Obervar Lista propietarios:         |");
        System.out.println("4)Obervar Lista barrios:              |");
        System.out.println("5)Obervar Lista ciudades:             |");
        System.out.println("6)Obervar Lista constructoras:        |");
        System.out.println("0)Regresar menu anterior:             |");
        System.out.println("--------------------------------------+");
        op = sc.nextInt();
        return op;
    }
    public static Propietario encontrarPropietarioBuscado() {
        Scanner sc = new Scanner(System.in);
        String identificacion;
        String nombres;
        String apellidos;
        String nombreArchivo = "datos/propietarios.dat";
        System.out.println("Ingrese identifiacion del propietario: ");
        identificacion = sc.nextLine();
        System.out.println("1");
        Propietario propietarioEncontrado;
        System.out.println("2");
        ArchivoLecturaPropietario lecturaP = new ArchivoLecturaPropietario(nombreArchivo);
        System.out.println("3");
        lecturaP.establecerIdentificador(identificacion);
        System.out.println("4");
        lecturaP.establecerPropietarioBuscado();
        System.out.println("5");
        propietarioEncontrado = lecturaP.obtenerPropietarioBuscado();
        System.out.println("6");
        if (propietarioEncontrado != null) {
            System.out.printf("Propietario encontrado %s\n", propietarioEncontrado);
            return propietarioEncontrado;
        } else {
            System.out.println("No se ha encontrado ese propietario, ingrese nuevo propietario");
            System.out.println("Ingrese nombres del propietario: ");
            nombres = sc.nextLine();
            System.out.println("Ingrese apellidos del propietario: ");
            apellidos = sc.nextLine();
            System.out.println("Ingrese identificacion del propietario: ");
            identificacion = sc.nextLine();
            Propietario propietario = new Propietario(nombres, apellidos, identificacion);
            ArchivoEscrituraPropietario archivop = new ArchivoEscrituraPropietario(nombreArchivo);
            archivop.establecerRegistro(propietario);
            archivop.establecerSalida();
            return propietario;
        }
    }

    public static Barrio encontrarBarrioBuscado() {
        Scanner sc = new Scanner(System.in);
        String nombreBarrio;
        String referencia;
        String nombreArchivo = "datos/barrios.dat";
        System.out.println("Ingrese nombre del barrio: ");
        nombreBarrio = sc.nextLine();
        Barrio barrioEncontrado;
        ArchivoLecturaBarrio lecturaB = new ArchivoLecturaBarrio(nombreArchivo);
        lecturaB.establecerIdentificador(nombreBarrio);
        lecturaB.establecerBarrioBuscado();
        barrioEncontrado = lecturaB.obtenerBarrioBuscado();
        if (barrioEncontrado != null) {
            System.out.printf("Barrio encontrado %s\n", barrioEncontrado);
            return barrioEncontrado;
        } else {
            System.out.println("No se ha encontrado ese barrio, ingrese nuevo barrio");
            System.out.println("Ingrese nombre del barrio: ");
            nombreBarrio = sc.nextLine();
            System.out.println("Ingrese referencia: ");
            referencia = sc.nextLine();
            Barrio barrio = new Barrio(nombreBarrio, referencia);
            ArchivoEscrituraBarrio archivob = new ArchivoEscrituraBarrio(nombreArchivo);
            archivob.establecerRegistro(barrio);
            archivob.establecerSalida();
            return barrio;
        }
    }

    public static Ciudad encontrarCiudadBuscada() {
        Scanner sc = new Scanner(System.in);
        String nombreCiudad;
        String nombreProvincia;
        String nombreArchivo = "datos/ciudades.dat";
        System.out.println("Ingrese nombre ciudad: ");
        nombreCiudad = sc.nextLine();
        Ciudad ciudadEncontrada;
        ArchivoLecturaCiudad lecturaC = new ArchivoLecturaCiudad(nombreArchivo);
        lecturaC.establecerIdentificador(nombreCiudad);
        lecturaC.establecerCiudadBuscada();
        ciudadEncontrada = lecturaC.obtenerCiudadBuscada();
        if (ciudadEncontrada != null) {
            System.out.printf("Ciudad encontrada %s\n", ciudadEncontrada);
            return ciudadEncontrada;
        } else {
            System.out.println("No se ha encontrado esa ciudad, ingrese nueva ciudad");
            System.out.println("Ingrese nombre de la ciudad: ");
            nombreCiudad = sc.nextLine();
            System.out.println("Ingrese nombre de la provincia: ");
            nombreProvincia = sc.nextLine();
            Ciudad ciudad = new Ciudad(nombreCiudad, nombreProvincia);
            ArchivoEscrituraCiudad archivociu = new ArchivoEscrituraCiudad(nombreArchivo);
            archivociu.establecerRegistro(ciudad);
            archivociu.establecerSalida();
            return ciudad;
        }
    }

    public static Constructora encontrarConstructoraBuscada() {
        Scanner sc = new Scanner(System.in);
        String nombreConstructora;
        String idEmpresa;
        String nombreArchivo = "datos/constructoras.dat";
        System.out.println("Ingrese id de la constructora: ");
        idEmpresa = sc.nextLine();
        Constructora constructoraEncontrada;
        ArchivoLecturaConstructora lecturaCo = new ArchivoLecturaConstructora(nombreArchivo);
        lecturaCo.establecerIdentificador(idEmpresa);
        lecturaCo.establecerConstructoraBuscada();
        constructoraEncontrada = lecturaCo.obtenerConstructoraBuscada();
        if (constructoraEncontrada != null) {
            System.out.printf("Constructora encontrada %s\n", constructoraEncontrada);
            return constructoraEncontrada;
        } else {
            System.out.println("No se ha encontrado esa constructora, ingrese nueva constructora");
            System.out.println("Ingrese nombre constructora: ");
            nombreConstructora = sc.nextLine();
            System.out.println("Ingrese id constructora: ");
            idEmpresa = sc.nextLine();
            Constructora constructora = new Constructora(nombreConstructora, idEmpresa);
            ArchivoEscrituraConstructora archivoco = new ArchivoEscrituraConstructora(nombreArchivo);
            archivoco.establecerRegistro(constructora);
            archivoco.establecerSalida();
            return constructora;
        }
    }

    public static void mostrar(int op2) {
        switch (op2) {
            case 1:
                ArchivoLecturaCasa lecturac = new ArchivoLecturaCasa("datos/casas.dat");
                lecturac.establecerCasa();
                System.out.printf("%s", lecturac.toString());
                lecturac.cerrarArchivo();
                break;
            case 2:
                ArchivoLecturaDepartamento lecturad = new ArchivoLecturaDepartamento("datos/departamentos.dat");
                lecturad.establecerDepartamento();
                System.out.printf("%s", lecturad.toString());
                lecturad.cerrarArchivo();
                break;
            case 3:
                ArchivoLecturaPropietario lecturap = new ArchivoLecturaPropietario("datos/propietarios.dat");
                lecturap.establecerPropietarios();
                System.out.printf("%s", lecturap.toString());
                lecturap.cerrarArchivo();
                break;
            case 4:
                ArchivoLecturaBarrio lecturab = new ArchivoLecturaBarrio("datos/barrios.dat");
                lecturab.establecerBarrios();
                System.out.printf("%s", lecturab.toString());
                lecturab.cerrarArchivo();
                break;
            case 5:
                ArchivoLecturaCiudad lecturaciu = new ArchivoLecturaCiudad("datos/ciudades.dat");
                lecturaciu.establecerCiudades();
                System.out.printf("%s", lecturaciu.toString());
                lecturaciu.cerrarArchivo();
                break;
            case 6:
                ArchivoLecturaConstructora lecturaco = new ArchivoLecturaConstructora("datos/constructoras.dat");
                lecturaco.establecerConstructoras();
                System.out.printf("%s", lecturaco.toString());
                lecturaco.cerrarArchivo();
                break;
        }
    } 
}

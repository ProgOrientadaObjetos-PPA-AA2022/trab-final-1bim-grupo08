
package paquete06;
import java.io.*;
import java.util.*;

public class ArchivoLecturaCasa {
    private ObjectInputStream entrada;
    private ArrayList<Casa> casas;
    private String nombreArchivo;
    private String identificador;
    
    public ArchivoLecturaCasa(String n) {
        nombreArchivo = n;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(nombreArchivo));
            } catch (IOException ioException) {
                System.out.println("Error al abrir el archivo" + ioException);
            } 
        }
    }
    
    public void establecerCasa() {
        casas = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casas.add(registro);
                } catch (EOFException endOfFileException) {
                    break;
                } catch (IOException ex) {
                    System.out.println("Error al leer el archivo");
                } catch (ClassNotFoundException ex) {
                    System.out.println("No se pudo crear el objeto" + ex);
                }
            }
        }

    }
    
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public void establecerIdentificador(String n) {
        identificador = n;
    }
    
    
    
    public ArrayList<Casa> obtenerCasas() {
        return casas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public String obtenerIdentificador() {
        return identificador;
    }
        
    
    @Override
    public String toString() {
        String cadena = "Casas\n";
        for (int i = 0; i < casas.size(); i++) {
            Casa ca = casas.get(i);
            cadena = String.format(cadena = String.format("%s(%d) Informacion casa:\n"
                    + "PROPIETARIO\n"
                    + "\tNombres: %s Apellidos: %s Identificacion: %s\n"
                    + "DETALLES\n"
                    + "\tPrecio metro cuadrado: %.2f Numero metros Cuadrados: %.2f Numero Cuartos: %d Costo final: %.2f\n"
                    + "BARRIO\n"
                    + "\tNombre barrio: %s Referencia: %s\n"
                    + "CIUDAD\n"
                    + "\tNombre Ciudad: %s Nombre Provincia: %s \n"
                    + "CONSTRUCTORA\n"
                    + "\tNombre Constructora: %s Id Empresa: %s\n", cadena,(i + 1),
                    ca.obtenerPropietario().obtenerNombre(),ca.obtenerPropietario().obtenerApellido(), ca.obtenerPropietario().obtenerIdentificacion(),
                    ca.obtenerPrecioMetroCuadrado(), ca.obtenerNumeroMetrosCuadrados(),ca.obtenerNumeroCuartos(),ca.obtenerCostoFinal(),
                    ca.obtenerBarrio().obtenerNombreBarrio(), ca.obtenerBarrio().obtenerReferencia(),
                    ca.obtenerCiudad().obtenerNombreCiudad(), ca.obtenerCiudad().obtenerNombreProvincia(),
                    ca.obtenerConstructoras().obtenerNombreConstructora(), ca.obtenerConstructora().obtenerId()););
        }

        return cadena;
    }
    
    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.out.println("Error al cerrar el archivo");
        }
    }
}

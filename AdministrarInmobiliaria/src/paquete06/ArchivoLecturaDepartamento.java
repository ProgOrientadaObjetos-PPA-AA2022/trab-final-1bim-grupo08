
package paquete06;
import java.io.*;
import java.util.*;
public class ArchivoLecturaDepartamento {
    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamentos;
    private String nombreArchivo;
    
    
    public ArchivoLecturaDepartamento(String n) {
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
    
    public void establecerDepartamento() {
        departamentos = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    departamentos.add(registro);
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
    
    public ArrayList<Departamento> obtenerDepartamentos() {
        return departamentos;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    @Override
    public String toString() {
        String cadena = "Departamentos:\n";
        for (int i = 0; i < departamentos.size(); i++) {
            cadena = String.format("%s(%d) Informacion del Departamento\n"
                    + "PROPIETARIO\n"
                    + "\tNombres: %s Apellidos: %s Identificacion: %s\n"
                    + "ESPECIFICACIONES\n"
                    + "\tNombre Edificio: %s Ubicación en el Edificio: %s\n"
                    + "\tPrecio por metro cuadrado: %.2f Numero de metros cuadrados: %.2f\n"
                    + "\tValor Alícuota Mensual: %.2f Costo final: %.2f\n"
                    + "BARRIO\n"
                    + "\tNombre Barrio: %s Referencia%s\n"
                    + "CIUDAD\n"
                    + "\tNombre Ciudad: %s Nombre Provincia: %s\n"
                    + "CONSTRUCTORA\n"
                    + "\tNombre Constructora: %s ID Empresa: %s\n", cadena, (i + 1),
                    departamentos.get(i).obtenerPropietario().obtenerNombre(), departamentos.get(i).obtenerPropietario().obtenerApellido(), departamentos.get(i).obtenerPropietario().obtenerIdentificacion(),
                    departamentos.get(i).obtenerNombreEdificio(), departamentos.get(i).obtenerUbicacionEdificio(),
                    departamentos.get(i).obtenerPrecioMetroCuadrado(), departamentos.get(i).obtenerNumeroMetrosCuadrados(),
                    departamentos.get(i).obtenerAlicuotaMensual(), departamentos.get(i).obtenerValorFinal(),
                    departamentos.get(i).obtenerBarrio().obtenerNombreBarrio(), departamentos.get(i).obtenerBarrio().obtenerReferencia(),
                    departamentos.get(i).obtenerCiudad().obtenerNombreCiudad(), departamentos.get(i).obtenerCiudad().obtenerNombreProvincia(),
                    departamentos.get(i).obtenerConstructora().obtenerNombreConstructora(), departamentos.get(i).obtenerConstructora().obtenerId());
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


package paquete06;
import java.io.*;
import java.util.*;
public class ArchivoEscrituraDepartamento {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Departamento registro;
    private ArrayList<Departamento> departamentos;
    public ArchivoEscrituraDepartamento(String n) {
        nombreArchivo = n;
        establecerDepartamentos();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (departamentos.size() > 0) {
                for (int i = 0; i < departamentos.size(); i++) {
                    establecerRegistro(departamentos.get(i));
                    establecerSalida();
                }
            }
            
        } catch (IOException IOexception) {
            System.out.println("Error al abrir el archivo");
        }
    }
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public void establecerSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo");
        }
    }
    
    public void establecerRegistro(Departamento n) {
        registro = n;
    }
    
    public void establecerDepartamentos() {
        ArchivoLecturaDepartamento d = new ArchivoLecturaDepartamento(nombreArchivo);
        d.establecerDepartamento();
        departamentos = d.obtenerDepartamentos();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Departamento> obtenerDepartamentos() {
        return departamentos;
    }
    
    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } 
        catch (IOException ioException) {
            System.out.println("Error al cerrar el archivo");
        } 
    }
}

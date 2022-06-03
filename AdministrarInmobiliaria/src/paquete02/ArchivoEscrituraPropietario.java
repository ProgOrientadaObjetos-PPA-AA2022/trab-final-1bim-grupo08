package paquete02;
import java.io.*;
import java.util.*;
public class ArchivoEscrituraPropietario {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Propietario registro;
    private ArrayList<Propietario> propietarios;
    
    public ArchivoEscrituraPropietario(String n) {
        nombreArchivo = n;
        establecerPropietarios();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (propietarios.size() > 0) {
                for (int i = 0; i < propietarios.size(); i++) {
                    establecerRegistro(propietarios.get(i));
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
    
    public void establecerRegistro(Propietario n) {
        registro = n;
    }
    
    public void establecerPropietarios() {
        ArchivoLecturaPropietario p = new ArchivoLecturaPropietario(nombreArchivo);
        p.establecerPropietarios();
        propietarios = p.obtenerPropietarios();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Propietario> obtenerPropietarios() {
        return propietarios;
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

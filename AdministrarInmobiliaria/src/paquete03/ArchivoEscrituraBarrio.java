package paquete03;
import java.io.*;
import java.util.*;
public class ArchivoEscrituraBarrio {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Barrio registro;
    private ArrayList<Barrio> barrios;
    public ArchivoEscrituraBarrio(String n) {
        nombreArchivo = n;
        establecerBarrios();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (barrios.size() > 0) {
                for (int i = 0; i < barrios.size(); i++) {
                    establecerRegistro(barrios.get(i));
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
    
    public void establecerRegistro(Barrio n) {
        registro = n;
    }
    
    public void establecerBarrios() {
        ArchivoLecturaBarrio b = new ArchivoLecturaBarrio(nombreArchivo);
        b.establecerBarrios();
        barrios = b.obtenerBarrios();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Barrio> obtenerBarrios() {
        return barrios;
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

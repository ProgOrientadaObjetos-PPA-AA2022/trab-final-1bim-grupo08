
package paquete05;
import java.io.*;
import java.util.*;
public class ArchivoLecturaConstructora {
    private ObjectInputStream entrada;
    private ArrayList<Constructora> constructoras;
    private String nombreArchivo;
    private String identificador;
    private Constructora constructoraBuscada;
    public ArchivoLecturaConstructora(String n) {
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
    
    public void establecerConstructoras() {
        constructoras = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    constructoras.add(registro);
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
    
    public void establecerConstructoraBuscada() {
        
        File f = new File(nombreArchivo);

        while (true) {
            
            if (f.exists()) {
                
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    if(registro.obtenerId().equals(identificador)){
                        constructoraBuscada = registro;
                        break;
                    }
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
    
    public ArrayList<Constructora> obtenerConstructoras() {
        return constructoras;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public String obtenerIdentificador() {
        return identificador;
    }
        
    public Constructora obtenerConstructoraBuscada() {
        return constructoraBuscada;
    }
    @Override
    public String toString() {
        String cadena = "Constructoras\n";
        for (int i = 0; i < constructoras.size(); i++) {
            Constructora co = constructoras.get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,
                    i + 1,
                    co.obtenerNombreConstructora(),
                    co.obtenerId());
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

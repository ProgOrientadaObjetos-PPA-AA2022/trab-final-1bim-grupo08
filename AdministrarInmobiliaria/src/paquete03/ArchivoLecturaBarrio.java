package paquete03;
import java.io.*;
import java.util.*;
public class ArchivoLecturaBarrio {
    private ObjectInputStream entrada;
    private ArrayList<Barrio> barrios;
    private String nombreArchivo;
    private String identificador;
    private Barrio barrioBuscado;
    public ArchivoLecturaBarrio(String n) {
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
    
    public void establecerBarrios() {
        barrios = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    barrios.add(registro);
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
    
    public void establecerBarrioBuscado() {
        
        File f = new File(nombreArchivo);

        while (true) {
            
            if (f.exists()) {
                
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    if(registro.obtenerNombreBarrio().equals(identificador)){
                        barrioBuscado = registro;
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
    
    public ArrayList<Barrio> obtenerBarrios() {
        return barrios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public String obtenerIdentificador() {
        return identificador;
    }
        
    public Barrio obtenerBarrioBuscado() {
        return barrioBuscado;
    }
    @Override
    public String toString() {
        String cadena = "Propietarios\n";
        for (int i = 0; i < barrios.size(); i++) {
            Barrio b = barrios.get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,
                    i + 1,
                    b.obtenerNombreBarrio(),
                    b.obtenerReferencia());
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

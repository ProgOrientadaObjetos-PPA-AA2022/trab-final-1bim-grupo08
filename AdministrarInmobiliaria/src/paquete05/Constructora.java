package paquete05;
import java.io.Serializable;
public class Constructora implements Serializable{
    String nombreConstructora;
    String idEmpresa;
    public Constructora(String nc,String ie){
        nombreConstructora = nc;
        idEmpresa = ie;
    }
    public void establecerNombreConstructora(String n){
        nombreConstructora = n;
    }
    public void establecerId(String n){
        idEmpresa = n;
    }
    public String obtenerNombreConstructora(){
        return nombreConstructora;
    }
    public String obtenerId(){
        return idEmpresa;
    }
    @Override
    public String toString(){
        String valor = String.format("%s - %s\n"
                , obtenerNombreConstructora(), 
                 obtenerId());
        return valor;
    }
}

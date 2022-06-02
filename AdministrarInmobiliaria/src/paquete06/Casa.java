package paquete06;
import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;


public class Casa implements Serializable{
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double metrosCuadrados;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private int numeroCuartos;
    private Constructora constructora;
    public Casa(double pmc, double mc,int nc,Propietario p,Barrio b,Ciudad c,Constructora co){
        precioMetroCuadrado = pmc;
        metrosCuadrados = mc;
        numeroCuartos = nc;
        propietario = p;
        barrio = b;
        ciudad = c;
        constructora = co;
    }
    public void establecerPropietario(Propietario n){
        propietario = n;
    }
    
    public Propietario obtenerPropietario(){
        return propietario;
    }
    
    public void establecerPrecioMetroCuadrado(double n){
        precioMetroCuadrado = n;
    }
    public double obtenerPrecioMetroCuadrado(){
        return precioMetroCuadrado;
    }
    
    public void establecerMetrosCuadrados(double n){
        metrosCuadrados = n;
    }
    public double obtenerNumeroMetrosCuadrados(){
        return metrosCuadrados;
    }
    
    public void establecerCostoFinal(){
        costoFinal = precioMetroCuadrado * metrosCuadrados;
    }
    
    public double obtenerCostoFinal(){
        return costoFinal;
    }
    
    public void establecerBarrio(Barrio bar){
        barrio = bar;
    }
    public Barrio obtenerBarrio(){
        return barrio;
    }
    
    public void establecerCiudad(Ciudad n){
        ciudad = n;
    }
    public Ciudad obtenerCiudad(){
        return ciudad;
    }
    
    public void establecerNumeroCuartos(int n){
        numeroCuartos = n;
    }
    public int obtenerNumeroCuartos(){
        return numeroCuartos;
    }
    
    public void establecerConstructora(Constructora n){
        constructora = n;
    }
    public Constructora obtenerConstructoras(){
        return constructora;
    }
    
    @Override
    public String toString() {
        
        String cadena = String.format("Informacion casa:\n"
                + "PROPIETARIO\n"
                + "Nombres: %s Apellidos: %s Identificacion: %s\n"
                + "Precio metro cuadrado: %.2f Numero metros Cuadrados: %.2f Numero Cuartos: %d Costo final: %.2f\n"
                + "BARRIO\n"
                + "Nombre barrio: %s Referencia: %s\n"
                + "CIUDAD\n"
                + "Nombre Ciudad: %s Nombre Provincia: %s \n"
                + "CONSTRUCTORA\n"
                + "Nombre Constructora: %s Id Empresa: %s\n"
                ,propietario.obtenerNombre(),propietario.obtenerApellido(),propietario.obtenerIdentificacion(),
                precioMetroCuadrado,metrosCuadrados,numeroCuartos,costoFinal,
                barrio.obtenerNombreBarrio(),barrio.obtenerReferencia(),
                ciudad.obtenerNombreCiudad(),ciudad.obtenerNombreProvincia(),
                constructora.obtenerNombreConstructora(),constructora.obtenerId());
        return cadena;
    }
}

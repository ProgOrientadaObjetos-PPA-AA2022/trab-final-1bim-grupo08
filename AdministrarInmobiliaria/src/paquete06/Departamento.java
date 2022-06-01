package paquete06;
import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
public class Departamento implements Serializable {
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double metrosCuadrados;
    private double alicuotaMensual;
    private double valorFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private String nombreEdificio;
    private String ubicacionEdificio;
    private Constructora constructora;
    public Departamento(Propietario p, double pmc,double mc,double am, Barrio b,Ciudad c,String ne,String ue,Constructora co){
        propietario = p;
        precioMetroCuadrado = pmc;
        metrosCuadrados = mc;
        alicuotaMensual = am;
        barrio = b;
        ciudad = c;
        nombreEdificio = ne;
        ubicacionEdificio = ue;
        constructora = co;
    }
    public void establecerPropietario(Propietario n){
        propietario = n;
    }
    
    public void establecerPrecioMetroCuadrado(double n){
        precioMetroCuadrado = n;
    }
    
    public void establecerMetrosCuadrados(double n){
        metrosCuadrados = n;
    }
    
    public void establecerAlicuotaMensual(double n){
        alicuotaMensual = n;
    }
    
    public void establecerValorFinal(){
        valorFinal = ((metrosCuadrados * precioMetroCuadrado) 
                + (alicuotaMensual * 12));
    }
    
    public void establecerBarrio(Barrio n){
        barrio = n;
    }
    
    public void establecerCuidad(Ciudad n){
        ciudad = n;
    }
    
    public void establecerNombreEdificios(String n){
        nombreEdificio = n;
    }
    
    public void establecerUbicacionEdificio(String n){
        ubicacionEdificio = n;
    }
    
    public void establecerConstructora(Constructora n){
        constructora = n;
    }
    
    public Propietario obtenerPropietario(){
        return propietario;
    }
    
    public double obtenerPrecioMetroCuadrado(){
        return precioMetroCuadrado;
    }
    
    public double obtenerNumeroMetrosCuadrados(){
        return metrosCuadrados;
    }
    
    public double obtenerAlicuotaMensual(){
        return alicuotaMensual;
    }
    
    public double obtenerValorFinal(){
        return valorFinal;
    }
    
    public Barrio obtenerBarrio(){
        return barrio;
    }
    
    public Ciudad obtenerCiudad(){
        return ciudad;
    }
    
    public String obtenerNombreEdificio(){
        return nombreEdificio;
    }
    
    public String obtenerUbicacionEdificio(){
        return ubicacionEdificio;
    }
    
    public Constructora obtenerConstructora(){
        return constructora;
    }
}

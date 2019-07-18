 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpf.clases;

import distribuciones.Uniforme;
import java.util.Random;

/**
 *
 * @author xtoma
 */
public class VentaAccesorio implements SimuladorServicio{
    
    private double inicioAtencion;
    private double finAtencion;
    
    public VentaAccesorio(double inicio){
        this.inicioAtencion = inicio;
        this.finAtencion = -1;
    }

    public double getInicioAtencion() {
        return inicioAtencion;
    }

    public void setInicioAtencion(double inicioAtencion) {
        this.inicioAtencion = inicioAtencion;
    }

    public double getFinAtencion() {
        return finAtencion;
    }

    public void setFinAtencion(double finAtencion) {
        this.finAtencion = finAtencion;
    }

    @Override
    public void calcularTiempoAtencion(double reloj) {
        String sevicio = "Accesorio";
        
        Random generadorRnd = new Random();
        double rnd = generadorRnd.nextDouble();
        
        Uniforme distUni = new Uniforme(1.0, 5.0);
        double tiempoAtencion = distUni.generarNumero(rnd);
        this.inicioAtencion = reloj;
        this.finAtencion =  reloj + tiempoAtencion;
        
        TiempoAtencion tiempo = TiempoAtencion.getInstance();
        tiempo.setRnd(rnd);
        tiempo.setServicio(sevicio);
        tiempo.setTiempoAtencion(tiempoAtencion);
        tiempo.setFinAtencion(this.finAtencion); 
    }
    
    
    
}

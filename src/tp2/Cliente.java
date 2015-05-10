/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/**
 *
 * @author jhonson
 */
public class Cliente {
    
    private int prioridad;
    private  String Nombre, Correo, tipo, ventanilla, tiquete;
    
    public Cliente(String  Nombre, String Correo, String tipo, String ventanilla, String tiquete, int prioridad){
        this.Nombre=Nombre;
        this.Correo=Correo;
        this.tipo=tipo;
        this.ventanilla=ventanilla;
        this.tiquete=tiquete;
        this.prioridad=prioridad;
    }
    
    public String getNombre(){
        return Nombre;
    }
    public String getcorreo(){
        return Correo;
    }
    public String getTipo(){
        return tipo;
    }
    public String getVentanilla(){
        return ventanilla;
    }
    public String getTiquete(){
        return tiquete;
    }
    public int getPrioridad(){
        return prioridad;
    }
}

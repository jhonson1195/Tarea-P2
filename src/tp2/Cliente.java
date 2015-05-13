/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/** La clase cliente es la principal clase de esta tarea programada
 * Es analoga a la clase Nodo de LinkedList 
 * 
 * 
 */
public class Cliente {
    // Declaración de atributos de la clase Cliente
    private int prioridad; // Atributo principal de la cola de prioridad
    private  String Nombre; // Nombre del Cliente
    private  String Correo; // Correo del Cliente
    private  String tipo; // tipo de cliente, se clasifica de acuerdo a las especificaciones
    private  String ventanilla; // almacena la ventanilla a la que se dirige
    private  String tiquete; // almacena el tiquete que se le asigna al cliente
           
/**
 * A continuacion el constructor de la clase cliente
 * Para poder crear un cliente se deben suminstrar todos los datos
 */
    
    public Cliente(String  Nombre, String Correo, String tipo, String ventanilla, String tiquete, int prioridad){
        this.Nombre=Nombre;
        this.Correo=Correo;
        this.tipo=tipo;
        this.ventanilla=ventanilla;
        this.tiquete=tiquete;
        this.prioridad=prioridad;
    }
    
    // Método para obtener el atributo nombre
    public String getNombre(){
        return Nombre;
    }
    
    // Método para obtener el atributo correo
    public String getcorreo(){
        return Correo;
    }
    
    // Método para obtener el atributo tipo 
    public String getTipo(){
        return tipo;
    }
    
    // Método para obtener el atributo ventanilla
    public String getVentanilla(){
        return ventanilla;
    }
    
    // Método para obtener el atributo tiquete
    public String getTiquete(){
        return tiquete;
    }
    
    // Método para obtener el atributo Prioridad
    public int getPrioridad(){
        return prioridad;
    }
}

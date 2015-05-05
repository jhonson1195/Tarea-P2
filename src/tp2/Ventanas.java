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
public class Ventanas {
    private String nombre, descripcion, codigo, TipoEstruc;
    private DoublyLinkedList<ventanillas> Lista;
    private Estructura almacenamiento;
    
    public Ventanas(String nombre, String descripcion, String codigo, String estructura){
        Lista=new DoublyLinkedList<>();
        if("Heap".equals(estructura)){
            almacenamiento= new HeapTipos();
        }else{
            almacenamiento= new ColaTipos();
        }
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.codigo=codigo;
        this.TipoEstruc=estructura;
        
    }
    
    public void append(ventanillas ventanilla){
        Lista.append(ventanilla);
    }
    public ventanillas getVentanilla(int index){
        return Lista.get(index);
    }
    public int getSize(){
        return Lista.size();
    }
    public void appendCliente(Cliente cliente){
        almacenamiento.Agregar(cliente);
    }
    public String getCodigo(){
        return codigo;
    }
    
    public int PasarClienteVentanilla(){
        if(almacenamiento.Atender()==null){
            return -1;
        }
        Lista.goToStart();
        while(Lista.getElement().getEstado()){
            Lista.next();  
        }
        Lista.getElement().setCliente(almacenamiento.Atender());
        
        return 1;   
    }  
}

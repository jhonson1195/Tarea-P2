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
    private int CantidadCliente;
    
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
        CantidadCliente=0;
        
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
        CantidadCliente++;
    }
    public String getCodigo(){
        return codigo;
    }
    public String getEstructura(){
        return TipoEstruc;
    }
    public int getCantidadCliente(){
        return CantidadCliente;
    }
    public Cliente getSiguienteCliente(){
        return almacenamiento.SiguienteClienteaTeneder();
    }
    public String getTiquetes(){
        return almacenamiento.getTiquetes();
    }
    
    public String PasarClienteVentanilla(){
        String mensaje=null;
        for(int i=0; i<Lista.size();i++){
            if(!Lista.get(i).getEstado()){
                
                Cliente cliente=almacenamiento.Atender();
                mensaje="sin clientes";
                if(cliente!=null){
                Lista.get(i).setCliente(cliente);
                mensaje="Atendiendo cliente "+cliente.getTiquete()+" en "+ Lista.get(i).getNombre();}
                CantidadCliente--;
                break;
            }
        }
        return mensaje;
    }
    
}

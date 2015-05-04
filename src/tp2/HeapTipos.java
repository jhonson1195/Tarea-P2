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
public class HeapTipos {
    
    MinHeap Discacidad;
    MinHeap AdultoMayor;
    MinHeap MujerEmbarazada;
    MinHeap Corporativo;
    MinHeap Regular;
    int contador;
    
    public HeapTipos(){
        Discacidad = new MinHeap();
        AdultoMayor = new MinHeap();
        MujerEmbarazada = new MinHeap();
        Corporativo = new MinHeap();
        Regular = new MinHeap();
        contador=0;
    }
    
    public void Agregar(Cliente info){
        
        if("Persona con discapacidad".equals(info.getTipo())){
            Discacidad.insert(info); 
        }
        else if("Adulto mayor".equals(info.getTipo())){
            AdultoMayor.insert(info); 
        }
        else if("Mujer embarazada".equals(info.getTipo())){
            MujerEmbarazada.insert(info); 
        }
        else if("Cliente corporativo".equals(info.getTipo())){
            Corporativo.insert(info); 
        }
        else if ("Cliente regular".equals(info.getTipo())){
            Regular.insert(info); 
        }
        
        contador++;
    }
    
    public Cliente Atender(){
        
        if(contador==0){
            return null;
        }
        
        contador--;
        if(Discacidad.getContador()!=0){
            return Discacidad.Eliminar();
        }
        else if(AdultoMayor.getContador()!=0){
            return AdultoMayor.Eliminar(); 
        }
        else if(MujerEmbarazada.getContador()!=0){
            return MujerEmbarazada.Eliminar(); 
        }
        else if(Corporativo.getContador()!=0){
            return Corporativo.Eliminar(); 
        }
        else if(Regular.getContador()!=0){
            return Regular.Eliminar(); 
        }
        
        return null;
        
    }
}

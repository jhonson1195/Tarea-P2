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
public class HeapTipos implements Estructura{
    
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
    
    @Override
    public void Agregar(Cliente info){
        contador++;
        if(null != info.getTipo())switch (info.getTipo()) {
            case "Persona con discapacidad":
                Discacidad.insert(info);
                break;
            case "Adulto mayor":
                AdultoMayor.insert(info);
                break;
            case "Mujer embarazada":
                MujerEmbarazada.insert(info);
                break;
            case "Cliente corporativo":
                Corporativo.insert(info);
                break;
            case "Cliente regular": 
                Regular.insert(info);
                break;
        }
        
        
    }
    
    @Override
    public Cliente Atender(){
        
        if(contador==0){
            return null;
        }
        contador--;
        if(Discacidad.getContador()!=0){
            return Discacidad.Eliminar();
        }
        if(AdultoMayor.getContador()!=0){
            return AdultoMayor.Eliminar(); 
        }
        if(MujerEmbarazada.getContador()!=0){
            return MujerEmbarazada.Eliminar(); 
        }
        if(Corporativo.getContador()!=0){
            return Corporativo.Eliminar(); 
        }
        if(Regular.getContador()!=0){
            return Regular.Eliminar(); 
        }
        
        return null;
        
    }

    @Override
    public Cliente SiguienteClienteaTeneder() {
        
        if(contador==0){
            return null;
        }
        contador--;
        if(Discacidad.getContador()!=0){
            return Discacidad.getPrimero();
        }
        if(AdultoMayor.getContador()!=0){
            return AdultoMayor.getPrimero(); 
        }
        if(MujerEmbarazada.getContador()!=0){
            return MujerEmbarazada.getPrimero(); 
        }
        if(Corporativo.getContador()!=0){
            return Corporativo.getPrimero(); 
        }
        if(Regular.getContador()!=0){
            return Regular.getPrimero(); 
        }
        
        return null;
        
    }

    @Override
    public String getTiquetes() {
        if(contador==0){
            return "";
        }
        contador--;
        if(Discacidad.getContador()!=0){
            return Discacidad.imp();
        }
        if(AdultoMayor.getContador()!=0){
            return AdultoMayor.imp(); 
        }
        if(MujerEmbarazada.getContador()!=0){
            return MujerEmbarazada.imp(); 
        }
        if(Corporativo.getContador()!=0){
            return Corporativo.imp(); 
        }
        if(Regular.getContador()!=0){
            return Regular.imp(); 
        }
        
        return "";
        
        
    }
    
    
}

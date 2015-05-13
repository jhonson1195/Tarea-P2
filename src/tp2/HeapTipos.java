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
    int [] CantidadClientePortipos;
    
    public HeapTipos(){
        Discacidad = new MinHeap();
        AdultoMayor = new MinHeap();
        MujerEmbarazada = new MinHeap();
        Corporativo = new MinHeap();
        Regular = new MinHeap();
        contador=0;
        CantidadClientePortipos = new int[5];
        for(int i=0;i>CantidadClientePortipos.length;i++){
            CantidadClientePortipos[i]=0;
        }
    }
    
    @Override
    public void Agregar(Cliente info){
        contador++;
        if(null != info.getTipo())switch (info.getTipo()) {
            case "Persona con discapacidad":
                Discacidad.insert(info);
                CantidadClientePortipos[0]++;
                break;
            case "Adulto mayor":
                AdultoMayor.insert(info);
                CantidadClientePortipos[1]++;
                break;
            case "Mujer embarazada":
                MujerEmbarazada.insert(info);
                CantidadClientePortipos[2]++;
                break;
            case "Cliente corporativo":
                Corporativo.insert(info);
                CantidadClientePortipos[3]++;
                break;
            case "Cliente regular": 
                Regular.insert(info);
                CantidadClientePortipos[4]++;
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

    @Override
    public int[] CantidadClientePortipos() {
        return CantidadClientePortipos;
    }
    
}

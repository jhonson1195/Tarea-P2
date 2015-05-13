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
public class ColaTipos implements Estructura{
    
    SimpleQueue Discacidad;
    SimpleQueue AdultoMayor;
    SimpleQueue MujerEmbarazada;
    SimpleQueue Corporativo;
    SimpleQueue Regular;
    int contador;
    int [] CantidadClientePortipos;
    
    public ColaTipos(){
        Discacidad = new SimpleQueue();
        AdultoMayor = new SimpleQueue();
        MujerEmbarazada = new SimpleQueue();
        Corporativo = new SimpleQueue();
        Regular = new SimpleQueue();
        contador=0;
        CantidadClientePortipos = new int[5];
        for(int i=0;i>CantidadClientePortipos.length;i++){
            CantidadClientePortipos[i]=0;
        }
    }

    @Override
    public void Agregar(Cliente info) {
        contador++;
        if(null != info.getTipo())switch (info.getTipo()) {
            case "Persona con discapacidad":
                Discacidad.enQueue(info);
                CantidadClientePortipos[0]++;
                break;
            case "Adulto mayor":
                AdultoMayor.enQueue(info);
                CantidadClientePortipos[1]++;
                break;
            case "Mujer embarazada":
                MujerEmbarazada.enQueue(info);
                CantidadClientePortipos[2]++;
                break;
            case "Cliente corporativo":
                Corporativo.enQueue(info);
                CantidadClientePortipos[3]++;
                break;
            case "Cliente regular": 
                Regular.enQueue(info);
                CantidadClientePortipos[4]++;
                break;
        }
    }

    @Override
    public Cliente Atender() {
            if(contador==0){
            return null;
        }
        contador--;
        if(Discacidad.getSize()!=0){
            return Discacidad.deQueue();
        }
        if(AdultoMayor.getSize()!=0){
            return AdultoMayor.deQueue(); 
        }
        if(MujerEmbarazada.getSize()!=0){
            return MujerEmbarazada.deQueue(); 
        }
        if(Corporativo.getSize()!=0){
            return Corporativo.deQueue(); 
        }
        if(Regular.getSize()!=0){
            return Regular.deQueue(); 
        }
        
        return null;
    }

    @Override
    public Cliente SiguienteClienteaTeneder() {
        if(contador==0){
            return null;
        }
        contador--;
        if(Discacidad.getSize()!=0){
            return Discacidad.first();
        }
        if(AdultoMayor.getSize()!=0){
            return AdultoMayor.first(); 
        }
        if(MujerEmbarazada.getSize()!=0){
            return MujerEmbarazada.first(); 
        }
        if(Corporativo.getSize()!=0){
            return Corporativo.first(); 
        }
        if(Regular.getSize()!=0){
            return Regular.first(); 
        }
        
        return null;
    }

    @Override
    public String getTiquetes() {
        if(contador==0){
            return "";
        }
        contador--;
        if(Discacidad.getSize()!=0){
            return Discacidad.toString();
        }
        if(AdultoMayor.getSize()!=0){
            return AdultoMayor.toString(); 
        }
        if(MujerEmbarazada.getSize()!=0){
            return MujerEmbarazada.toString(); 
        }
        if(Corporativo.getSize()!=0){
            return Corporativo.toString(); 
        }
        if(Regular.getSize()!=0){
            return Regular.toString(); 
        }
        
        return "";
    }

    @Override
    public int[] CantidadClientePortipos() {
        return CantidadClientePortipos;    
    }
}

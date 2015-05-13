package tp2;

/**
 *
 * Clase que va a crear los min heaps de cada tipo de cliente, 
 * asi como el manejo de dichos min heaps como agregar, atender o obtener el siguiente
 * 
 */
public class HeapTipos implements Estructura{
    MinHeap Discacidad;
    MinHeap AdultoMayor;
    MinHeap MujerEmbarazada;
    MinHeap Corporativo;
    MinHeap Regular;
    int contador;
    int [] CantidadClientePortipos;
    
    //Constructor de los min heaps de cada tipo de cliente
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
    
    //Aqui se van a agregar clientes a los min heaps segun el tipo de cliente
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
    
    //Aqui se van a atender los clientes segun su prioridad
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

    //Retorna cual es el siguiente cliente a atender
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

    //Retorna un string con los min heaps de todos los tiquetes en espera
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

    //Retorna una lista que incluye la cantidad de clientes de cada tipo
    @Override
    public int[] CantidadClientePortipos() {
        return CantidadClientePortipos;
    } 
}

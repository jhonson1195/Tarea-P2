package tp2;
/**
 *
 * Clase que va a crear las colas de cada tipo de cliente, 
 * asi como el manejo de dichas colas como agregar, atender o obtener el siguiente
 * 
 */
public class ColaTipos implements Estructura{
    SimpleQueue Discacidad;
    SimpleQueue AdultoMayor;
    SimpleQueue MujerEmbarazada;
    SimpleQueue Corporativo;
    SimpleQueue Regular;
    int contador;
    int [] CantidadClientePortipos;
    
    //Constructor de las colas de cada tipo de cliente
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

    //Aqui se van a agregar clientes a las colas segun el tipo de cliente
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

    //Aqui se van a atender los clientes segun su prioridad
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

    //Retorna cual es el siguiente cliente a atender
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

    //Retorna la cola de todos los tiquetes en espera
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

    //Retorna una lista que incluye la cantidad de clientes de cada tipo
    @Override
    public int[] CantidadClientePortipos() {
        return CantidadClientePortipos;    
    }
}

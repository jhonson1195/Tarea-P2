package tp2;

/**
 *
 * Clase que va a crear los min heaps
 * Utliza una lista doblemente enlazada para crear la estructura
 * 
 */
public class MinHeap {
    private int contador;
    private DoublyLinkedList <Cliente> lista;

    // Crea el min heap
    public MinHeap(){
        lista = new DoublyLinkedList <>();
        contador=0;
    }
    
    //Aqui se van a insertar elementos(clientes) en el min heap
    public void insert(Cliente cliente){
            lista.append(cliente);
            int padre=((lista.size()-1)-1)/2;
            int hijo=lista.size()-1;
            if(padre<0){
                return;
            }
            else{
                
                while(lista.get(padre).getPrioridad()>cliente.getPrioridad()){
                    Cliente temp= lista.get(padre);
                    lista.setElement(padre, cliente);
                    lista.setElement(hijo, temp);
                    hijo=padre;
                    padre= (padre-1)/2;
                } 
            }
            contador++;
    }
    
    //Aqui se van a eliminar elementos(clientes) en el min heap       
     public Cliente Eliminar(){
         if(lista.isEmpty()){return null;}
         Cliente eliminado=lista.get(0);
         if(lista.size()==1){
             lista.clear();
             contador--;
             return eliminado;
         }
         lista.setElement(0, lista.get(lista.size()-1));
         lista.remove(lista.size()-1);
         int padre=0;
         int izquierdo= (2*padre)+1;
         int derecho= (2*padre)+2;
         
         while(lista.get(padre).getPrioridad()>lista.get(izquierdo).getPrioridad() | lista.get(padre).getPrioridad()>lista.get(derecho).getPrioridad()){
             Cliente temp= lista.get(padre);
             
             if(lista.get(izquierdo).getPrioridad()<lista.get(derecho).getPrioridad()){
                lista.setElement(padre, lista.get(izquierdo));
                lista.setElement(izquierdo, temp);
                padre=izquierdo;
             }else{
                 lista.setElement(padre, lista.get(derecho));
                 lista.setElement(derecho, temp); 
                 padre=derecho;   
             }
            izquierdo= (2*padre)+1;
            derecho= (2*padre)+2;
            
        }
        contador--;
        return eliminado;
         
     }   
     
     // Retorna la cantidad de elementos(Clientes) en un min heap
     public int getContador(){
         return contador;
     }
     
     //Retorna el primer cliente del min heap
    public Cliente getPrimero(){
        return lista.get(0);
        
    }
    
    //Retorna un String de informacion de todos los tiquetes
    public String imp(){
        if(lista.size()==0){
            return "";
        }
        String resultado;
        lista.goToStart();
        resultado=lista.getElement().getTiquete()+", ";
        while(lista.next()){
            resultado+=lista.getElement().getTiquete()+", ";
        }
        
        return resultado;
    }
}
    


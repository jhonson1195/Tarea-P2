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
public class MinHeap {
    private int contador;
    private DoublyLinkedList <Cliente> lista;

    public MinHeap(){
        lista = new DoublyLinkedList <>();
        contador=0;
    }
    
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
           
     public Cliente Eliminar(){
         if(lista.isEmpty()){return null;}
         if(lista.size()==1){
             lista.clear();
             return null;
         }
         Cliente eliminado=lista.get(0);
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
     
     public int getContador(){
         return contador;
     }
    
    public void imp(){
        String resultado;
        lista.goToStart();
        resultado=lista.getElement().getNombre()+", ";
        while(lista.next()){
            resultado+=lista.getElement().getNombre()+", ";
        }
        System.out.println(resultado);
    }
}
    


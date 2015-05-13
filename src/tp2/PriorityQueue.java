import java.util.Scanner;
import tp2.Cliente;

/*
 *
 * Esta clase se creo como prueba de las cola de prioridad,
 * aqui unicamente se hacia el uso de una sola cola que iba a tener
 * todos los tipos de clientes, ordenados segun su prioridad
 *
 */
public class PriorityQueue{
    private Node front;
    private Node rear;
    private int size;
    
    PriorityQueue(){
        this.front = new Node();
        this.rear = this.front;
        this.size = 0;
    }
    
    //Aqui se ingresaban elementos a la cola, y a la vez la ordenaba segun correspondia
    void insert(Cliente element, Integer priority){
        Node nuevo=new Node<>(element, priority);
        if(this.size==0){
            this.front.setNext(nuevo);
            this.rear=rear.getNext();
            size++;
            return;
        }
        if(1==nuevo.priority){
            Node temp=this.front;
            try{
                while((1==temp.getNext().getPriority())){
                    temp=temp.getNext();
                }
                nuevo.setNext(temp.getNext());
                temp.setNext(nuevo);
                size++;
                return;
            }
            catch(Exception e){
                this.rear.setNext(nuevo);
                this.rear=rear.getNext();
                size++;
                return;
            }
        }
        if(2==nuevo.priority){
            Node temp=this.front;
            try{
                while((1==temp.getNext().getPriority())||(2==temp.getNext().getPriority())){
                    temp=temp.getNext();
                }
                nuevo.setNext(temp.getNext());
                temp.setNext(nuevo);
                size++;
                return;
            }
            catch(Exception e){
                this.rear.setNext(nuevo);
                this.rear=rear.getNext();
                size++;
                return;
            }
        }
        if(3==nuevo.priority){
            Node temp=this.front;
            try{
                while((1==temp.getNext().getPriority())||(2==temp.getNext().getPriority())||(3==temp.getNext().getPriority())){
                    temp=temp.getNext();
                }
                nuevo.setNext(temp.getNext());
                temp.setNext(nuevo);
                size++;
                return;
            }
            catch(Exception e){
                this.rear.setNext(nuevo);
                this.rear=rear.getNext();
                size++;
                return;
            }
        }
        if(4==nuevo.priority){
            Node temp=this.front;
            try{
                while((1==temp.getNext().getPriority())||(2==temp.getNext().getPriority())||(3==temp.getNext().getPriority())||(4==temp.getNext().getPriority())){
                    temp=temp.getNext();
                }
                nuevo.setNext(temp.getNext());
                temp.setNext(nuevo);
                size++;
                return;
            }
            catch(Exception e){
                this.rear.setNext(nuevo);
                this.rear=rear.getNext();
                size++;
                return; 
            }
        }
        if(5==nuevo.getPriority()){
            this.rear.setNext(nuevo);
            this.rear=rear.getNext();
            size++;
            return;
        }
    }
    
    //Aqui se liberaba o se sacaba el primer elemento de la cola
    public String liberar(){
        if(this.size == 0){
            System.out.print("Cola esta vacia");
            return null;
        }
        Cliente temp = this.front.getNext().getElement();
        Node newTemp = this.front.getNext();
        this.front.setNext(newTemp.getNext());
        if (this.rear == newTemp){
            this.rear = this.front;
        }
        this.size--;
        return temp.getNombre();
    }
    
    // Retorna el primer elemento de la cola
    public String primero(){
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return null;
        }
        return this.front.getNext().getElement().getNombre();
    }
    
    //Busca un elemento, segun el nombre o algun dato y retorna el indice del elemento
    int buscarElement(String element){
        Node temp=this.front.getNext();
        int count=0;
        do{
            if (count<size){
                count++;
                temp=temp.getNext();
            }
            else{
                return -1;
            }
        }while(temp.getElement().getNombre()!= element);
        return count;
    }
    
    //Busca un elemento segun el indice, retorna el nombre o algun dato
    String buscarEnPos(int pos){
        Node temp=this.front.getNext();
        int count=0;
        do{
            if (count<size){
                count++;
                temp=temp.getNext();
            }
            else{
                return null;
            }
        }while(count!=pos);
        return temp.getElement().getNombre();
    }
    
    //Retorna el tamaño de la cola
    public int getSize(){
        return this.size;
    }
    
    // Retorna si la cola esta vacia
    boolean estaVacia(){
        return this.size==0;
    }
    
    //Limpia la cola
    public void vaciar(){
        this.front = new Node<>();
        this.rear = this.front;
        this.size = 0;
    }
    
    // Retorna un String con informacion de los elementos de la cola
    public String toString(){
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return "";
        }
        String result = "**PriorityQueue**\n";
        Node tempFront = this.front.getNext();
        while (tempFront != null){
            result += tempFront.getElement().getNombre() + " ";
            tempFront = tempFront.getNext();
        }
        return result;
    }
    
    /*
    int priority(){
        int priorit;
        System.out.println("Ingrese el numero correspondiente a la prioridad(1. Discapacitado/2. Adulto Mayor/3. Mujer Embarazada/4. Gerente Corporativo/5.Cliente Normal):");
        Scanner text=new Scanner(System.in);
        String temp = text.nextLine();
        if ((!"1".equals(temp))&&(!"2".equals(temp))&&(!"3".equals(temp)&&(!"4".equals(temp))&&(!"5".equals(temp)))){
            System.out.print("Error!!! De nuevo ");
            priorit = priority();
        }
        priorit = Integer.parseInt(temp);
        return priorit;
    }
    */
    private class Node<E>{
        private Integer priority;
        private Cliente element;
        private Node<E> next;
        
        Node(){
            this.element = null;
            this.next = null;
            this.priority = null;
        }
        
        Node(Cliente element, Integer priority){
            this.element = element;
            this.next = null;
            this.priority = priority;
        }
        
        Node(Cliente element, Node<E> next, Integer priority){
            this.element = element;
            this.next = next;
            this.priority = priority;
        }
        
        void setElement(Cliente element){
            this.element = element;
        }
        
        void setNext(Node next){
            this.next = next;
        }
        
        void setPriority(Integer priority){
            this.priority = priority;
        }
        
        Cliente getElement(){
            return element;
        } 
        
        Node getNext(){
            return next;
        }
        
        Integer getPriority(){
            return priority;
        }
    }
    
    public static void main(String[] args){
        PriorityQueue colaPrioridad=new PriorityQueue();
        colaPrioridad.insert(new Cliente("Esteban1", "", "", "", "", 2),2);
        colaPrioridad.insert(new Cliente("Esteban2", "", "", "", "", 1),1);
        colaPrioridad.insert(new Cliente("Esteban3", "", "", "", "", 4),4);
        colaPrioridad.insert(new Cliente("Esteban4", "", "", "", "", 3),3);
        colaPrioridad.insert(new Cliente("Esteban5", "", "", "", "", 5),5);
        System.out.println(colaPrioridad.toString());
        colaPrioridad.primero();
        colaPrioridad.liberar();
        System.out.println(colaPrioridad.toString());
        System.out.println(colaPrioridad.buscarEnPos(2));
        System.out.println(colaPrioridad.buscarElement("Esteban3"));
        System.out.println(colaPrioridad.estaVacia());
        colaPrioridad.vaciar();
        System.out.println(colaPrioridad.toString());
        System.out.println(colaPrioridad.estaVacia());
    }
}

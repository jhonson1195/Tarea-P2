import java.util.Scanner;

public class PriorityQueue <E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;
    
    PriorityQueue(){
        this.front = new Node<>();
        this.rear = this.front;
        this.size = 0;
    }
    
    void insert(E element){
        Node<E> nuevo=new Node<>(element, priority());
        if(this.size==0){
            this.front.setNext(nuevo);
            this.rear=rear.getNext();
            size++;
            return;
        }
        if("1".equals(nuevo.priority)){
            Node<E> temp=this.front;
            try{
                while(("1".equals(temp.getNext().getPriority()))){
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
        if("2".equals(nuevo.priority)){
            Node<E> temp=this.front;
            try{
                while(("1".equals(temp.getNext().getPriority()))||("2".equals(temp.getNext().getPriority()))){
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
        if("3".equals(nuevo.priority)){
            Node<E> temp=this.front;
            try{
                while(("1".equals(temp.getNext().getPriority()))||("2".equals(temp.getNext().getPriority()))||("3".equals(temp.getNext().getPriority()))){
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
        if("4".equals(nuevo.priority)){
            Node<E> temp=this.front;
            try{
                while(("1".equals(temp.getNext().getPriority()))||("2".equals(temp.getNext().getPriority()))||("3".equals(temp.getNext().getPriority()))||("4".equals(temp.getNext().getPriority()))){
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
        if("5".equals(nuevo.getPriority())){
            this.rear.setNext(nuevo);
            this.rear=rear.getNext();
            size++;
            return;
        }
    }
    
    public E liberar(){
        if(this.size == 0){
            System.out.print("Cola esta vacia");
            return null;
        }
        E temp = this.front.getNext().getElement();
        Node<E> newTemp = this.front.getNext();
        this.front.setNext(newTemp.getNext());
        if (this.rear == newTemp){
            this.rear = this.front;
        }
        this.size--;
        return temp;
    }
    
    public E primero(){
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return null;
        }
        return this.front.getNext().getElement();
    }
    
    int buscarElement(String element){
        Node<E> temp=this.front;
        int count=-1;
        do{
            if (count<size){
                count++;
                temp=temp.getNext();
            }
            else{
                return -1;
            }
        }while(temp.getElement()!= element);
        return count;
    }
    
    E buscarEnPos(int pos){
        Node<E> temp=this.front;
        int count=-1;
        do{
            if (count<size){
                count++;
                temp=temp.getNext();
            }
            else{
                return null;
            }
        }while(count!=pos);
        return temp.getElement();
    }
    
    public int getSize(){
        return this.size;
    }
    
    boolean estaVacia(){
        return this.size==0;
    }
    
    public void vaciar(){
        this.front = new Node<>();
        this.rear = this.front;
        this.size = 0;
    }
    
    public String toString(){
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return "";
        }
        String result = "**PriorityQueue**\n";
        Node<E> tempFront = this.front.getNext();
        while (tempFront != null){
            result += tempFront.getElement() + " ";
            tempFront = tempFront.getNext();
        }
        return result;
    }
    
    String priority(){
        String priorit;
        System.out.println("Ingrese el numero correspondiente a la prioridad(1. Discapacitado/2. Adulto Mayor/3. Mujer Embarazada/4. Gerente Corporativo/5.Cliente Normal):");
        Scanner text=new Scanner(System.in);
        priorit = text.nextLine();
        if ((!"1".equals(priorit))&&(!"2".equals(priorit))&&(!"3".equals(priorit)&&(!"4".equals(priorit))&&(!"5".equals(priorit)))){
            System.out.print("Error!!! De nuevo ");
            priorit = priority();
        }
        return priorit;
    }
    
    private class Node<E>{
        private String priority;
        private E element;
        private Node<E> next;
        
        Node(){
            this.element = null;
            this.next = null;
            this.priority = null;
        }
        
        Node(E element, String priority){
            this.element = element;
            this.next = null;
            this.priority = priority;
        }
        
        Node(E element, Node<E> next, String priority){
            this.element = element;
            this.next = next;
            this.priority = priority;
        }
        
        void setElement(E element){
            this.element = element;
        }
        
        void setNext(Node<E> next){
            this.next = next;
        }
        
        void setPriority(String priority){
            this.priority = priority;
        }
        
        E getElement(){
            return element;
        } 
        
        Node<E> getNext(){
            return next;
        }
        
        String getPriority(){
            return priority;
        }
    }
    
    public static void main(String[] args){
        PriorityQueue<String> colaPrioridad=new PriorityQueue<>();
        colaPrioridad.insert("Esteban");
        colaPrioridad.insert("Carlos");
        colaPrioridad.insert("Johnson");
        colaPrioridad.insert("Isaac");
        colaPrioridad.insert("Andrei");
        System.out.println(colaPrioridad.toString());
        colaPrioridad.primero();
        colaPrioridad.liberar();
        System.out.println(colaPrioridad.toString());
        System.out.println(colaPrioridad.buscarEnPos(2));
        System.out.println(colaPrioridad.buscarElement("Johnson"));
        System.out.println(colaPrioridad.estaVacia());
        colaPrioridad.vaciar();
        System.out.println(colaPrioridad.toString());
        System.out.println(colaPrioridad.estaVacia());
    }
}

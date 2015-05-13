/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/**
 *
 * @author Esteban
 */
public class SimpleQueue {
    private Node front;
    private Node rear;
    private int size;
    
    public SimpleQueue(){
        this.front = new Node();
        this.rear = this.front;
        this.size = 0;
    }
    
    public void enQueue(Cliente element){
        this.rear.setNext(new Node(element, null));
        this.rear = rear.getNext();
        this.size++;
    }
    
    public Cliente deQueue(){
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return null;
        }
        Cliente temp = this.front.getNext().getElement();
        Node newTemp = this.front.getNext();
        this.front.setNext(newTemp.getNext());
        if (this.rear == newTemp){
            this.rear = this.front;
        }
        this.size--;
        return temp;
    }
    
    public Cliente first(){
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return null;
        }
       return this.front .getNext().getElement();
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void clear(){
        this.front = new Node();
        this.rear = this.front;
        this.size = 0;
    }
    

    public String toString(){
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return "";
        }
        String result = "**SimpleQueue**\n";
        Node tempFront = this.front.getNext();
        while (tempFront != null){
            result += tempFront.getElement().getTiquete() + " ";
            tempFront = tempFront.getNext();
        }
        return result;
    }
    
    
    private class Node{
        private Cliente element;
        private Node next;

        // CONSTRUCTORES "Node"
        public Node(){
            this.element = null;
            this.next = null;
        }

        public Node(Cliente element){
            this.element = element;
            this.next = null;
        }

        public Node(Cliente element, Node next){
            this.element = element;
            this.next = next;
        }

        // METODOS "Node"
        public Cliente getElement(){
            return this.element;
        }

        public void setElement(Cliente element){
            this.element = element;
        }

        public Node getNext(){
            return this.next;
        }

        public void setNext(Node next){
            this.next = next;
        }
    }
}

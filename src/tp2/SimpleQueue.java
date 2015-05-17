package tp2;

/**
 *
 * Clase que va a crear las colas
 * 
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
    
    //Aqui se van a insertar elementos(clientes) en la cola
    public void enQueue(Cliente element){
        this.rear.setNext(new Node(element, null));
        this.rear = rear.getNext();
        this.size++;
    }
    
    //Aqui se van a eliminar elementos(clientes) en la cola
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
    
    //Retorna el primer cliente de la cola
    public Cliente first(){
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return null;
        }
       return this.front .getNext().getElement();
    }
    
    // Retorna la cantidad de elementos(Clientes) en la cola
    public int getSize(){
        return this.size;
    }
    
    // Limpia la cola
    public void clear(){
        this.front = new Node();
        this.rear = this.front;
        this.size = 0;
    }
    
    //Retorna un String de informacion de todos los tiquetes
    public String toString(){
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return "";
        }
        String result="";
        Node tempFront = this.front.getNext();
        while (tempFront != null){
            result += tempFront.getElement().getTiquete() + ",";
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

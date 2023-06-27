// Purpose: To create a linked list class from scratch
public class LL_Class_from_scratch{
    Node head;
    private int size;

    LL_Class_from_scratch(){
        this.size = 0;
    }
    
    class Node{
        String data;
        Node next;
        Node(String d){
            data = d;
            next = null;
            size++;
        }
    }
    //add-first method
    public void addFirst(String data){
        Node newNode = new Node(data);
        if( head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    //add-last method
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
        return;
    }
    //print linked-list
    public void printMyList(){
        if(head == null){
            System.out.println("The linked list is empty");
            return;
        }
        Node tempNode = head;
        while(tempNode != null){
            System.out.print(tempNode.data + " => ");
            tempNode = tempNode.next;
        }
        System.out.println("Null");
    }

    // delete first node
    public void deleteFirst(){
        if(head == null ){
            System.out.println("The linked list is empty");
            return;
        }
        size--;
        head = head.next;
        return;
    }

    // delete the last node
    public void deleteLast(){
        if(head == null ){
            System.out.println("The linked list is empty");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node prevNode = head;
        Node currNode = prevNode.next;
        while(currNode.next != null){
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = null;
        return;
    }

    //returns number of node in the list
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        LL_Class_from_scratch list = new LL_Class_from_scratch();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("SmartBoy");
        list.addFirst("Kevin");
        list.printMyList();

        //checking delete methods
        list.deleteFirst();
        list.deleteLast();
        list.printMyList(); 

        //Checking size method
        System.out.println("Size: " + list.getSize());
        list.addLast("SmartBoy");
        list.printMyList();
        System.out.println("Size: " + list.getSize());
    }
}
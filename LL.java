// Create a linked List

public class LL{
    Node head;
    
    class Node{
        String data;
        Node next;
        Node(String d){
            data = d;
            next = null;
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
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("SmartBoy");
        list.addFirst("Jimil");
        list.printMyList();
    }
}
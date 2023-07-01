import java.util.Currency;

import javax.swing.text.html.HTMLDocument.BlockElement;

public class ImportantQuestions {

    Node head;

    public class Node {
        String data;
        Node next;

        Node(String d) {
            this.data = d;
            this.next = null;
        }
    }

    // add-last method
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        return;
    }

    // print linked-list
    public void printMyList() {
        if (head == null) {
            System.out.println("The linked list is empty");
            return;
        }
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " => ");
            tempNode = tempNode.next;
        }
        System.out.println("Null");
    }

    // method to delete nth element from the end of the linked list
    static void deleteNthfromLast(Node head, int n) {
        int size = 0;
        Node currNode = head;
        while (currNode.next != null) {
            size++;
            currNode = currNode.next;
        }
        int pos = size - n;
        currNode = head;
        for (int i = 1; i <= pos; i++) {
            currNode = currNode.next;
        }
        currNode.next = currNode.next.next;
        return;
    }

    public static boolean isPalindrome(Node head) {
        int size = 0;
        Node currNode = head;
        while (currNode != null) {
            size++;
            currNode = currNode.next;
        }
        for (int pos = 1; pos <= size / 2; pos++) {
            String data1;
            String data2;
            currNode = head;
            for (int i = 1; i <= pos; i++) {
                currNode = currNode.next;
            }
            data1 = currNode.data;
            currNode = head;
            for (int j = 1; j <= size - pos + 1; j++) {
                currNode = currNode.next;
            }
            data2 = currNode.data;
            if (!data1.equals(data2)) {
                return false;
            }
        }
        return true;
    }
    

    public static void main(String[] args) {
        ImportantQuestions list = new ImportantQuestions();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("2");
        list.addLast("1");

        // list.deleteNthfromLast(list.head, 4);
        // list.printMyList();

        System.out.println("Result of Pallidrome: "+list.isPalindrome(list.head));


    }
}

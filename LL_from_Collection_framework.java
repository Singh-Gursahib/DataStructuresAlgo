import java.util.LinkedList;

public class LL_from_Collection_framework {
    public static void main(String[] args) {
        // How to make an empty linked list
        LinkedList<String> list = new LinkedList<String>();

        list.addFirst("is");
        list.addLast("a");
       
        //add() method adds the element at the end of the list
        list.add("list");

        list.addFirst("This");

        //print the list
        System.out.println(list);
    }

}
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

        //get size of the list
        System.out.println(list.size());

        //iterating over the list
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println("null");

        //How to remove elements from the list
        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        //remove from specific index
        list.remove(1);
        System.out.println(list);
    }


}
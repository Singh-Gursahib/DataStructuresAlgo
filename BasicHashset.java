import java.util.*;
import java.util.Iterator;

public class BasicHashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();

        //Adding elements
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        //Print all elements
        System.out.println(set);

        //Print size
        System.out.println("The size of the set is: "+ set.size());

        //remove element
        set.remove(1);

        //is it contains
        System.out.println("Does the set have 1: "+(set.contains(1)));

        //Iterator
        Iterator it = set.iterator();

        set.add(1);
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}

import java.util.*;

public class BasicHashmap {
    public static void main(String[] args) {
        HashMap <String, Integer> map = new HashMap<String, Integer>();
        map.put("India", 130);
        map.put("US", 30);
 
        map.put("China", 150);

        //updating china populatiion to 155
        map.put("China", 155);
        System.out.println(map);

        //searching using map.containskey
        System.out.println("Does the map have Bhutan: "+map.containsKey("Bhutan"));

        //Searching by key
        System.out.println("Population of India is: "+map.get("India"));
        System.out.println("Population of Bhutan is: "+map.get("Bhutan"));

        //Iterating over the map
        for(Map.Entry<String, Integer> e : map.entrySet()){ 
            System.out.println(e.getKey()+" -> "+e.getValue());
        }
        

    }
   
}

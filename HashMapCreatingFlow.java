import java.util.*;

public class HashMapCreatingFlow {
    public static String getStart(HashMap<String, String> map) {
        for (String i : map.keySet()) {
            for (String j : map.keySet()) {
                if (i.equals(map.get(j))) {
                    break;
                }
                return i;
            }
        }
        return null;

    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("B", "C");
        map.put("D", "E");
        map.put("A", "B");
        map.put("C", "D");
        map.put("E", "F");

        String start = getStart(map);
        while (map.get(start) != null) {
            System.out.println(start + " -> " + map.get(start));
            start = map.get(start);
        }
    }
}


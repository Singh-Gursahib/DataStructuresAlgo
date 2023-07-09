import java.util.*;

public class BasicHashmapImplementation {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;
            Node next;

            Node(K key, V value){
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

        private int n=0; // number of key-value pairs
        private int N; // number of buckets
        private double lambda = 2;

        private LinkedList<Node> buckets[]; // array of linked-list (N = buckets.length)

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[N];
            for(int i = 0; i < N; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }   

        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }
        private int findInBucket(int bi, K key){
            int di = 0;
            for(Node node : buckets[bi]){
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;
        }
        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i=0;i< buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i = 0; i< oldBucket.length;i++){
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j< ll.size(); j++ ){
                    put(ll.get(j).key,ll.get(j).value);
                }
            }
        }
        

        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = findInBucket(bi, key); 


            if(di == -1){
                // key is not present
                Node nn = new Node(key, value);
                buckets[bi].addLast(nn);
                this.n++;
            }else{
                // key is present
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double newLambda = (double)n/N;
            if(newLambda > lambda){
                rehash();
            }
        }

        public V get(K key){
        int bi = hashFunction(key);
            int di = findInBucket(bi, key); 


            if(di == -1){
                // key is not present
                return null;
            }else{
                // key is present
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = findInBucket(bi, key); 


            return (di == -1)? false: true;
        }
        public V remove(K key){
            int bi = hashFunction(key);
            int di = findInBucket(bi, key); 


            if(di == -1){
                // key is not present
                return null;
            }else{
                // key is present
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }

        }
        public boolean isEmpty(){
            return (n == 0);
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        
    }
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India",190);
        map.put("China",200);
        map.put("US",50);

        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i)+ " "+ map.get(keys.get(i)));
        }

    }
}

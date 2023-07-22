public class TrieFromScratch {
    static class Node {
        Node[] children;
        boolean eow;

        public Node(){
           this.children = new Node[26];
           for(int i = 0; i<26; i++){
                this.children[i] = null;
           }
           eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node currentNode = root; 
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (currentNode.children[idx] == null) {
                currentNode.children[idx] = new Node();
            }
            if (i == word.length() - 1) {
                currentNode.children[idx].eow = true;
            }
            currentNode = currentNode.children[idx];
        }
    }
    
    
    public static boolean search(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (currentNode.children[idx] == null) {
                return false;
            }
            currentNode = currentNode.children[idx];
        }
        return currentNode.eow;
    }
    

    public static Boolean checkPrefix(String prefix){
        Node currNode = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if (currNode.children[idx] == null){
                return false;
            }
            currNode = currNode.children[idx];
        }
        return true;
    }
    public static void main(String args[]){
        String words[] = {"the","a", "there","any"};
        for (String word : words) {
            insert(word);
        }
        System.out.println(search("app"));
        System.out.println(checkPrefix("ther"));

    }
}

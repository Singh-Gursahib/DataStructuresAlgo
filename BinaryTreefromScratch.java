import java.util.*;

public class BinaryTreefromScratch {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int node[]) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }

            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);

            return newNode;
        }
    }

    public static void preorderTraverse(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    public static void inorderTraverse(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.data + " ");
        inorderTraverse(root.right);

    }

    public static void postorderTraverse(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelorderTraverse(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> myQueue = new LinkedList<>();
        myQueue.add(root);
        myQueue.add(null);

        while (!myQueue.isEmpty()) {
            Node currNode = myQueue.remove();
            if (currNode == null) {
                System.out.println();
                if (myQueue.isEmpty()) {
                    break;
                } else {
                    myQueue.add(null);
                }
            } else {
                System.out.print(currNode.data);
                if (currNode.left != null) {
                    myQueue.add(currNode.left);
                }
                if (currNode.right != null) {
                    myQueue.add(currNode.right);
                }
            }
        }
    }

    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = sumOfNodes(root.left);
        int sumRight = sumOfNodes(root.right);
        return sumLeft + sumRight + root.data;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return ((leftHeight > rightHeight) ? leftHeight : rightHeight) + 1;
    }

    //Time complexity is bigO(n2)
    public static int diamApproachOne(Node root) {
        if (root == null){
            return 0;           
        }
        int diaLeft = diamApproachOne(root.left);
        int diaRight = diamApproachOne(root.right);
        int diaNode = height(root.left) + height(root.right) + 1;

        return Math.max(Math.max(diaRight, diaLeft), diaNode);
    }

    
    public static class TreeInfo {
        int dia;
        int ht;

        TreeInfo(int d, int h){
            this.dia = d;
            this.ht = h;
        }
    }

    public static TreeInfo diamApproachTwo(Node root){
        if(root == null){
            return new TreeInfo(0,0);
        }

        TreeInfo leftTree = diamApproachTwo(root.left);
        TreeInfo rightTree = diamApproachTwo(root.right);

        int myHeight = Math.max(leftTree.ht, rightTree.ht) + 1;

        int myDia = Math.max(leftTree.ht + rightTree.ht + 1, Math.max(leftTree.dia, rightTree.dia));

        TreeInfo myInfo = new TreeInfo(myDia, myHeight);
        return myInfo;
        
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node node = tree.buildTree(nodes);

        // checking
        System.out.println(node.data);

        System.out.println("Preorder Treverse:");
        preorderTraverse(node);

        System.out.println("\n");
        System.out.println("Inorder Treverse:");
        inorderTraverse(node);

        System.out.println("\n");
        System.out.println("Postorder Treverse:");
        postorderTraverse(node);

        System.out.println("\n");
        System.out.println("Level Order Treverse:");
        levelorderTraverse(node);

        System.out.println("The total number of Nodes are: " + countOfNodes(node));

        System.out.println("The Sum of Nodes under the root node is: " + sumOfNodes(node));

        System.out.println("The height of this root node is: " + height(node));

        System.out.println("The Diametr of this root node is: " + diamApproachOne(node));
        
    
        System.out.println("The Diametr of this root node via second approach is: " + diamApproachTwo(node).dia);

    }
}

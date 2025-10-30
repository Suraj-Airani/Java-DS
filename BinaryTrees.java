import java.util.*;

public class BinaryTrees {
    public static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int idx=-1;
        public static Node buildTree(int[] nodes) {
            idx++;
            if(nodes[idx] == -1){
                return null; 
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    public static void preorder(Node root){ // TC: O(N) DFS
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){ // TC: O(N) DFS
        if(root == null){ return; }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void postorder(Node root){  // TC: O(N) DFS
        if(root == null){ return; }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrder(Node root){ // TC: O(N) BFS
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()) break; 
                else  q.add(null); 
            }
            else{
                System.out.print(curr.data+" ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
    }
    public static int countNodes(Node root){ // TC:O(N)
        if(root == null) return 0;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return leftNodes + rightNodes + 1;
    }
    public static int sumNodes(Node root){ // TC: O(N)
        if(root == null) return 0;
        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);

        return leftSum + rightSum + root.data;
    }
    public static int heightOfTree(Node root){ // TC: O(N)
        if(root == null) return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight,rightHeight) + 1;
    }
    public static int diameterOfTree(Node root){  // approach 1 TC: O(N^2)
        if(root == null) return 0;
        int d1 = diameterOfTree(root.left);
        int d2 = diameterOfTree(root.right);
        int d3 = heightOfTree(root.left)+heightOfTree(root.right)+1;
        System.out.println(d3);

        return Math.max(Math.max(d1, d2), d3);
    }
    static class TreeInfo{  // for approach 2 calculating diameter of 
        int ht,diam;
        
        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    public static TreeInfo diam2(Node root){
        if(root == null) return new TreeInfo(0, 0);

        TreeInfo left = diam2(root.left);
        TreeInfo right = diam2(root.right);

        int myHeight = Math.max(left.ht, right.ht)+1;
        
        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;
        
        int myDiameter = Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myInfo = new TreeInfo(myHeight, myDiameter);

        return myInfo;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // preorder(root);
        // System.out.println();
        // inorder(root);
        // System.out.println();
        // postorder(root);
        // System.out.println();
        // levelOrder(root);
        // System.out.println();
        // System.out.println(countNodes(root));
        // System.out.println();
        // System.out.println(sumNodes(root));
        // System.out.println();
        // System.out.println(heightOfTree(root));
        // System.out.println();
        // System.out.println(diameterOfTree(root));
        System.out.println(diam2(root).diam);
        System.out.println();
    }
}

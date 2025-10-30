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

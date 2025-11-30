class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}


public class BST { 
    Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;

        return value < root.value
                ? searchRec(root.left, value)
                : searchRec(root.right, value);
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        
        BST tree = new BST(); 

        int[] values = {8, 3, 10, 1, 6, 14};
        for (int v : values) tree.insert(v);

        System.out.print("In-order: ");
        tree.inorder();

        System.out.println("Buscar 6: " + tree.search(6));
        System.out.println("Buscar 99: " + tree.search(99));
    }
}
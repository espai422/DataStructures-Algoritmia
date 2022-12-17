package NonLinear.BinaryTree;

public class BinaryTree<T extends Comparable<T>> {
    private class Node implements Comparable<Node>{
        private T value;
        private Node left;
        private Node rigth;

        public Node (T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }

        @Override
        public int compareTo(BinaryTree<T>.Node other) {
            return this.value.compareTo(other.value);
        }
    }
    private Node root;

    public void add(T value) {
        if (root == null)
            root = new Node(value);
        else
            addNode(root, new Node(value));
    }

    private void addNode(Node current, Node newNode) {
        int comparation = current.compareTo(newNode); 

        if (comparation == -1) { // biger -> right
            if (current.rigth == null)
                current.rigth = newNode; // base Case
            else
                addNode(current.rigth, newNode);
        } 
        else if (comparation == 1 ) { // smaller -> left 
            if (current.left == null)
                current.left = newNode; // base Case
            else
                addNode(current.left, newNode);
        }
        else throw new IllegalArgumentException("Value is equal");
    }

    public boolean find(T value) {
        return find(value, root);
    }

    private boolean find(T value, Node current) {
        // base cases
        if (current == null) return false;

        if (value.equals(current.value))
            return true;
        
        // recursive cases
        int valueComp = current.value.compareTo(value);
        if ( valueComp == -1) // right
            return find(value, current.rigth);
        return find(value, current.left);
    }

    public void TraversePreOrder() {
        preOrder(root);
    }

    public void TraverseInOrder() {
        inOrder(root);
    }

    public void TraverseInOrderReverse() {
        inOrderReverse(root);
    }

    public void TraversePostOrder() {
        postOrder(root);
    }

    private void preOrder(Node root) {
        // Base Case
        if (root == null) return;

        System.out.print(root.value + ", ");
        preOrder(root.left);
        preOrder(root.rigth);
    }

    private void inOrder(Node root) {
        // Base case
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.value + ", ");
        inOrder(root.rigth);
    }

    private void inOrderReverse(Node root) {
        // Base case
        if (root == null) return;

        inOrderReverse(root.rigth);
        System.out.print(root.value + ", ");
        inOrderReverse(root.left);
    }

    private void postOrder(Node root) {
        // Base case
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.rigth);
        System.out.print(root.value + ", ");
    }


    @Override
    public String toString() {
        return "";
    }

    
}

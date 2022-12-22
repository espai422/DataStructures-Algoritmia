package NonLinear.BinaryTree;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

public class BinaryTree<T extends Comparable<T>> {
    private class Node implements Comparable<Node>{
        private T value;
        private Node left;
        private Node rigth;

        public Node (T value) {
            this.value = value;
        }

        public boolean equals(Node other) {
            if (this.value.equals(other.value))
                return true;
            return false;
        }

        @Override
        public String toString() {
            return value.toString();
        }

        @Override
        public int compareTo(BinaryTree<T>.Node other) {
            if (other == null) return 1;
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
    
    public void reverse() {
        reverse(root);
    }

    // REVERSE TREE
    private void reverse(Node root) {
        // Base case
        if (root == null) return;

        reverse(root.left);
        reverse(root.rigth);
        swapChilds(root);
    }

    private void reverseEfficient(Node root) {
        if (root.left != null)
            reverse(root.left);

        if (root.rigth != null)
            reverse(root.rigth);

        swapChilds(root);
    }

    private void swapChilds(Node node) {
        Node temp = node.left;
        node.left = node.rigth;
        node.rigth = temp;
    }


    // Height of tree
    public int height() {
        return height(root);
    }

    // Post-order traversal
    private int height(Node root) {
        if (root == null) return -1;
        return Math.max(height(root.left), height(root.rigth)) +1;
    }

    // Minimum Value of a binary tree
    public T minimum() {
        return minimum(root);
    }

    // O(n)
    private T minimum(Node root) {
        // base cases
        if (root.left == null && root.rigth == null)
            return root.value;

        if (root.left == null){
            T minRight = minimum(root.rigth);
            if (root.value.compareTo(minRight) == -1)
                return root.value;
            return minRight;
        }

        if (root.rigth == null) {
            T minLeft = minimum(root.left);
            if (root.value.compareTo(minLeft) == -1)
                return root.value;
            return minLeft;
        }

        T minLeft = minimum(root.left);
        T minRight = minimum(root.rigth);

        if (root.value.compareTo(minRight) == -1) {
            if (root.value.compareTo(minLeft) == -1)
                return root.value;
            else
                return minLeft;
        }
        if (minRight.compareTo(minLeft) == -1)
            return minRight;

        return minLeft;
    }

    // O(Log(n)) 
    public T minBinaryTreeSearch() {
        if (root == null)
            throw new IllegalStateException("Tree is empty");
        var current = root;

        while (current.left != null)
            current = current.left;

        return current.value;
    }

    public boolean equals(BinaryTree<T> otherTree) {
        if (otherTree == null) 
            return false;
        return equals(root, otherTree.root);
    }

    private boolean equals(Node thisRoot, Node otherRoot) {

        if (thisRoot != null && otherRoot != null) {
            return  thisRoot.equals(otherRoot) &&
                    equals(thisRoot.left, otherRoot.left) &&
                    equals(thisRoot.rigth, otherRoot.rigth);
        }
        // base case 1 both are null
        if (thisRoot == null && otherRoot == null)
            return true;

        // base case 2 One node is null but the other is not null
        return false;
    }

    // public boolean isBinarySearchTree() {
    //     return isBinarySearchTree(root);
    // }

    // private boolean isBinarySearchTree(Node root) {
    //     if (root.rigth == null)
        
    //     return root.left.compareTo(root.rigth) == -1 &&
    //             isBinarySearchTree(root.left) &&
    //             isBinarySearchTree(root.rigth);
    // }

    // public boolean isBinarySearchTree() {
    //    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    // }

    // private boolean isBinarySearchTree(Node root, int min, int max) {
    //     if (root == null)
    //         return true;
    //     return root.value < max && root.value > min && 
    //     isBinarySearchTree(root.left, min, root.value) &&
    //     isBinarySearchTree(root.rigth, root.value, max);
    // }

    
    /**
     * @param distance
     * Prints the nodes at specified disctance from the root
     */
    public ArrayList<T> nodesAtKDistance(int distance) {
        var list = new ArrayList<T>();
        nodesAtKDistance(distance, root, list);
        return list;
    }

    private void nodesAtKDistance(int distance, Node root, ArrayList<T> list) {
        // Base case
        if (root == null)
            return;

        if (distance-- == 0) {
            list.add(root.value);
            return;
        }

        nodesAtKDistance(distance, root.left, list);
        nodesAtKDistance(distance, root.rigth, list);
    }

    public void levelOrderTraversal() {
        for (int i = 0; i <= height(); i++)
            System.out.println(nodesAtKDistance(i));
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;
        return size(root.left) + size(root.rigth) + 1;
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (isChild(root))
            return 1;
        return countLeaves(root.left) + countLeaves(root.rigth);
    }

    private boolean isChild(Node root) {
        return root.left == null && root.rigth == null;
    }

    // Maximum value of a binary tree
    public T max() {
        return max(root);
    }


    private T max(Node root) {
        // base cases
        if (root.left == null && root.rigth == null)
            return root.value;

        if (root.left == null){
            T maxRight = max(root.rigth);
            if (root.value.compareTo(maxRight) == 1)
                return root.value;
            return maxRight;
        }

        if (root.rigth == null) {
            T maxLeft = max(root.left);
            if (root.value.compareTo(maxLeft) == 1)
                return root.value;
            return maxLeft;
        }

        T maxLeft = max(root.left);
        T maxRight = max(root.rigth);

        if (root.value.compareTo(maxRight) == 1) {
            if (root.value.compareTo(maxLeft) == 1)
                return root.value;
            else
                return maxLeft;
        }
        if (maxRight.compareTo(maxLeft) == 1)
            return maxRight;

        return maxLeft;
    }

    public boolean areSibling(T value1, T value2) {
        return areSibling(root, value1, value2);
    }

    private boolean areSibling(Node root, T value1, T value2) {
        if (root == null) {
            return false;
        }

        if (root.left != null && root.rigth != null && isSiblingNode(root, value1, value2))
            return true;

        return areSibling(root.left, value1, value2) || areSibling(root.rigth, value1, value2);
    }

    private boolean isSiblingNode(Node root, T value1, T value2) {
        return value1.equals(root.left.value) && value2.equals(root.rigth.value) ||
        value1.equals(root.rigth.value) && value2.equals(root.left.value);
    }

    public List<T> getAncestors(T value) {
        List<T> ancestors = new ArrayList<>();
        getAncestors(root, value, ancestors);
        return ancestors;
    }

    private boolean getAncestors(Node root, T value, List<T> ancestors) {
        // base case 1
        if (root == null)
            return false;

        // base case 2
        if (root.value == value)
            return true;

        boolean isParent = getAncestors(root.left, value, ancestors) || getAncestors(root.rigth, value, ancestors);
        if (isParent)
            ancestors.add(root.value);

        return isParent;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i <= height(); i++)
            str += nodesAtKDistance(i) + "\n";
        
        return str;
    }

}


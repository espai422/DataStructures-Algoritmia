package NonLinear.BinaryTree;

public class Main {
    private static BinaryTree<Integer> tree = new BinaryTree<>();        
    public static void main(String[] args) {
        populateTree();
        reverseTreeTest();
    }

    private static void populateTree() {
        tree.add(20);
        tree.add(10);
        tree.add(30);
        tree.add(6);
        tree.add(14);
        tree.add(3);
        tree.add(8);
        tree.add(24);
        tree.add(26);
    }

    private static void reverseTreeTest() {
        tree.TraverseInOrder();
        tree.reverse();
        System.out.println();
        tree.TraverseInOrderReverse();
    }

    private static void traverseTree() {
        tree.TraversePreOrder();
        tree.TraverseInOrder();
        tree.TraverseInOrderReverse();
        tree.TraversePostOrder();
    }

}

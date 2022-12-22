package NonLinear.BinaryTree;

public class Main {
    private static BinaryTree<Integer> tree = new BinaryTree<>();        
    private static BinaryTree<Integer> tree2 = new BinaryTree<>();        
    public static void main(String[] args) {
        populateTree1();
        System.out.println(tree.getAncestors(8));
    }

    private static void populateTree1() {
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

    private static void populateTree2() {
        tree2.add(20);
        tree2.add(10);
        tree2.add(30);
        tree2.add(6);
        tree2.add(14);
        tree2.add(3);
        tree2.add(8);
        tree2.add(24);
        tree2.add(26);
    }

    private static void reverseTreeTest() {
        populateTree1();
        tree.TraverseInOrder();
        tree.reverse();
        System.out.println();
        tree.TraverseInOrderReverse();
    }

    private static void traverseTree() {
        populateTree1();
        tree.TraversePreOrder();
        tree.TraverseInOrder();
        tree.TraverseInOrderReverse();
        tree.TraversePostOrder();
    }

    private static void heightOfTree() {
        populateTree1();
        System.out.println(tree.height());
    }

    private static void minValue() {
        populateTree1();
        System.out.println(tree.minimum());
    }

    private static void minValueBinaryTreeSearch() {
        populateTree1();
        System.out.println(tree.minBinaryTreeSearch());
    }

    private static void checkEquality() {
        populateTree1();
        populateTree2();
        System.out.println(tree.equals(tree2));
    }

    private static void validateBinarySearch() {
        populateTree1();
    }

    private static void nodesAtKdistance() {
        populateTree1();
        tree.nodesAtKDistance(1);
    }

    private static void testLevelOrderTraversal() {
        populateTree1();
        tree.levelOrderTraversal();
    }

    private static void testIsSibling() {
        populateTree1();
        System.out.println(tree.areSibling(3,8));
        System.out.println(tree.areSibling(8,3));
        System.out.println(tree.areSibling(3,80));
        System.out.println(tree.areSibling(1,1));
    }

    private static void ancestors() {
        populateTree1();
        System.out.println(tree.getAncestors(8));
    }

    
}

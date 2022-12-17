package NonLinear.BinaryTree;

public class Main {
    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();        
        tree.add(5);
        tree.add(2);
        tree.add(7);
        System.out.println(tree.find(5));
        System.out.println(tree.find(3));
        System.out.println(tree.find(2));
        System.out.println(tree.find(7));
        System.out.println(tree.find(-2));
        System.out.println(tree.find(0));
    }

}


public class BSTTester {
	public static void main(String[] args) {
		BST tree = new BST(9);
		System.out.println(tree.remove(9));
		tree.add(12);
		tree.add(3);
		tree.add(7);
		tree.add(15);
		tree.add(10);
		tree.add(11);
		tree.add(1);
		tree.add(14);
		tree.inOrder();
		System.out.println();
		tree.preOrder();
		System.out.println();
		tree.breadthFirst();
		
		
	}
}

// DSA 
// BST class
// 2021-2022

public class BST { // A node is a BST
	private int element;
	private BST left;
	private BST right;
	
	// constructors
	BST(int element){
		this.element=element;
		left=null;
		right=null;
	}
	BST(int element, BST left, BST right){
		this.element=element;
		this.left=left;
		this.right=right;
	}
	// setters & getters
	
	public int getElement() {
		return element;
	}
	public BST getLeft() {
		return left;
	}
	public BST getRight() {
		return right;
	}
	
	public void setElement(int elt) { element = elt; }
	
	public void setLeft(BST newLeft) {
		left=newLeft;
	} 
	public void setRight(BST newRight) {
		right=newRight;
	} 
	
	// methods
	public boolean contains(int item) {
		if (element==item) {
			return true;
		}
		if (item < element && left != null) {
			return left.contains(item);
		}
		if (item > element && right != null) {
			return right.contains(item);
		}
		return false;
	} //search
	
	public BST findMin() {
		if (left != null) {
			return left.findMin();
		}
		return this;
	}
	private BST findMinParent() {
		if (left != null && left.getLeft() == null) { return this;}
		else if (left != null) { return left.findMinParent(); }
		return this;
		
	}
	
	public BST findMax() {
		if (right != null) {
			return right.findMax();
		}
		return this;
		
	}
	private BST findMaxParent() {
		if (right != null && right.getRight() == null) { return this;}
		else if (right != null) { return right.findMaxParent(); }
		return this;
		
	}
	
	public boolean add(int item){//no duplicates allowed
		if (contains(item)) { return false; }
		if (item < element && left == null) { left = new BST(item); }
		else if (item < element && left != null) { return left.add(item); }
		else if (item > element && right == null) { right = new BST(item); }
		else { return right.add(item); }
		return true;
	} 
	
	
	
	public boolean remove(int item) {
		return remove(item, null);
	}
	
	private boolean remove(int item, BST parent) { // parent starts null
		
		// deal with removing root
		if (!contains(item)) { return false;	}
		if (element == item) {
			if (left == null && right == null) {
				if (item < parent.getElement()) {parent.setLeft(null);}
				else { parent.setRight(null); }
			} 
			else if (right != null){ // choosing to swap with smallest on right
				BST toSwap = right.findMin();
				BST nextParent = right.findMinParent();
				this.setElement(toSwap.getElement());
				toSwap.setElement(item);
				return toSwap.remove(item, nextParent);
			}
			else {
				BST toSwap = left.findMax();
				BST nextParent = left.findMaxParent();
				this.setElement(toSwap.getElement());
				toSwap.setElement(item);
				return toSwap.remove(item, nextParent);
			}
		}
		else if (item < element) { return left.remove(item, this); }
		else { return right.remove(item, this); }
	}
	
	public int removeMin() {}
	
	public int removeMax() {}
	
	// traversals
	private void visit() { System.out.print(element + " "); }
	public void inOrder() {
		if(left != null) { left.inOrder(); }
		visit();
		if(right != null) { right.inOrder(); }
	}
	public void preOrder() {
		visit();
		if(left != null) { left.preOrder(); }
		if(right != null) { right.preOrder(); }
	}
	public void postOrder() {
		if(left != null) { left.postOrder(); }
		if(right != null) { right.postOrder(); }
		visit();
	}
	public void breadthFirst() {}
	
	
}

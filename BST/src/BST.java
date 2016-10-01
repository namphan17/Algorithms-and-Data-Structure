
public class BST {
	
	private Node root;
	
	private class Node {
		int value;
		Node leftChild;
		Node rightChild;
		
		private Node(int value, Node leftChild, Node rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}
	public BST() {
		this.root = null;
	}
		
	public void add( int value ) {
		if( this.root == null ) {
			this.root = new Node( value, null, null );
		}
		else {
			this.add( this.root, value );
		}
	}
	
	public void add(Node node, int value) {
		if ( value == node.value){
			// Do nothing.
		}
		else if ( value < node.value ) {
			if ( node.leftChild == null ) {
				node.leftChild = new Node( value, null, null );
			}
		}
	}
		
	public void add () {
			
	}
	
	public int depth() {
		int size = 0;
		return depth(this.root, size);
	}
	
	public int depth(Node node, int size) {
		if (node != null) {
			depth(node.leftChild, size);
		}
			return size;
	}
	
}

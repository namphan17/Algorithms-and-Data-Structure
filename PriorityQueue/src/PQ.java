
/**
 * Priority Queue with explicit link
 * 
 * <p>
 * This class is an implementation of the Priority Queue.
 * It uses Node data type to build up a binary heap. Each 
 * Node is linked to its children and its parent. For every 
 * element we want to insert to our PQ, we will 
 * stored those elements the data into the Node.
 * </p>
 * 
 *  <img src="../../../build/classes/resources/fis.png" alt="UML class diagram">
 * 
 * @author Nam Phan
 * @version 31 March 2013
 */
public class PQ<Item extends Comparable<Item>> {
	/**
	 * This is the root of our binary heap.
	 */
	private Node root;
	/**
	 * Store the number of elements in this PQ.
	 */
	private int size;

	private class Node {
		Item item;
		Node parent;
		Node leftChild;
		Node rightChild;

		private boolean less(Node node) {
			return (this.item.compareTo(node.item) < 0);
		}
	}
	
	/**
	 * Create a Priority Queue
	 */
	public PQ() {
		this.root = null;
		size = 0;
	}
	
	/**
	 * Check to see if there is any elements in the PQ.
	 * 
	 * @return true if there are no elements stored in the PQ and false
     * otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Check if a Priority Queue is a binary heap.
	 * 
	 * @return true if the PQ represents a binary heap structure and 
	 * false otherwise 
	 */
	public boolean invariant() {
		return invariant(this.root);
	}

	private boolean invariant(Node root) {
		if (root == null)
			return true;
		if (root.leftChild == null && root.rightChild == null) {
			return true;
		} else {
			if (root.leftChild == null) {
				return (!root.rightChild.less(root) && invariant(root.rightChild));
			} else {
				if (root.rightChild == null) {
					return (!root.less(root.leftChild) && invariant(root.leftChild));
				} else {
					return ((!root.rightChild.less(root) || !root
							.less(root.leftChild))
							&& invariant(root.rightChild) && invariant(root.leftChild));
				}
			}
		}
	}

	private void swap(Node a, Node b) {
		Item temp = a.item;
		a.item = b.item;
		b.item = temp;
	}

	private boolean consistent(Node node) {
		if (node == null)
			return true;
		if (node.leftChild != null && node.rightChild != null) {
			if (node.less(node.leftChild) || node.less(node.rightChild))
				return false;
		} else {
			if (node.leftChild != null) {
				if (node.less(node.leftChild))
					return false;
			} else {
				if (node.rightChild != null) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void bubbleUp(Node node) {
		while (!consistent(node.parent)) {
			swap(node, node.parent);
			bubbleUp(node.parent);
		}
	}

	private Node greater(Node a, Node b) {
		if (a.less(b)) {
			return b;
		}
		return a;
	}
	
	private Node smaller(Node a, Node b) {
		if (a.less(b)) {
			return a;
		}
		return b;
	}

	private void sink(Node node) {
		while (!consistent(node)) {
			if (node.leftChild != null && node.rightChild != null) {
				Node current = smaller(node.leftChild, node.rightChild);
				swap(node, current);
				sink(current);
			} else {
				if (node.leftChild != null) {
					swap(node, node.leftChild);
					sink(node.leftChild);
				} else {
					swap(node, node.rightChild);
					sink(node.rightChild);
				}
			}
		}
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return (size(node.leftChild) + size(node.rightChild) + 1);
	}

	private Node last(Node root) {
		Node current = root;
		if (size(current) == 1)
			return current;
		if (size(root.leftChild) > size(root.rightChild))
			return last(root.leftChild);
		else
			return last(root.rightChild);
	}

	private void put(Item key) {
		this.root = put(root, key);
		size++;
	}

	private Node put(Node root, Item key) {
		if (root == null) {
			Node temp = new Node();
			temp.item = key;
			return temp;
		} else {
			if (size(root.leftChild) > size(root.rightChild)) {
				root.rightChild = put(root.rightChild, key);
				root.rightChild.parent = root;
			} else {
				root.leftChild = put(root.leftChild, key);
				root.leftChild.parent = root;
			}
		}
		return root;
	}
	
	/**
	 * Insert an element into our PQ. Then do stuff to maintain 
	 * the heap structure for the PQ.
	 * 
	 * @param key is the elements to be inserted.
	 */
	public void add(Item key) {
		put(key);
		bubbleUp(last(root));
	}
	
	/**
	 * Remove the greatest(the highest priority) element from the PQ. And 
	 * then push the second highest priority element on top of the PQ.
	 * 
	 * @return the top element in the Priority Queue
	 */
	public Item remove() {
		assert (!isEmpty()) : "There is no elements in this queue to remove!";
		Node last = last(this.root);
		swap(this.root, last);
		Item item = last.item;
		if (size(this.root) == 1) {
			this.root = null;
		} else {
			if (size(last.parent) == 2) {
				last.parent.leftChild = null;
			} else {
				last.parent.rightChild = null;
			}
		}
		sink(root);
		size--;
		return item;
	}

	public static void main(String[] args) {
		PQ<Integer> pq = new PQ<>();

		for ( int i = 0; i < 15; i++) {
			int key = (int) (Math.random()*100);
			System.out.print("[ " + key + " ],  ");
			pq.add(key);
		}
		System.out.println();
		for ( int i = 0; i < 15; i++) {
			System.out.print("[ " + pq.remove() + " ],  ");
		}
	}
}

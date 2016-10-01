
public class Draft {
	public static class Node {
		private int item;
		private Node leftChild;
		private Node parent;
		
	}
	
	public static void main(String[] args) {
		Node first = new Node();
		first.item = 5;
		Node second = new Node();
		first.leftChild = second;
		second.parent = first;
		
		Node temp = first.leftChild;
		temp.parent.leftChild = null;
		System.out.println(first.leftChild);
		System.out.println(second);
		System.out.println(first);
	  
	}
}

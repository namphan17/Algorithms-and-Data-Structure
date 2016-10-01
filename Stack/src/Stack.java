import java.util.NoSuchElementException;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private Node lastIn;
	private int size;
	private class Node {
		private Item item;
		private Node next;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void push(Item item) {
		Node temp = lastIn;
		lastIn = new Node();
		lastIn.item = item;
		lastIn.next = temp;
	}
	
	public Item pop() {
		Item item = lastIn.item;
		lastIn = lastIn.next;
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new DumbIterator();
	}
	private class DumbIterator implements Iterator<Item>{
		Node current = lastIn;
		public boolean hasNext() { return !isEmpty(); }
		public void remove() { throw new NoSuchElementException(); }
		public Item next() { 
			Item item = current.item;
			current = current.next;
			return item;
			
		}
	}
}

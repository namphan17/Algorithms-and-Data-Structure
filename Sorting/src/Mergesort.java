import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mergesort {
	
	private static Comparable[] aux;
	
	public static Integer[] random(int N) {
		Integer[] a = new Integer[N];
		Random rand = new Random();
		for	(int i = 0; i < a.length; i++) {
			a[i] = (Integer) rand.nextInt();
		}
		return a;
	}
	
	public static ArrayList<Double> randomList(int N) {
		ArrayList<Double> list = new ArrayList<Double>();
		Random rand = new Random();
		for (int i = 0; i < N; i++) {
			list.add(rand.nextDouble());
		}
		Collections.sort(list);
		return list;
	}

	public static ArrayList<Double> merge(ArrayList<Double> a,
			ArrayList<Double> b) {
		ArrayList<Double> temp = new ArrayList<Double>();

		int aPointer = 0;
		int bPointer = 0;

		while (aPointer < a.size() && bPointer < b.size()) {
			if (a.get(aPointer) <= b.get(bPointer)) {
				temp.add(a.get(aPointer));
				aPointer++;
			} else {
				temp.add(b.get(bPointer));
				bPointer++;
			}
		}
		if (aPointer == a.size() - 1) {
			while (bPointer < b.size()) {
				temp.add(b.get(bPointer));
				bPointer++;
			}
		} else {
			while (aPointer < a.size()) {
				temp.add(a.get(aPointer));
				aPointer++;
			}
		}
		return temp;
	}

	/**
	 * This method is used to merge two sorted portion of an array into a
	 * completely sorted array.
	 * 
	 * @param a The array we want to sort.
	 * @param aux
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(Comparable[] a, int lo, int mid,
			int hi) { // Merge a[lo..mid] with a[mid+1..hi].
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			// Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++)
			// Merge back to a[lo..hi].
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (aux[j].compareTo(aux[i]) < 0)
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}
	
	/**
	 * 
	 * @param a
	 */
	
	
	public static void sort(Comparable[] a)
	{
	aux = new Comparable[a.length]; // Allocate space just once.
	sort(a, 0, a.length - 1);
	}
	
	/**
	 * 
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private static void sort(Comparable[] a, int lo, int hi)
	{ // Sort a[lo..hi].
	if (hi <= lo) return;
	int mid = lo + (hi - lo)/2;
	sort(a, lo, mid); // Sort left half.
	sort(a, mid+1, hi); // Sort right half.
	merge(a, lo, mid, hi); // Merge results (code on page 271).
	}

	
	
	public static void main(String[] args) {
		ArrayList<Double> listA = randomList(4);
		ArrayList<Double> listB = randomList(5);
		
		System.out.println("Sorting with ArrayList:");
		System.out.println("List A:");
		for (double x : listA) {
			System.out.println(x);
		}
		System.out.println("\nList B:");
		for (double x : listB) {
			System.out.println(x);
		}

		ArrayList<Double> listC = merge(listA, listB);
		System.out.println("\nList C:");
		for (double x : listC) {
			System.out.println(x);
		}
		System.out.println("Sorting with Comparable array\n");
		
		Integer[] array = random(10);
		for (Integer i : array) {
			System.out.println(i);
		}
		
		System.out.println("Unsorted!\n");
		
		sort(array);
		for (int i : array) {
			System.out.println(i);
		}
		System.out.println("Sorted!");
	}
}

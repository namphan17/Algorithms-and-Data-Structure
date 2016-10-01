import java.util.Random;

public class Quicksort {

	private static void swap(Comparable[] a, int i, int j) {
		try {
			Comparable temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("i and j are Not in range");
		}
	}

	private static void shuffleArray(Comparable[] a) {
		Random rnd = new Random();
		for (int i = a.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Comparable temp = a[index];
			a[index] = a[i];
			a[i] = temp;
		}
	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private static int partition(Comparable[] a, int low, int high) {
		// Partition into a[low...i-1] a[i] a[i+1...high]
		int i = low;
		int j = high + 1;
		Comparable k = a[low];
		while (true) {
			while (less(a[++i], k)) if (i == high) break;
			while (less(k, a[--j])) if (j == low) break;
			if (i >= j) break;
			swap(a, i, j);
		}
		swap(a, low, j);
		return j;
	}

	public static void sort(Comparable[] a) {
		shuffleArray(a);
		sort(a, 0, a.length - 1);
	}

	public static void sort(Comparable[] a, int low, int high) {
		if (high <= low)
			return;
		int j = partition(a, low, high);
		sort(a, low, j - 1);
		sort(a, j + 1, high);
	}

	public static void main(String args[]) {
		Integer[] a = { 1, 2, 3 };
		swap(a, 0, 3);

	}
}

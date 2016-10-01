import java.io.*;
import java.util.Scanner;

public class UFMain {
	public static void main(String[] args) throws IOException{
	File inFile = new File("tinyUF.txt");
	Scanner in = new Scanner(inFile);
	int N = in.nextInt();
	UF uf = new UFPathCompression(N);
	
	while (in.hasNextInt()) {
		int p = in.nextInt();
		int q = in.nextInt();
		if (!uf.isConnected(p, q)) {
			System.out.printf("\n%3d ", p);
			System.out.printf("%3d", q);
			uf.union(p, q);
		} // if
	} // while
	System.out.println("\n" + uf.getCount() + " clusters");
	in.close();
	}
}

public class UFAnalysis {
	
	public static int count(int N) {
		UF uf = new UFWeightedQuickUnion(N);
		int count = 0;
		while (!uf.allConnected()) {
			int p = (int) (Math.random()*N);
			int q = (int) (Math.random()*N);
			uf.union(p, q);
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		int T = 20;
		
		System.out.printf("%8s %10s %16s %8s\n", "N", "#Connections", "Running_Time", "Ratio");
		int N = 1000;
		double[] time = new double[N];
		for (int i = 0; i < T; i++) {
			Stopwatch tic = new Stopwatch();
			int count = count(N);
			time[i] = tic.elapsedTime();
			double ratio = 1;
			if (i!=0) ratio = Math.max(1, time[i]/time[i-1]);
			System.out.printf("%8d %10d % 16f %10f\n", N, count, time[i], ratio);
			N+=N;
		}
		
		
	} // main
}

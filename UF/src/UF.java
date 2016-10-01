public abstract class UF {
	protected final int[] elements;
	protected int count;
	protected final boolean[] sites;

	public UF(int N) {
		count = N;
		elements = new int[N];
		sites = new boolean[N];
		for (int i = 0; i < N; i++) {
			elements[i] = i;
			sites[i] = false;
		} // for
	} // constructor

	public int getCount() {
		return count;
	} // getCount

	public boolean allConnected() {
		for (int i = 0; i < sites.length; i++) {
			if (!sites[i])
				return false;
		}
		return true;
	}

	public abstract int find(int p);

	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	} // isConnected

	public abstract void union(int p, int q);
}

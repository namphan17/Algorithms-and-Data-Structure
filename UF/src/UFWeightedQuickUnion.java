public class UFWeightedQuickUnion extends UFQuickUnion {
	protected int[] size;

	public UFWeightedQuickUnion(int N) {
		super(N);
		size = new int[N];
		for (int i = 0; i < N; i++) {
			size[i] = 1;
		}
	} // constructor

	@Override
	public void union(int p, int q) {
		if (!isConnected(p, q)) {
			sites[p] = true;
			sites[q] = true;
			
			int pRoot = find(p);
			int qRoot = find(q);

			if (size[pRoot] < size[qRoot]) {
				elements[pRoot] = qRoot;
				size[qRoot] += size[pRoot];
			} else {
				elements[qRoot] = pRoot;
				size[pRoot] += size[qRoot];
			}
			count--;
		}
	} // union
}

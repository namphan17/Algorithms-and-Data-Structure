public class UFWeightedByHeight extends UFWeightedQuickUnion{
	
	
	public UFWeightedByHeight(int N) {
		super(N);
	}
	
	@Override
	public void union(int p, int q) {
		if (!isConnected(p, q)) {
			sites[p] = true;
			sites[q] = true;
			int pRoot = find(p);
			int qRoot = find(q);
			if (size[pRoot] >= size[qRoot]) {
				elements[qRoot] = pRoot;
				size[pRoot] = Math.max(size[pRoot],  size[qRoot] +1);
			}
			else {
				elements[pRoot] = qRoot;
				size[qRoot] = Math.max(size[qRoot],  size[pRoot] +1);
			}
			count--;
		}
	}
}

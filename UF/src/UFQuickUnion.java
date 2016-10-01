public class UFQuickUnion extends UF {

	public UFQuickUnion(int N) {
		super(N);
	} // constructor

	@Override
	public int find(int p) {
		while (elements[p] != p) {
			p = elements[p];
		} // while
		return p;
	} // find

	@Override
	public void union(int p, int q) {
		if (!isConnected(p, q)) {
			sites[p] = true;
			sites[q] = true;
			int pRoot = find(p);
			int qRoot = find(q);

			elements[pRoot] = qRoot;
			count--;
		} // if
	} // union
}

public class UFQuickFind extends UF {

	public UFQuickFind(int N) {
		super(N);
	} // constructor

	@Override
	public int find(int p) {
		return elements[p];
	} // find

	@Override
	public void union(int p, int q) {
		if (!isConnected(p, q)) {
			sites[p] = true;
			sites[q] = true;
			int pRoot = elements[p];
			for (int i = 0; i < elements.length; i++) {
				if (elements[i] == pRoot) {
					elements[i] = elements[q];
				} // if
			} // for
			count--;
		} // if
	} // union

}

public class UFPathCompression extends UFWeightedQuickUnion{
	
	public UFPathCompression(int N) {
		super(N);
	}
	
	public void sync(int p) {
		if (elements[p] == p) return;
		sync(elements[p]);
		elements[p] = elements[elements[p]];
	}
	@Override
	public int find(int p) {
		sync(p);
		return elements[p];
	} // find

}

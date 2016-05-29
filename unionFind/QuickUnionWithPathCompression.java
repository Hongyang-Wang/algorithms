package algorithms.unionFind;

public class QuickUnionWithPathCompression extends QuickUnion {

	public QuickUnionWithPathCompression(int N) {
		super(N);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	int root(int p) {
		while (id[p] != p) {
			id[p] = id[id[p]];  // Make every other node in path point to its grandparent (thereby halving path length)
			p = id[p];
		}
		return p;
	}

}

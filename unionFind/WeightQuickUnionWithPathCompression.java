package algorithms.unionFind;

public class WeightQuickUnionWithPathCompression extends WeightedQuickUnion {

	public WeightQuickUnionWithPathCompression(int N) {
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

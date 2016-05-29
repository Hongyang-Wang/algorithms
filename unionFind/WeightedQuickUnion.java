package algorithms.unionFind;

public class WeightedQuickUnion extends QuickUnion {

	int[] size;
	
	public WeightedQuickUnion(int N) {
		super(N);
		// TODO Auto-generated constructor stub
		size = new int[N];
		for (int i = 0; i < size.length; i++) {
			size[i] = 1;
		}
	}
	
	@Override
	public void union(int p, int q) {
		int rp = root(p);
		int rq = root(q);
		if (rp == rq) {
			return;
		}
		if (size[rp] > size[rq]) {  // Link the smaller one to the larger one
			id[rq] = rp;
			size[rp] += size[rq];
		}
		else {
			id[rp] = rq;
			size[rq] += size[rp];
		}
	}

}

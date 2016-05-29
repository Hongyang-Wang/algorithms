package algorithms.unionFind;

public class QuickUnion extends UnionFind {

	public QuickUnion(int N) {
		super(N);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void union(int p, int q) {
		// TODO Auto-generated method stub
		int rp = root(p);
		int rq = root(q);
		id[rq] = rp;
	}

	@Override
	public boolean connected(int p, int q) {
		// TODO Auto-generated method stub
		return root(p) == root(q);
	}
	
	int root(int p) {
		while (id[p] != p) {
			p = id[p];
		}
		return p;
	}

}

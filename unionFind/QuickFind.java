package algorithms.unionFind;

public class QuickFind extends UnionFind {

	public QuickFind(int N) {
		super(N);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void union(int p, int q) {
		// TODO Auto-generated method stub
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == qid) {
				id[i] = pid;
			}
		}
	}

	@Override
	public boolean connected(int p, int q) {
		// TODO Auto-generated method stub
		return id[p] == id[q];
	}

}

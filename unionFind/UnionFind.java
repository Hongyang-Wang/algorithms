package algorithms.unionFind;

public abstract class UnionFind {
	
	int[] id;
	
	public UnionFind(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public abstract void union(int p, int q);
	public abstract boolean connected(int p, int q);	
	
}
package algorithms.unionFind;
import algorithms.unionFind.UnionFind;
import algorithms.unionFind.WeightQuickUnionWithPathCompression;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;;

public class UnionFindTest {
	
	public static void main(String[] args) {
		int N = 500, M = 1000;
		UnionFind uf = new WeightQuickUnionWithPathCompression(N);
		WeightedQuickUnionUF gt = new WeightedQuickUnionUF(N);
		for (int i = 0; i < M; i++) {
			int p = (int)(Math.random() * N), q = (int)(Math.random() * N);
			uf.union(p, q);
			gt.union(p, q);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (uf.connected(i, j) ^ gt.connected(i, j)) {
					System.out.println("Incorrect: " + i + ", " + j);
					return;
				}
			}
		}
		System.out.println("Correct");
	}
	
}

package algorithms.nonComparisonSort;

public class CountSort {
	
	public void sort(int[] arr, int lo, int hi) {
		if (hi <= lo + 1)
			return;
		int N = hi - lo;
		int[] count = new int[N + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - lo + 1]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		int[] aux = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			aux[count[arr[i] - lo]++] = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = aux[i];
		}
	}
	
	
	public static void main(String[] args) {
		
	}
	
}

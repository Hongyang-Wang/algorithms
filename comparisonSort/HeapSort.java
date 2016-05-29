package algorithms.comparisonSort;

public class HeapSort extends ComparisonSort {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (end <= start + 1)
			return;
		// Build maxheap
		for (int i = (end - start) / 2; i >= 0; i--) {
			sink(arr, i, start, end);
		}
		// sort
		for (int i = end - start - 1; i > 0; i--) {
			swap(arr, start + i, start);
			sink(arr, 0, start, start + i);  // end decreases for 1
		}		
	}
	
	private <T extends Comparable<T>> void sink(T[] arr, int i, int start, int end) {
		while (start + 2 * i < end) {
			int maxInd = 2 * i;
			if (start + maxInd + 1 < end && arr[start + maxInd + 1].compareTo(arr[start + maxInd]) > 0)
				maxInd += 1;
			if (arr[start + i].compareTo(arr[start + maxInd]) < 0) {
				swap(arr, start + i, start + maxInd);
				i = maxInd;
			}
			else
				break;
		}
	}	
	
	public static void main(String[] args) {
		(new HeapSort()).test(10000, 5000, 87, 8340, false);
	}

}

package algorithms.sort;

public class HeapSort extends Sort {

	@Override
	public void sort(int[] arr, int start, int end) {
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

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int start, int end) {
		// TODO Auto-generated method stub

	}
	
	private void sink(int[] arr, int i, int start, int end) {
		while (start + 2 * i < end) {
			int maxInd = 2 * i;
			if (start + maxInd + 1 < end && arr[start + maxInd + 1] > arr[start + maxInd])
				maxInd += 1;
			if (arr[start + i] < arr[start + maxInd]) {
				swap(arr, start + i, start + maxInd);
				i = maxInd;
			}
			else
				break;
		}
	}
	
	
	public static void main(String[] args) {
		(new HeapSort()).test(1000, 500, 344, 876, false);
	}

}

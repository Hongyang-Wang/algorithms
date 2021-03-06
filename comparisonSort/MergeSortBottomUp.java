package algorithms.comparisonSort;

public class MergeSortBottomUp extends ComparisonSort {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (end <= start + 1)
			return;
		for (int sz = 1; sz < end - start; sz *= 2) {
			for (int i = start; i < end - sz; i += 2 * sz) {
				merge(arr, i, i + sz, Math.min(i + 2 * sz, end));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private <T extends Comparable<T>> void merge(T[] arr, int start1, int start2, int end) {
		int i = start1, j = start2, k = 0;
		T[] aux = (T[]) new Comparable[end - start1];
		while (k < end - start1) {
			if (i >= start2)
				aux[k++] = arr[j++];
			else if (j >= end)
				aux[k++] = arr[i++];
			else {
				if (arr[i].compareTo(arr[j]) <= 0)
					aux[k++] = arr[i++];
				else
					aux[k++] = arr[j++];
			}
		}
		for (i = start1, k = 0; k < aux.length; i++, k++)
			arr[i] = aux[k];
	}
	
	
	public static void main(String[] args) {
		(new MergeSortBottomUp()).test(10000, 5000, 87, 8340, false);
	}
	
}

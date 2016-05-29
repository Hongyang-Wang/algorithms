package algorithms.comparisonSort;

public class MergeSortTopDown extends ComparisonSort {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (end <= start + 1)
			return;
		
		int len = end - start, mid = start + len / 2;
		sort(arr, start, mid);  // top-down
		sort(arr, mid, end);
		
		T[] aux = (T[]) new Object[len];
		int i = start, j = mid, k = 0;
		while (k < len) {
			if (i >= mid)
				aux[k++] = arr[j++];
			else if (j >= end)
				aux[k++] = arr[i++];
			else {
				if (arr[i].compareTo(arr[j]) <= 0)  // stable
					aux[k++] = arr[i++];
				else
					aux[k++] = arr[j++];
			}
		}
		for (i = start, k = 0; i < end; i++, k++) {
			arr[i] = aux[k];
		}
	}

}

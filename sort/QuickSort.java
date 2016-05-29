package algorithms.sort;

public class QuickSort extends Sort {

	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (end <= start + 1) {
			return;
		}
		T pivot = arr[randInt(start, end)];
		int lt = start, i = start, gt = end - 1;
		while (i <= gt) {
			if (arr[i].compareTo(pivot) < 0) {
				swap(arr, lt++, i++);
			}
			else if (arr[i].compareTo(pivot) > 0) {
				swap(arr, i, gt--);
			}
			else {
				i++;
			}
		}
		sort(arr, start, lt);
		sort(arr, gt + 1, end);
	}

	// O(n) time complexity; find the kth smallest element in an array
	public static <T extends Comparable<T>> T findKthElement(T[] arr, int start, int end, int k) {
		if (end <= start || k <= 0) {
			return null;
		}
		int len = end - start;
		if (k > len) {
			return null;
		}
		
		T pivot = arr[randInt(start, end)];
		int i = start, lt = start, gt = end - 1;
		while (i <= gt) {
			if (arr[i].compareTo(pivot) < 0) {
				swap(arr, i++, lt++);
			}
			else if (arr[i].compareTo(pivot) > 0) {
				swap(arr, i, gt--);
			}
			else {
				i++;
			}
		}
		
		if (start + k - 1 < lt) {
			return findKthElement(arr, start, lt, k);
		}
		else if (start + k - 1 > gt) {
			return findKthElement(arr, gt + 1, end, k - (gt - start + 1));
		}
		return pivot;
	}	
	
	private static int randInt(int l, int h) {
		return l + (int)(Math.random() * (h - l));
	}
	
}

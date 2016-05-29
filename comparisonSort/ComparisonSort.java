package algorithms.comparisonSort;

public abstract class ComparisonSort {
	
	public abstract <T extends Comparable<T>> void sort(T[] arr, int start, int end);
	
	static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
		if (i == j) {
			return;
		}
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	void test(int numOfElements, int rangeOfElements, int start, int end, boolean print) {
		Integer[] arr1 = new Integer[numOfElements], arr2 = new Integer[numOfElements];
		for (int i = 0; i < numOfElements; i++) {
			int e = (int)(Math.random() * rangeOfElements);
			arr1[i] = e;
			arr2[i] = e;
		}
		if (print) {
			printArray(arr1);
		}
		
		java.util.Arrays.sort(arr1, start, end);
		sort(arr2, start, end);
		if (print) {
			printArray(arr1);
			printArray(arr2);
		}		
		
		for (int i = 0; i < numOfElements; i++) {
			if (arr1[i].compareTo(arr2[i]) != 0) {
				System.out.println("Incorrect: " + "i = " + i + ", arr1[i] = " + arr1[i] +
						"arr2[i] = " + arr2[i]);
				return;
			}
		}
		System.out.println("Correct");
	}
	
	private <T extends Comparable<T>> void printArray(T[] arr) {
		for (T e : arr)
			System.out.print(e.toString() + " ");
		System.out.println();
	}
	
}

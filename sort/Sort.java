package algorithms.sort;

/* Comparison based sort */
public abstract class Sort {
	
	public abstract void sort(int[] arr, int start, int end);
	public abstract <T extends Comparable<T>> void sort(T[] arr, int start, int end);
	
	static void swap(int[] arr, int i, int j) {
		if (i == j) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
		if (i == j) {
			return;
		}
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	void test(int N, int M, int start, int end, boolean print) {
		int[] arr1 = new int[N], arr2 = new int[N];
		for (int i = 0; i < N; i++) {
			int e = (int)(Math.random() * M);
			arr1[i] = e;
			arr2[i] = e;
		}
		if (print) {
			printArray(arr1);
			printArray(arr2);
		}
		
		java.util.Arrays.sort(arr1, start, end);
		sort(arr2, start, end);
		if (print) {
			printArray(arr1);
			printArray(arr2);
		}		
		
		for (int i = 0; i < N; i++) {
			if (arr1[i] != arr2[i]) {
				System.out.println("Incorrect");
				return;
			}
		}
		System.out.println("Correct");
	}
	
	static void printArray(int[] arr) {
		for (int e : arr)
			System.out.print(e + " ");
		System.out.println();
	}	
	
}

package algorithms.nonComparisonSort;

public class CountSort {
	
	public static void sort(int[] arr, int lo, int hi) {
		if (hi <= lo + 1)
			return;
		int N = hi - lo;
		int[] count = new int[N + 1];  // +1 for convenience
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

	static void test(int numOfElements, int rangeOfElements, boolean print) {
		int[] arr1 = new int[numOfElements], arr2 = new int[numOfElements];
		for (int i = 0; i < numOfElements; i++) {
			int e = (int)(Math.random() * rangeOfElements);
			arr1[i] = e;
			arr2[i] = e;
		}
		if (print) {
			printArray(arr1);
		}
		
		java.util.Arrays.sort(arr1);
		sort(arr2, 0, rangeOfElements);
		if (print) {
			printArray(arr1);
			printArray(arr2);
		}		
		
		for (int i = 0; i < numOfElements; i++) {
			if (arr1[i] != arr2[i]) {
				System.out.println("Incorrect: " + "i = " + i + ", arr1[i] = " + arr1[i] +
						", arr2[i] = " + arr2[i]);
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
	
	public static void main(String[] args) {
		CountSort.test(10000, 50, false);
	}
	
}

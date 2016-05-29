package algorithms.nonComparisonSort;

public class RadixSort {

	/* Only for non-negative integers */
	public static void sort(int[] arr, int R) {
		if (arr.length <= 1)
			return;
		int maxVal = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maxVal)
				maxVal = arr[i];
		}
		int[] aux = new int[arr.length];
		for (int i = 0, r = 1; i <= (int) (Math.log(maxVal) / Math.log(R)); i++, r *= R) {
			int[] count = new int[R + 1];
			for (int e : arr)
				count[(e / r) % R + 1]++;
			for (int j = 1; j < count.length; j++)
				count[j] += count[j - 1];
			for (int e : arr)
				aux[count[(e / r) % R]++] = e;
			for (int j = 0; j < arr.length; j++)
				arr[j] = aux[j];
		}
	}
	
	static void test(int numOfElements, int rangeOfElements, int R, boolean print) {
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
		sort(arr2, R);
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
		RadixSort.test(10000, 1000, 10, false);
	}	
	
}

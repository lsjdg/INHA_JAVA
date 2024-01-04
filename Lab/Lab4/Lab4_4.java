package Lab4;

class ArrayUtil{
	static int[] concat(int arr1[], int arr2[]) {
		int[] arr3 = new int [arr1.length + arr2.length];
		int idx = 0;
		for (int i = 0; i<arr1.length; i++) {
			arr3[idx] = arr1[i];
			idx++;
		}
		for (int i = 0; i<arr2.length; i++) {
			arr3[idx] = arr2[i];
			idx++;
		}
		return arr3;
	}
	
	static void print(int arr[]) {
		System.out.print("[ ");
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.print(" ]");
	}
}

public class Lab4_4{
	public static void main(String args[]) {
		int array1[] = {1993, 0, 5, 1, 6};
		int array2[] = {1990, 0, 2, 1, 2};
		
		int array3[] = new int[array1.length + array2.length];
		array3 = ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);
	}
}
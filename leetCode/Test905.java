package leetCode;

public class Test905 {
	public int[] sortArrayByParity(int[] A) {
		int j = 0;
		int k = A.length - 1;
		int[] B = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				B[j] = A[i];
				j++;
			} else {
				B[k] = A[i];
				k--;
			}
		}
		return B;
	}
}

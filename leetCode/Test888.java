package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class Test888 {
	public static int sum(int[] input) {
		int total = 0;

		for (int i = 0; i < input.length; i++) {
			total = total + input[i];
		}
		return total;

	}
	
	public static int[] fairCandySwap(int []A, int []B){
		int sumA = sum(A);
		int sumB = sum(B);
		int avg = (sumA+sumB)/2;
		Arrays.sort(B);
		for(int i=0; i < A.length; i++){
			int newSum = sumA - A[i];
			if(avg > newSum){
				int diff = avg - newSum;
				int index = Arrays.binarySearch(B, diff);
				if(index >=0 && index < B.length){
					int []result = new int[2];
					result[0] = A[i];
					result[1] = B[index];
					return result;
				}
			}
		}
		return new int[2];
	}

	public static int[] fairCandySwapOld(int[] A, int[] B) {
		int sumA = sum(A);
		int sumB = sum(B);
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {

				int newSumA = sumA - A[i] + B[j];
				int newSumB = sumB - B[j] + A[i];

				int temp = A[i];
				A[i] = B[j];
				B[j] = temp;

				if (newSumA == newSumB) {
					int[] result = new int[2];
					result[0] = B[j];
					result[1] = A[i];
					return result;
				} else {
					temp = A[i];
					A[i] = B[j];
					B[j] = temp;

				}
			}

		}

		return new int[2];
	}

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int n1 = sc1.nextInt();
		int[] a = new int[n1];
		for (int i = 0; i < n1; i++) {
			a[i] = sc1.nextInt();
		}

		// Scanner sc2 = new Scanner(System.in);
		int n2 = sc1.nextInt();
		int[] b = new int[n2];
		for (int i = 0; i < n2; i++) {
			b[i] = sc1.nextInt();
		}

		int[] ans = new int[2];
		ans = fairCandySwap(a, b);
		System.out.println("Exchanged is " + ans[0] + " " + ans[1]);
		sc1.close();
	}
}

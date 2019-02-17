package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class Test976 {
	public static boolean isValidTriangle(int a, int b, int c) {
		if (a + b <= c) {
			return false;
		}
		if (b + c <= a) {
			return false;
		}
		if (a + c <= b) {
			return false;
		}
		return true;
	}

	public static int perimeter(int a, int b, int c) {
		return a + b + c;
	}

	public static int largestPerimeter(int[] A) {
		Arrays.sort(A);
		int j=A.length-1;
		while (j >= 2) {
			int a =A[j];
			int b = A[j-1];
			int c= A[j-2];
			if(isValidTriangle(a, b, c)){
				return perimeter(a,b,c);
			}
			j--;
		}
		return 0;
	}
	
	public static void main(String []args){
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int []input=new int[n];
		for(int i=0;i<n;i++){
			input[i]=sc.nextInt();
		}
		int result = largestPerimeter(input);
		System.out.println("Result"+ result);
	}
}

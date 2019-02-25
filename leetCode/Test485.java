package leetCode;

import java.util.Scanner;

public class Test485 {
	public static int findMaxConsecutiveOnes(int[] nums) {
		int i = 0, j = 0;
		int[] max = new int[nums.length];

		for (i = 0; i < nums.length; i++) {
			int count = 0;
			while (nums[i] == 1) {

				count++;
				i++;
				if (i >= nums.length) {
					break;
				}
			}
			max[j] = count;
			j++;
		}
		if (max.length == 0) {
			return 0;
		}
		int largest = 0;
		for (i = 0; i < max.length; i++) {
			if (max[i] > largest) {
				largest = max[i];
			}

		}

		return largest;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		int result = findMaxConsecutiveOnes(input);
		System.out.println("Result is " + result);
		sc.close();
	}
}

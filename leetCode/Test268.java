package leetCode;

import java.util.Arrays;

public class Test268 {
	public int missingNumber(int[] nums) {
		if (nums.length == 1 && nums[0] == 1) {
			return 0;

		}
		Arrays.sort(nums);
		int first = nums[0];
		if (first != 0) {
			return 0;
		}

		for (int i = 0; i <= nums.length; i++) {
			if (i + 1 == nums.length) {
				return i + 1;
			} else if ((i + 1) == nums[i + 1]) {
				continue;
			} else {
				return i + 1;
			}

		}
		return 0;
	}
}

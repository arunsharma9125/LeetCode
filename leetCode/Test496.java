package leetCode;

public class Test496 {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					boolean found = false;
					for (int k = j + 1; k < nums2.length; k++) {
						if (nums2[k] > nums1[i]) {
							result[i] = nums2[k];
							found = true;
							break;
						}
					}
					if (found == false) {
						result[i] = -1;
					}

				}
			}
		}
		return result;
	}

}

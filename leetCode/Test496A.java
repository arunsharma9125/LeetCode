package leetCode;

import java.util.Arrays;
import java.util.Stack;

public class Test496A {

	static class Pair implements Comparable<Pair>{
		Integer num;
		Integer post;

		public Pair(int num, int post) {
			super();
			this.num = num;
			this.post = post;
		}

		public Pair() {
		}

		public Integer getNum() {
			return num;
		}

		public void setNum(Integer num) {
			this.num = num;
		}

		public Integer getPost() {
			return post;
		}

		public void setPost(Integer post) {
			this.post = post;
		}

		@Override
		public int compareTo(Pair anotherPair) {
			return this.getNum().compareTo(anotherPair.getNum());
		}

	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int[] higher = new int[nums2.length];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (st.isEmpty()) {
				st.push(i);
			} else {
				while (st.empty() == false && nums2[i] > nums2[st.peek()]) {
					int index = st.pop();
					higher[index] = nums2[i];
				}
				st.push(i);
			}
		}
		while (st.isEmpty() == false) {
			int index = st.pop();
			higher[index] = -1;
		}
		Pair[] pairs = new Pair[nums2.length];
		for (int i = 0; i < nums2.length; i++) {
			Pair pair = new Pair();
			pair.setNum(nums2[i]);
			pair.setPost(higher[i]);
		}
		Arrays.sort(pairs);
		Arrays.sort(nums1);

		int[] result = new int[nums1.length];
		int i = 0, j = 0;
		while (i < nums1.length) {
			if (nums1[i] == pairs[j].getNum()) {
				result[i] = pairs[j].getPost();
				i++;
				j++;
			} else if (pairs[j].getNum() < nums1[i]) {
				j++;
			} else {
				i++;
			}
		}
		return result;
	}
}

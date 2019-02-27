package leetCode;

public class Test344 {
	public void reverseString(char[] s) {
		int n = s.length;
		char temp;
		if (n > 2) {
			int last = n - 1;
			for (int i = 0; i < n / 2; i++) {
				temp = s[i];
				s[i] = s[last];
				s[last] = temp;
				--last;

			}
		} else if (n == 2) {
			temp = s[0];
			s[0] = s[1];
			s[1] = temp;
		}
	}
}

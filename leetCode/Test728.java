package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Test728 {

	public List<Integer> digits(int num) {
		List<Integer> list = new ArrayList<Integer>();
		while (num != 0) {
			int rem = num % 10;
			list.add(rem);
			num = num / 10;
		}
		return list;
	}

	public boolean isSelfDividing(int num) {
		List<Integer> digits = digits(num);
		for (int i = 0; i < digits.size(); i++) {
			if(digits.get(i)==0){
				return false;
			}
			if (num % digits.get(i) != 0) {
				return false;
			}
		}
		return true;
	}

	public List<Integer> selfDividingNumbers(int left, int right) {

		List<Integer> result = new ArrayList<Integer>();
		for (int i = left; i <= right; i++) {

			if (isSelfDividing(i)) {
				result.add(i);
			}
		}
		return result;
	}
}

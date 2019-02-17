package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test120 {

	public static int minimumTotal(List<List<Integer>> triangle) {
		List<List<Integer>> minList = new ArrayList<List<Integer>>();
		for (int i = 0; i < triangle.size(); i++) {
			List<Integer> tempList = new ArrayList<Integer>();
			for (int j = 0; j < triangle.get(i).size(); j++) {
				tempList.add(0);
			}
			minList.add(tempList);
		}
		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (i == triangle.size() - 1) {
					minList.get(i).set(j, triangle.get(i).get(j));
				} else {
					int min = Math.min(minList.get(i+1).get(j), minList.get(i+1).get(j+1) );
					min += triangle.get(i).get(j);
					minList.get(i).set(j, min);
				}
			}
		}
		return minList.get(0).get(0);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		for (int i = 0; i < rows; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < i + 1; j++) {
				int num = sc.nextInt();
				temp.add(num);
			}
			triangle.add(temp);
		}
		int result = minimumTotal(triangle);
		System.out.println(result);
		sc.close();
	}
}

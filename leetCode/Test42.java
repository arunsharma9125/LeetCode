package leetCode;

public class Test42 {

	public int[] rightMax(int[] height) {
		int max=0;
		int []maxArr = new int[height.length];
		for(int i=height.length -1; i>=0; i--){
			if(height[i] > max){
				max = height[i];
			}
			maxArr[i] = max;
		}
		return maxArr;
	}
	
	public int[]leftMax(int []height){
		int max=0;
		int []maxArr = new int[height.length];
		for(int i=0; i <height.length; i++){
			if(height[i] > max){
				max = height[i];
			}
			maxArr[i] = max;
		}
		return maxArr;
	}
	
	public int trap(int[] height) {
		int sum = 0;
		int []lmaxArr = leftMax(height);
		int []rmaxArr = rightMax(height);
		for (int i = 1; i < height.length - 1; i++) {
			int h = height[i];
			int lmax = lmaxArr[i];
			int rmax = rmaxArr[i];
			int min = Math.min(lmax, rmax);

			if (min > h) {
				sum += min - h;
			}
		}
		return sum;
	}

	public int trap1(int[] height) {
		int sum = 0;
		for (int i = 1; i < height.length - 1; i++) {
			int h = height[i];
			int lmax = height[i - 1];
			for (int j = i - 2; j >= 0; j--) {
				if (height[j] > lmax) {
					lmax = height[j];
				}

			}
			int rmax = height[i + 1];
			for (int j = i + 2; j < height.length; j++) {
				if (height[j] > rmax) {
					rmax = height[j];
				}
			}
			int min = Math.min(lmax, rmax);

			if (min > h) {
				sum += min - h;
			}
		}
		return sum;
	}
}

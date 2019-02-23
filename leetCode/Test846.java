package leetCode;

import java.util.TreeMap;

public class Test846 {

	public boolean isNStraightHand(int[] hand, int W) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < hand.length; i++) {
			if (map.containsKey(hand[i])) {
				map.put(hand[i], map.get(hand[i]) + 1);
			} else {
				map.put(hand[i], 1);
			}
		}
		
		while(true){
			if(map.isEmpty()){
				return true;
			}
			int first = map.firstKey();
			for(int i=0;i<W;i++){
				if(map.containsKey(first) == false){
					return false;
				}else{
					int count = map.get(first);
					if(count==1){
						map.remove(first);
					}else{
						map.put(first, count-1);
					}
					first = first+1;	
				}
			}
		}
	}
	


}

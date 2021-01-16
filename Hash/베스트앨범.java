package Hash;
import java.util.HashMap;
import java.util.Arrays;

public class ����Ʈ�ٹ� {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> first = new HashMap<String, Integer>();
		HashMap<String, Integer> second = new HashMap<String, Integer>();
		HashMap<String, Integer> sum = new HashMap<String, Integer>();
		HashMap<Integer, String> newsum = new HashMap<Integer, String>();
		for(int i = 0; i < genres.length;i++){  // �帣���� ù��°
			if(first.containsKey(genres[i])){
				if(plays[first.get(genres[i])] < plays[i]){
					first.put(genres[i], i);
				}

			}else{
				first.put(genres[i], i);
			}
			if(sum.containsKey(genres[i])){
				sum.put(genres[i], sum.get(genres[i])+plays[i]);
			}else{
				sum.put(genres[i], plays[i]);
			}
		}

		for(int i = 0; i < genres.length; i++){ // �帣���� �ι�°
			if(!first.containsValue(i))
				if(second.containsKey(genres[i])){
					if(plays[second.get(genres[i])] < plays[i])
						second.put(genres[i],i);
				}else{
					second.put(genres[i],i);
				}
		}
		int len = first.size() + second.size();

		int[] answer = new int[len];
		int[] temp = new int[sum.size()];

		int k = 0;
		for(String key : sum.keySet()){
			temp[k] = sum.get(key);
			newsum.put(sum.get(key),key);
			k++;
		}
		Arrays.sort(temp);
		k=0;
		for(int i = temp.length-1 ; i >= 0; i-- ){
			answer[k] = first.get(newsum.get(temp[i]));
			k++;
			if(second.containsKey(newsum.get(temp[i]))){
				answer[k] = second.get(newsum.get(temp[i]));
				k++;
			}    
		}
		return answer;
	}
}

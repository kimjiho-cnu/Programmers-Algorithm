package Greedy;

public class ü���� {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		for(int i = 0 ; i < lost.length ; i++){ // �����ְ� ����
			for(int j = 0 ; j < reserve.length; j++){
				if(lost[i] == reserve[j]){
					lost[i] = -1;
					reserve[j] = n+n;
				}
			}
		}
		for(int i = 0 ; i < lost.length ; i++){
			int check = 0 ;
			for(int j = 0 ; j < reserve.length ; j++){

				if(lost[i]+1 == reserve[j] || lost[i]-1 == reserve[j]){ // ������ ����
					check++;
					reserve[j] = n+n;
					break;
				}
			}
			if(check == 0 && lost[i] != -1 ){   // ������
				answer--;
			}
		}
		return answer;
	}
}

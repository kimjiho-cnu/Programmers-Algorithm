package Greedy;

public class ü���� {
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        for(int i = 0 ; i < lost.length ; i++){ // ������ ������ �ߺ��Ǵ� �л�
            int lost_num = lost[i];
            for(int j = 0 ; j < reserve.length ; j++){
                int reserve_num = reserve[j];
                if(lost_num == reserve_num){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for(int i = 0 ; i < lost.length ; i++){ // �������� ������ �������� �л�
            int lost_num = lost[i];
            if(lost_num == -1)
                continue;
            for(int j=0 ; j < reserve.length ; j++){
                int reserve_num = reserve[j];
                if(reserve_num == -1)
                    continue;
                if(lost_num + 1 == reserve_num || lost_num - 1 == reserve_num){
                        answer++;
                        reserve[j] = -1;
                        break;
                }
            }
        }
        return answer;
    }
}

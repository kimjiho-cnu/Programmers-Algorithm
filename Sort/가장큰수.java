package Sort;
public class ����ū�� {
	public String solution(int[] numbers) {
        String answer = "";
        //1. 10���� ���� ���� ���� ū��
        //2. 10���� ���� ������ ���ٸ�, �ڿ� ū���ڵ��� �ִ°��� �켱
        
        int[] seq = new int[numbers.length];
        int[] div_num = numbers.clone();
        
        
        
        for(int i = 0 ; i < numbers.length ; i++){
            while(div_num[i] >= 10)
                div_num[i] = div_num[i] / 10;
            if(div_num[i] == 0)
                div_num[i] = div_num[i] % 10;
        }
        
        for(int i = 0 ; i < numbers.length ; i++){
            int max = -1;
            int max_i = -1;
            for(int j = 0 ; j < numbers.length; j++){
                if(div_num[j] == -1)
                    continue;
                if(div_num[j] > max){
                    max = div_num[j];
                    max_i = j;
                    continue;
                }
                else if( div_num[j] == max){
                    if(numbers[j] % 10 == 0) {   // 200 �� 20 �����͵�
                        if(numbers[j] < numbers[max_i]){
                            max = div_num[j];
                            max_i = j;
                        }     
                        continue;
                    }
                    int before = numbers[max_i];
                    if( (before - ( div_num[max_i] * 100)) > 0 )
                        before -= ( div_num[max_i] * 100);
                    else if( (before - ( div_num[max_i] * 10)) > 0 )
                        before -= ( div_num[max_i] * 10);
                        
                    int after = numbers[j];
                    if( (after - ( div_num[j] * 100)) > 0 )
                        after -= ( div_num[j] * 100);
                    else if( (after - ( div_num[j] * 10)) > 0 )
                        after -= ( div_num[j] * 10);
                        
                    if(after > before){
                        max = div_num[j];
                        max_i = j;
                    }
                }
            }
            seq[i] = max_i;
            div_num[max_i] = -1;
        }
        if(numbers[seq[0]] == 0)
            return "0";
        
        for(int i = 0 ; i < seq.length ; i++){
            answer+= numbers[seq[i]];
        }
        return answer;
    }
}

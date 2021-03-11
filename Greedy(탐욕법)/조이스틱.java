package Greedy;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class ���̽�ƽ {
	public int solution(String name) {
        int answer = 0;
        
        int[] string_name = new int[name.length()];
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < name.length() ; i++){
            
            if(-65 + name.charAt(i) != 0 && i != 0){
                q.add(i);
                st.push(i);
            }
            string_name[i] += -65 + name.charAt(i);
            
            if(-65 + name.charAt(i) > 13)
                string_name[i] = 26 - (-65 + name.charAt(i)) ;
            
        }
        answer += string_name[0];
        int now = 0;
        while(!q.isEmpty()){
            int next = q.poll();
            int last = st.peek();
            
            int front = next - now ;
            int back = (string_name.length - last) + (now);
            
            if(front <= back){   // ���������� ���°� ������
                answer += (string_name[next] + front);
            }else{  //�ڷ� ���°� ������
                answer += (now+1) ;
                for(int i = string_name.length-1 ; i > next ; i--){
                    answer += (string_name[i]+1);
                }
                answer +=(string_name[next]);
                
                break;
                    
            }
            
            now = next ;    
        }
        
        // �ʹ� �ܼ��ϰ� �ذ��Ϸ� �ߴ�
        // ���� A�� �ƴ� �������� �ڷΰ��°� �� ������ �׋����� �ڷ� ��
        
        return answer;
    }
}

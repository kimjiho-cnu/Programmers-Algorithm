package Heap;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class ��ũ��Ʈ�ѷ� {
	public int solution(int[][] jobs) {
		int answer = 0;
        int time = 0;
        int check = 0;
        
        Arrays.sort(jobs, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
        
        while(true){
			if(check == jobs.length)   // ���� ����
			break;

			PriorityQueue<Integer> p = new PriorityQueue<>();
			check = 0;
			for(int i = 0 ; i < jobs.length ; i++){
				if(jobs[i][0] == -1){
					check++;
					continue;
				}
				if(time >= jobs[i][0])
					p.add(jobs[i][1]); 
			}
			if(!p.isEmpty()){
				int a = p.poll();
				for(int i = 0 ; i < jobs.length ; i++) {
					if(jobs[i][0] == -1)
						continue;
					if(jobs[i][1] == a) {
						time += a;
						answer += (time - jobs[i][0]);
						jobs[i][0] = -1;
						jobs[i][1] = -1;
						break;
					}
				}
			}else{
				time++;
			}
		}
		answer /= jobs.length;
		return answer;
	}
}

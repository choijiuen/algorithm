package sds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//연산자 끼워넣기
public class BJ14888_2 {

	static int N, num[], op[], max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;	//숫자 갯수, 숫자들, 연산자, 최대값, 최솟값
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(br.readLine());	//숫자갯수 입력
		num = new int[N];
		op = new int[4];
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());	//숫자들 입력 공백 있으니깐 st.nextToken
		}
	
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());	//연산자 4개 0,1로 입력 이것도 공백있음 
		}
		dfs(num[0], 1);
		System.out.println(max);	//최댓값
		System.out.println(min);	//최솟값
	}
	static void dfs(int cur, int idx) {
		if(idx==N) {
			max = Math.max(max, cur);	//최댓값 반환해주는 함수
			min = Math.min(min, cur);
			return;
		}
		for(int i=0; i<4; i++) {
			if(op[i]>0) {
				op[i]--;		//연산자가 1개 이상 있으면 하나 씩 줄여주면서 dfs 하기 
				dfs(calc(cur, num[idx],i), idx+1);
				op[i]++;
			}
		}
	}
	static int calc(int num1, int num2, int op) {
		if(op==0) return num1+num2;
		else if(op==1) return num1-num2;
		else if(op==2) return num1*num2;
		else return num1/num2;
	}

}



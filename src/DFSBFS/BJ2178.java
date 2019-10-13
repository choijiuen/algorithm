package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] isVisit;
	
	//정점은 4개의 위치로 이동할 수 있다
	//(x-1,y) , (x+1,y), (x,y-1), (x,y+1)
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		isVisit = new boolean[N+1][M+1];
		
		for (int i=1; i<=N;i++){
//			char[] value = br.readLine().toCharArray();
			String str = br.readLine();		//공백없이 입력하니깐 StrignTokenizer 필요없다
			for(int j=1; j<=M; j++){
//				map[i][j] =(int) value[j-1] -48;
				map[i][j] =str.charAt(j-1)-'0';
			}
		}
		isVisit[1][1] =true;
		Miro(1,1);
		System.out.println(map[N][M]);
	}
	
	public static void Miro(int x, int y){
		//정점을 큐에 담기 위해서는 다음과 같은 조건이 필요
		//1. N*M의 위치를 초과하지 않을 것 (1<= x <=N, 1<=y <=M)
		//2. 해당 위치에 방문한 적이 없을 것
		//3. 해당 위치의 값이 0이 아닐 것
		//위 3가지 조건을 지킨다면, (N,M)은 지나야 하는 최소 칸의 개수가 될 것이다.
		
		Queue<Point> queue = new LinkedList();
		queue.add(new Point(x,y));
		
		while (!queue.isEmpty()){
			Point now = queue.poll();
			//현재 위치에서 상하좌우 확인
			for (int i=0; i<4; i++){
				int nextX = now.x +dx[i];
				int nextY = now.y +dy[i];
				
				// 1<= x <=N, 1 <= y <=M 이 아닐 경우
				if(nextX <1 || nextX >N || nextY <1 || nextY >M){
					continue;
				}
				
				//이미 방문했거나, 길이 아닌 벽일 경우 ( 0 )
				if(isVisit[nextX][nextY] || map[nextX][nextY] ==0){
					continue;
				}
				
				queue.add(new Point(nextX, nextY));
				map[nextX][nextY] =map[now.x][now.y] +1;
				isVisit[nextX][nextY] = true;
			}
		}
	}

}

//정점(x ,y)를 표현하기 위한 클래스
	class Point {
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

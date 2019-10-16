package sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503 {

	static int N;
	static int M;
	static int r;
	static int c;
	static int d;
	static int [][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());	//N, M min, max 값 어떻게 지정할 지 모르겠음
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());	//줄 바뀔 때마다 이거 써줘야함
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++){		//청소할 공간 입력
			st = new StringTokenizer(br.readLine());	//줄 바뀔 때마다 이거 써줘야함
			for(int j=0; j<M; j++){
				
//				map = new int[i+1][j+1];
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = clean();	//청소 함수를 결과로 
		System.out.println(result);
		
		br.close();
	}
	
	static int[] dx = {0,1,0,-1};	// 북 동 남 서
	static int[] dy = {-1,0,1,0};	// 좌표 기준으로 이렇게 움직임
	
	public static int clean(){
		
		int cnt = 2; //1은 벽이므로 처음 청소하는 칸에 2부터 표기하고 시작
		int y = r;
		int x = c;
		int ny = y;
		int nx = x;
		int dir = d;	//현재 방향 넣어주기 
		
		while(true){
			if(map[y][x] == 0) map[y][x] = cnt++; //청소가 안된 곳은 청소해주기
			
			if(map[y][x-1] !=0 && map[y][x+1] != 0 && map[y-1][x] !=0 && map[y+1][x]  !=0){	//동서남북 모두 벽 or 청소한 상태일 경우 (1, 2)
				int ndir = (dir + 2) %4 ;	//나머지 구하기 , dx, dy의 값을 정함
											// d = 0 이면 2 북 - 남 
											// d = 1 이면 3 동 - 서
											// d = 2 면    0 남 - 북
											// d = 3 이면 1 서 - 동 
				// 동 서 남 북 모두 청소할 곳이 없으면 방향 과 반대되는 곳으로 후진 해야 되니깐
				// ex) 방향이 북일 때 남쪽 방향으로 한 칸 후진 해야한다 
				
				int rearX = x +dx[ndir];	// 방향을 북쪽을 보고 있으면 남쪽으로 후진 이니깐 x+1
				int rearY = y +dy[ndir];	//									y+0 해줘야 된다 
				
				if(map[rearY][rearX] !=1){	//뒷칸이 벽이 아니면 후진
					x = rearX;
					y = rearY;
					continue;
				}
				else break; //뒷칸이 벽이면 작동을 멈춘다 
			}
			dir--;	//왼쪽으로 회전
			if(dir < 0) dir =3;
			
			ny = y +dy[dir];		//회전한 다음 방향으로 좌표를 nx, ny에 저장해주고
			nx = x +dx[dir];
			
			if(map[ny][nx] ==0){ 	//이 좌표가 빈칸인 것을 확인하고 
									//빈칸인 경우 전진	
				x= nx;				// 빈칸이면 x y 값 바꿔준다 
				y =ny;
				continue;
			}
			else{
				//빈칸이 아닌 경우 좌방향으로 회전만 하고 2번으로 간다.
				continue;
			}
		}
		
			return cnt -2;	//cnt++ 돼있는 상태이므로, 1빼주고, 2부터 세기 시작했으므로 또 1 빼준다 

	}


}

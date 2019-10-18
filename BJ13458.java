package sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13458 {
   
   static int N ;      //시험장 수 
   static int A [] ;   // N개의 시험장에 있는 응시자수들
   static int B;   // 총감독관이 한 응시장에서 감시 할 수 있는 수 
   static int C;   // 부감독관이 한 응시장에서 감시 할 수 있는 수
   static int result = 0;   //최종 결과 값 
   static long cnt;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄
      
     
      N = Integer.parseInt(st.nextToken());	// 클래스 객체에서 다음 토큰을 읽음
      
      A = new int[N];
      
      
      st = new StringTokenizer(br.readLine());	// 두 번째줄
      											//이게 여기 있어야 밑에서 B C  입력 N 개수 만큼 안받는다 Why?????????????????
      											// readLine 으로 한 줄씩 읽어온다.
      for(int i=0; i<N; i++){
//    	  st = new StringTokenizer(br.readLine());	// 여기 있으면 안됨
    	  											//여기 있으면 두 번째 줄부터 N번째 줄까지가 됨
         A[i] = Integer.parseInt(st.nextToken());
         
         
         
         
      }
      	st = new StringTokenizer(br.readLine());
         B = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
      
      
      for(int i=0; i<N; i++) {
    	  int a = A[i];
    	  a-=B; //총 감독관은 무조건 한 명있음
    	  cnt ++;	//총 감독관 수 +1 해주는 것
    	  
    	  if(a>0) cnt+= Math.ceil((double)a/C); // 총감독관이 감시할 수 있는 수보다 , 응시자 수 가 클때 , 부 감독관 수 구하기 
    	  //Math.ceil() : 소수점 올림, 정수 반환
//										    	  Math.floor() : 소수점 버림, 정수 반환
//										    	  Math.round() : 소수점 반올림, 정수 반환
      }
      
      result = managerMin();
      System.out.println(cnt);
      System.out.println(result);
    
      
   }
   
   public static int managerMin(){      // 매니저 최소 값 구하기
      
    //  int headM = N;   //총 감독관 수는 시험장 수랑 같다
    //  int viceM ;      //부 감독관 수 구해서 최종 결과 구하기
      int D =0;
      int cnt =0;
      
      for(int i=0; i<N; i++){
    	 //int a = A[i];
         D = A[i]-B  ;
        cnt++;
         //총 감독관 수를ㄹ 안 더했다.
         
         
         if(D> 0){
            cnt+= Math.ceil((double)D/C);
         }
         
        
         //res += cnt;
      }
      //System.out.println(result);
      return cnt ;
   }
   

}

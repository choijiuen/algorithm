package sds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//톱니바퀴
public class BJ14891{

   static int[][] w;
   static int[] weight = {1, 2, 4, 8};
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      w = new int[4][8];
      for(int i=0; i<4; i++) { //입력
         String s = br.readLine();
         for(int j=0; j<8; j++) {
            w[i][j] = s.charAt(j)-'0';
         }
      }
      int turnN = Integer.parseInt(br.readLine());
      
      for(int n=0; n<turnN; n++) {
         boolean[] turn = {false, false, false, false}; //회전여부
         int[] turnD = {0, 0, 0, 0}; //회전방향
         
         String[] s = br.readLine().split(" ");
         int wn = Integer.parseInt(s[0])-1; //톱니번호
         int d = Integer.parseInt(s[1]);  //방향
         turn[wn] = true;
         turnD[wn] = d;
         //왼쪽 방향 톱니 회전
         for(int i=wn-1; i>=0; i--) {
            if(w[i][2]==w[i+1][6]) break;
            turn[i] = true;
            turnD[i] = turnD[i+1]*-1; //반대로 회전
         }
         //오른쪽 방향 톱니 회전
         for(int i=wn+1; i<4; i++) {
            if(w[i][6]==w[i-1][2]) break;
            turn[i] = true;
            turnD[i] = turnD[i-1]*-1; //반대로 회전
         }
         for(int i=0; i<4; i++) {
            if(turn[i]) {
               turn(i, turnD[i]);
            }
         }
      }
   
      int sum = 0;
      for(int i=0; i<4; i++) {
         sum += w[i][0]*weight[i];
      }
      System.out.println(sum);
   }
   static void turn(int wn, int d) {
      if(d==1) { //시계방향
         int temp = w[wn][7];
         for(int i=7; i>=1; i--) {
            w[wn][i] = w[wn][i-1];
         }
         w[wn][0] = temp;
      }else if(d==-1) { //반시계방향
         int temp = w[wn][0];
         for(int i=0; i<=6; i++) {
            w[wn][i] = w[wn][i+1];
         }
         w[wn][7] = temp;
      }
   }
}


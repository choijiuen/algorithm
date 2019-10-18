package sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13458 {
   
   static int N ;      //������ �� 
   static int A [] ;   // N���� �����忡 �ִ� �����ڼ���
   static int B;   // �Ѱ������� �� �����忡�� ���� �� �� �ִ� �� 
   static int C;   // �ΰ������� �� �����忡�� ���� �� �� �ִ� ��
   static int result = 0;   //���� ��� �� 
   static long cnt;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine()); // ù ��
      
     
      N = Integer.parseInt(st.nextToken());	// Ŭ���� ��ü���� ���� ��ū�� ����
      
      A = new int[N];
      
      
      st = new StringTokenizer(br.readLine());	// �� ��°��
      											//�̰� ���� �־�� �ؿ��� B C  �Է� N ���� ��ŭ �ȹ޴´� Why?????????????????
      											// readLine ���� �� �پ� �о�´�.
      for(int i=0; i<N; i++){
//    	  st = new StringTokenizer(br.readLine());	// ���� ������ �ȵ�
    	  											//���� ������ �� ��° �ٺ��� N��° �ٱ����� ��
         A[i] = Integer.parseInt(st.nextToken());
         
         
         
         
      }
      	st = new StringTokenizer(br.readLine());
         B = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
      
      
      for(int i=0; i<N; i++) {
    	  int a = A[i];
    	  a-=B; //�� �������� ������ �� ������
    	  cnt ++;	//�� ������ �� +1 ���ִ� ��
    	  
    	  if(a>0) cnt+= Math.ceil((double)a/C); // �Ѱ������� ������ �� �ִ� ������ , ������ �� �� Ŭ�� , �� ������ �� ���ϱ� 
    	  //Math.ceil() : �Ҽ��� �ø�, ���� ��ȯ
//										    	  Math.floor() : �Ҽ��� ����, ���� ��ȯ
//										    	  Math.round() : �Ҽ��� �ݿø�, ���� ��ȯ
      }
      
      result = managerMin();
      System.out.println(cnt);
      System.out.println(result);
    
      
   }
   
   public static int managerMin(){      // �Ŵ��� �ּ� �� ���ϱ�
      
    //  int headM = N;   //�� ������ ���� ������ ���� ����
    //  int viceM ;      //�� ������ �� ���ؼ� ���� ��� ���ϱ�
      int D =0;
      int cnt =0;
      
      for(int i=0; i<N; i++){
    	 //int a = A[i];
         D = A[i]-B  ;
        cnt++;
         //�� ������ ������ �� ���ߴ�.
         
         
         if(D> 0){
            cnt+= Math.ceil((double)D/C);
         }
         
        
         //res += cnt;
      }
      //System.out.println(result);
      return cnt ;
   }
   

}

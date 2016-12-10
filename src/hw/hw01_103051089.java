package hw;

import java.util.Scanner;
/*
 * Topic: 某間學校舉辦英文檢定測驗，若是學生通過該測驗，則能通過畢業門檻。老師準備的 英文測驗中分為三個項目當作考試，分別是聽力、閱讀、口說。每一個項目測驗滿分 皆為 100 分，總分為 300 分。想要通過測驗有兩種方式。方式一:若是三個項目分 數皆為 60 分以上 ( 包含 60 分 ) 即為通過測驗。方式二:若三個項目中有其中一 個項目分數未滿 60 分，但三個項目分數總合超過 220 分，也可算通過測驗。若三 個項目中有其中一個項目分數未滿 60 分，而三個項目分數總合也沒能超過 220 分，可獲得補考機會。若是三個項目中有兩個項目不及格，但另一個項目成績高於 80 分 ( 包含 80 分 ) ，也可獲得補考的機會。其餘皆判定為無法通過測驗。

 * Date: 2016/12/05
 * Author: 103051089 林冠磊
 */
public class hw01_103051089 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("幾組?");
		int manber = sc.nextInt();
		int[][] score = new int[manber][3];
		int i = 0;
		while(i<manber){
			System.out.print("No."+(i+1)+"\t");
			score[i][0] = sc.nextInt();
			score[i][1] = sc.nextInt();
			score[i][2] = sc.nextInt();
			if(score[i][0]>=0 && score[i][0]<=100){
				if(score[i][1]>=0 && score[i][1]<=100){
					if(score[i][2]>=0 && score[i][2]<=100){
						i++;
						continue;
					}
				}
			}
			System.out.println("Error");
		}
		
		for(int j = 0; j<score.length;j++){
			if(PassCounter(score, j,1)==0){
				System.out.println("P");
			}
			else if(NumCounter(score, j)>=220 && PassCounter(score, j,1)== 1){
				System.out.println("P");
			}
			else if(NumCounter(score, j)<220 && PassCounter(score, j,1)== 1){
				System.out.println("M");
			}
			else if (PassCounter(score, j,2)==1 && PassCounter(score, j,1)==2) {
				System.out.println("M");
			}
			else{
				System.out.println("F");
			}
			//System.out.println("No."+(j+1)+"\t"+score[j][0]+"\t"+score[j][1]+"\t"+score[j][2]);
		}
	}
	static int NumCounter(int[][] a , int num){
		int out =0 ;
		for(int i = 0; i<a[num].length;i++){
			out+=a[num][i];
		}
		return out;
	}
	static int PassCounter(int[][] a , int num,int mode){
		int chk = 0;
		if(mode==1){
			for(int i = 0; i<a[num].length;i++){
				if(a[num][i]<60){
					chk++;
				}
			}
		}else if(mode==2){
			for(int i = 0; i<a[num].length;i++){
				if(a[num][i]>=80){
					chk++;
				}
			}					
		}
		return chk;
	}

}

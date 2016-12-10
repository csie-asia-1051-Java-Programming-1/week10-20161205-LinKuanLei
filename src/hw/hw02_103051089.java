package hw;

import java.util.Scanner;

/*
 * Topic: 有一種坊間常見的遊戲稱為 "18 啦 "~ 玩法介紹 : 由四個骰子來擲，只要其中任兩 個是相同點，才開始計算點數，點數即為另兩個點數相加，若另兩個也一樣，則取較 大的一組相加，另外有下列幾種特殊情況:
擲出 4 顆骰子點數均相同，稱為通殺 !
任三顆點數相同或四顆點數均不相同，即為無意義 ! 請寫一程式，各別輸入四顆骰子點數，判斷結果 !

 * Date: 2016/12/05
 * Author: 103051089 林冠磊
 */
public class hw02_103051089 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int [] num = new int[4];
		for(int i = 0 ; i<num.length; i++){
			num[i] = sc.nextInt();
		}		
		int check = 0;
		int max = 0;
		for(int i = 0 ; i<num.length;i++){
			for(int j = i ; j<num.length;j++){
				if(i!=j){
					if(num[i]==num[j]){
						max=num[i];
						check++;
					}
				}
			}
		}
		if(check==6){
			System.out.println("通殺"+(max*4));
		}
		else if(check==1 || check==2){
			System.out.println("18拉"+(max*2));
		}
		else if(check==3){
			System.out.println("無意義 ! ");
		}
		else if(check==0){
			System.out.println("R");
		}
	}
}

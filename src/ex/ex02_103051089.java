package ex;
/*
 * Topic: 輸入所使用的度數，換算夏月及非夏月之電費金額。
 * Date: 2016/12/05
 * Author: 103051089 林冠磊
 */
import java.util.Scanner;
public class ex02_103051089 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		float summer = 0, winter = 0, temp = num;
		if(num>700){
			temp-=700;
			num -= temp;
			summer += temp*5.63;
			winter += temp*4.50;
			temp = num;
		}
		if(num>500 && num <701){
			temp-=500;
			num -= temp;
			summer += temp*4.97;
			winter += temp*4.01;
			temp = num;
		}
		if(num>330 && num <501){
			temp-=330;
			num -= temp;
			summer += temp*4.39;
			winter += temp*3.61;
			temp = num;
		}
		if(num>120 && num <331){
			temp-=120;
			num -= temp;
			summer += temp*3.02;
			winter += temp*2.68;
			temp = num;
		}
		if(num <121){
			summer += temp*2.10;
			winter += temp*2.10;
			temp = num;
		}
		System.out.println(summer);
		System.out.println(winter);
	}

}

package hw;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Topic: 設計一個 Student 的類別(學號, 姓名, 英文成績, 數學成績, 國文成績)，使用者可以連續輸入多筆同學資料，程式需滿足下列要求
成績輸入必須檢查是否在 0~100之間，如果錯誤要請使用者重新輸入
加入資料後要顯示目前有哪些人在資料串裡
資料串的資料須使用插入排序法依每同學的平均分數由大到小排序

 * Date: 2016/12/05
 * Author: 103051089 林冠磊
 */
public class hw03_103051089 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> perList = new ArrayList<Student>();
		
		char chk;
		boolean sw =true;
		while(sw){
			System.out.println("(ID,姓名,英文成績,數學成績,國文成績)");
			String ID = sc.next();
			String name = sc.next();			
			int engSorce = sc.nextInt();
			int mathSorce = sc.nextInt();
			int chnSorce = sc.nextInt();
			while(true){
				if(engSorce >=0 && engSorce <= 100){
					break;
				}else{
					System.out.println("英文成績錯誤...");
					engSorce =  sc.nextInt();
				}
			}
			while(true){
				if(mathSorce >=0 && mathSorce <= 100){
					break;
				}else{
					System.out.println("數學成績錯誤...");
					mathSorce = sc.nextInt();
				}
			}
			while(true){
				if(chnSorce >=0 && chnSorce <= 100){
					break;
				}else{
					System.out.println("國文成績錯誤...");
					chnSorce = sc.nextInt();
				}
			}
			Student tmp = new Student(ID,name,engSorce,mathSorce,chnSorce);
			
			if(perList.size()==0)
			{
				perList.add(tmp);
			}
			else if(perList.size()==1)
			{
				if(perList.get(0).getAVG()<tmp.getAVG())
				{
					perList.add(0,tmp);
				}
				else
				{
					perList.add(tmp);
				}
			}
			else
			{
				boolean flog = true;
				for(int i=0;i<perList.size()-1 && flog;i++){
					if(i==0 && tmp.getAVG() > perList.get(i).getAVG())
					{
						perList.add(0,tmp);
						flog = false;
					}
					else
					{
						if(tmp.getAVG() < perList.get(i).getAVG() && tmp.getAVG() >= perList.get(i+1).getAVG())
						{
							perList.add(i+1,tmp);
							flog = false;
						}else if(perList.get(perList.size()-1).getAVG() > tmp.getAVG()){
							perList.add(tmp);
							flog = false;
						}
						
					}
				}
			}
			showPerson(perList);
			
			System.out.println("continue?");
			chk =sc.next().charAt(0) ;
			if(chk=='N' || chk== 'n' ){
				sw=false;
				System.out.println("bye");
			}
		}
	}

	private static void showPerson(ArrayList<Student> list1){
		for(int i =0;i<list1.size();i++){
			Student tmp = (Student) list1.get(i);
			tmp.ShowInfo();
		}
	}

}

class Student{
	private String name, ID;
	private int engScore , chnScoret , mathScore;
	public Student(String ID1, String name1 , int engScore1 , int mathScore1 , int chnScoret1){
		name = name1;
		ID = ID1;
		engScore = engScore1;
		chnScoret = chnScoret1;
		mathScore = mathScore1;
	}

	public double getAVG(){
		return (engScore+chnScoret+mathScore)/3;
	}

	public void ShowInfo(){
		System.out.println(name+"("+ID+")\t\t"+engScore+"\t"+mathScore+"\t"+chnScoret+"\t"+getAVG());
	}
}

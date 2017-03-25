import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeSystems {
	
	String sample;
	public int weightOfLab1;
	public int weightOfLab2;
	public int weightOfLab3;
	public int weightOfMidExam;
	public int weightOfFinalExam;
	private int newWeightOfLab1;
	private int newWeightOfLab2;
	private int newWeightOfLab3;
	private int newWeightOfMidExam;
	private int newWeightOfFinalExam;
	List<Grades> aList ;
	Grades allStudentAverage;
	
	public GradeSystems(){
		int num = 0;
		aList  = new ArrayList<>();
		sample = "123456";
		weightOfLab1 = 10;
		weightOfLab2 = 10;
		weightOfLab3 = 10;
		weightOfMidExam = 30;
		weightOfFinalExam = 40;
		FileReader fr;
		try {
			fr = new FileReader("C:/Users/承佑/workspace/Grade System/gradeinput"); //絕對路徑!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("讀檔錯誤!!!");
			return;
		} 
		
        BufferedReader br = new BufferedReader(fr);
        String inputData;
        String[] tempArray= new String[7];
        
        try {
			while((inputData = br.readLine())!=null){
				tempArray = inputData.split("\\s");
				Grades aGrade = new Grades(tempArray[0], tempArray[1], tempArray[2],
						tempArray[3], tempArray[4], tempArray[5], tempArray[6], num);
				aGrade.calculateTotalGrade(weightOfLab1, weightOfLab2, weightOfLab3, weightOfMidExam, weightOfFinalExam);
				aList.add(aGrade);
				num++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("讀行錯誤!!!");
			return;
		}
        
        allStudentAverage = new Grades("00000000", "全班平均", allAverage(0), allAverage(1), 
        		allAverage(2), allAverage(3), allAverage(4), 0);

	}
	
	public String allAverage(int index){
		float total = 0;
		for (int i=0; i<aList.size(); i++) {
			total = total + (float)aList.get(i).getScore(index);
        }
		return Integer.toString((int)Math.round(total / aList.size()));
	}
	
	public int containsID(String studentID){
		
		for (int i=0; i<aList.size(); i++) {
			if(studentID.equals(aList.get(i).getID())) return i;
        }
		
		return -1;
	}
	
	public void showGrade(int index){
		System.out.println(aList.get(index).getName() + " 成績:\t\tlab1 :\t\t" + aList.get(index).getlab1());
		System.out.println("\t\tlab2 :\t\t" + aList.get(index).getlab2());
		System.out.println("\t\tlab3 :\t\t" + aList.get(index).getlab3());
		System.out.println("\t\tmid-term :\t" + aList.get(index).getmidTerm());
		System.out.println("\t\tfinal exam :\t" + aList.get(index).getfinalExam());
		System.out.println("\t\ttotal grade :\t" + aList.get(index).gettotalGrade());
		return;
	}
	
	public void showRank(int index){
		int rank = 1;
		for (int i=0; i<aList.size(); i++) {
			if(aList.get(i).gettotalGrade() > aList.get(index).gettotalGrade()) rank++;
        }
		
		System.out.println(aList.get(index).getName() + " 排名第 " + rank);
	}
	
	public void showAverage(){
		System.out.println("全班平均:\t\tlab1 :\t\t" + allStudentAverage.getlab1());
		System.out.println("\t\tlab2 :\t\t"+ allStudentAverage.getlab2());
		System.out.println("\t\tlab3 :\t\t"+ allStudentAverage.getlab3());
		System.out.println("\t\tmid-term :\t"+ allStudentAverage.getmidTerm());
		System.out.println("\t\tfinal exam :\t"+ allStudentAverage.getfinalExam());
	}
	
	public void updateWeights(){
		int flag = 0;
		String checkYorN = "N";
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		showOldWeights();
		while(checkYorN.equals("Y") == false){
			if(flag != 0) System.out.println("請重新輸入新配分");
			else System.out.println("請輸入新配分");
			flag = 1;
			getNewWeights();
			setWeights();
			showNewWeights();
			checkYorN = scanner.nextLine();
		}
		for (int i=0; i<aList.size(); i++) {
			aList.get(i).calculateTotalGrade(weightOfLab1, weightOfLab2, weightOfLab3, weightOfMidExam, weightOfFinalExam);
        }
		
		
	}
	
	private void showOldWeights(){
		System.out.println("舊配分:");
		System.out.println("\tlab1:\t\t" + weightOfLab1 + "%");
		System.out.println("\tlab2:\t\t" + weightOfLab2 + "%");
		System.out.println("\tlab3:\t\t" + weightOfLab3 + "%");
		System.out.println("\tmid exam:\t" + weightOfMidExam + "%");
		System.out.println("\tfinal exam\t" + weightOfFinalExam + "%");
	}
	
	private void showNewWeights(){
		System.out.println("請確認新配分");
		System.out.println("\tlab1:\t\t" + newWeightOfLab1 + "%");
		System.out.println("\tlab2:\t\t" + newWeightOfLab2 + "%");
		System.out.println("\tlab3:\t\t" + newWeightOfLab3 + "%");
		System.out.println("\tmid exam:\t" + newWeightOfMidExam + "%");
		System.out.println("\tfinal exam\t" + newWeightOfFinalExam + "%");
		System.out.println("以上正確嗎? Y (Yes) 或 N (No)");
		System.out.println("使用者輸入：");
	}
	
	private void getNewWeights(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("lab1:");
		newWeightOfLab1 = Integer.parseInt(scanner.nextLine());
		System.out.println("lab2:");
		newWeightOfLab2 = Integer.parseInt(scanner.nextLine());
		System.out.println("lab3:");
		newWeightOfLab3 = Integer.parseInt(scanner.nextLine());
		System.out.println("mid-term:");
		newWeightOfMidExam = Integer.parseInt(scanner.nextLine());
		System.out.println("final exam:");
		newWeightOfFinalExam = Integer.parseInt(scanner.nextLine());
	}
	
	private void setWeights(){
		weightOfLab1 = newWeightOfLab1;
		weightOfLab2 = newWeightOfLab2;
		weightOfLab3 = newWeightOfLab3;
		weightOfMidExam = newWeightOfMidExam;
		weightOfFinalExam = newWeightOfFinalExam;
	}
}

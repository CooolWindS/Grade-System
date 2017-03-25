
public class Grades {
	public int index;
	private String ID;
	private String name;
	private int[] score;
	private int totalGrade;
	
	public Grades(String inputID, String inputname, String inputlab1, String inputlab2,
			String inputlab3, String inputmidTerm, String inputfinalExam, int num){
		score = new int[5];
		ID = inputID;
		name = inputname;
		score[0] = Integer.parseInt(inputlab1);
		score[1] = Integer.parseInt(inputlab2);
		score[2] = Integer.parseInt(inputlab3);
		score[3] = Integer.parseInt(inputmidTerm);
		score[4] = Integer.parseInt(inputfinalExam);
		index = num;
		totalGrade = 0;
		
	}
	
	public void calculateTotalGrade(int weightOfLab1, int weightOfLab2, int weightOfLab3, int weightOfMidExam, int weightOfFinalExam){
		totalGrade = (int)Math.round((double)(weightOfLab1*score[0] + weightOfLab2*score[1] + weightOfLab3*score[2] 
				+ weightOfMidExam*score[3] + weightOfFinalExam*score[4])/100);
	}
	
	public String getName(){
		return name;
	}
	
	public String getID(){
		return ID;
	}
	
	public int getScore(int index){
		return score[index];
	}
	
	public int getlab1(){
		return score[0];
	}
	
	public int getlab2(){
		return score[1];
	}
	
	public int getlab3(){
		return score[2];
	}
	
	public int getmidTerm(){
		return score[3];
	}
	
	public int getfinalExam(){
		return score[4];
	}
	
	public int gettotalGrade(){
		return totalGrade;
	}
	
}

import java.util.Scanner;

public class UI {
	private String leaveOrStudentID;
	private int numberOfStudent;
	private GradeSystems aGradeSystem;
	
	public UI(){
		aGradeSystem = new GradeSystems();
	}
	
	public void Start() throws NoSuchIDExceptions, NoSuchCommandExceptions{
		
		try{
			promptID();
			
			while(leaveOrStudentID.equals("Q") == false){
				numberOfStudent = checkID();
				if(numberOfStudent != -1){
					showWelcomeMsg();
					promptCommand();
				}
				else{
					throw new NoSuchIDExceptions();
				}
				promptID();
			}
			showFinishMsg();
		}
		finally{}
	}
	
	private void promptID(){
		System.out.println("輸入ID或 Q (結束使用)？");
		System.out.println("使用者輸入：");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		leaveOrStudentID = scanner.nextLine();
	}
	
	private int checkID(){
		return aGradeSystem.containsID(leaveOrStudentID);
	}
	
	private void promptCommand () throws NoSuchCommandExceptions{
		String actionOfUser;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			showCommandMsg();
			actionOfUser = scanner.nextLine();
			
			switch (actionOfUser) {
				case "E" :
					return;
				case "G" :
					aGradeSystem.showGrade(numberOfStudent);
					break;
				case "R" :
					aGradeSystem.showRank(numberOfStudent);
					break;
				case "A" :
					aGradeSystem.showAverage();
					break;
				case "W" :
					aGradeSystem.updateWeights();
					break;
				default :
					throw new NoSuchCommandExceptions();
			}
		}
	}
	
	private void showFinishMsg(){
		System.out.println("結束了");
	}
	
	private void showWelcomeMsg(){
		System.out.println("Welcome " + aGradeSystem.aList.get(numberOfStudent).getName());
	}
	
	private void showCommandMsg(){
		System.out.println("\n輸入指令 \t1) G 顯示成績 (Grade)");
		System.out.println("\t2) R 顯示排名 (Rank)");
		System.out.println("\t3) A 顯示平均 (Average)");
		System.out.println("\t4) W 更新配分 (Weight)");
		System.out.println("\t5) E 離開選單 (Exit)");
		System.out.println("使用者輸入：");
		
	}
}

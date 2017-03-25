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
		System.out.println("��JID�� Q (�����ϥ�)�H");
		System.out.println("�ϥΪ̿�J�G");
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
		System.out.println("�����F");
	}
	
	private void showWelcomeMsg(){
		System.out.println("Welcome " + aGradeSystem.aList.get(numberOfStudent).getName());
	}
	
	private void showCommandMsg(){
		System.out.println("\n��J���O \t1) G ��ܦ��Z (Grade)");
		System.out.println("\t2) R ��ܱƦW (Rank)");
		System.out.println("\t3) A ��ܥ��� (Average)");
		System.out.println("\t4) W ��s�t�� (Weight)");
		System.out.println("\t5) E ���}��� (Exit)");
		System.out.println("�ϥΪ̿�J�G");
		
	}
}

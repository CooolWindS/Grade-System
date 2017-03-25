
public class Main extends Object{

	public static void main(String[] args) throws NoSuchCommandExceptions {
		// TODO Auto-generated method stub
		
		UI myUI = new UI();
		
		try{
			myUI.Start();
		}
		catch(NoSuchIDExceptions ex){
			System.out.println("ID¿ù¤F!");
			return;
		}
		catch(NoSuchCommandExceptions ex){
			System.out.println("«ü¥O¿ù¤F!");
			return;
		}

	}

}

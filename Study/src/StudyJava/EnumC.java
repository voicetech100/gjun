package StudyJava;

import javax.swing.JOptionPane;

class EnumC{

	public enum AlphabetC {
		Success,Fail,Pending;
	}

	public void methodA(AlphabetC a) {

		switch (a) {
		case Success:
			System.out.println("Success");
			break;
		case Fail:
			System.out.println("Fail");
			break;
		case Pending:
			System.out.println("Pending");
			break;
			}
	}

	public static void main(String[] args){
		//java.util.Scanner scanner= new java.util.Scanner(System.in);
		//String s = scanner.nextLine();
		//在main方法中從黑窗（Scanner）讀取進來的是String,String與Enum是不同的型態，不能直接混用,使用AlphabetC.valueOf(s)將字串轉為列舉物件
		String s = JOptionPane.showInputDialog("請輸入你的名字：");
		AlphabetC currentStatus = AlphabetC.valueOf(s);
		new EnumC().methodA(currentStatus);
	}
	
}
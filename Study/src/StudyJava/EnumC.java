package StudyJava;

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
		new EnumC().methodA(AlphabetC.Success);
	}
	
}
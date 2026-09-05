package StudyJava;

interface iii {
	String a ="a";
	int b = 1;   //can not be final
	public void c();
}

public class InterfaceA implements iii{
	
	public void c(){
		System.out.println("C");
	};
	
	public static void main (String[] args) {
		System.out.println("B");
	}
	
	public void d() { //can not be abstract
		System.out.println("A");
	}
	
	
}
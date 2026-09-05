package StudyJava;

public class ObjectA {

	public void process(byte x) {
		System.out.println("byte\t" + x);
	}
	
	public void process(short x) {
		System.out.println("Short\t" + x);
	}
	
	public void process(Object x) {
		System.out.println("Object\t" + x);
	}
		
	public static void main(String[] args) {
		byte x=12;
		short y=13;
		new ObjectA().process(x+y);   //Object can not add
	}

}

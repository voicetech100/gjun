package StudyJava;

interface A {
	int x =5;
}
class B {
	int x=8;
	public String y() {
		return "B";
	}
}
class FinalA extends B  implements A { //extends => only One
	int x=10;
	public String y() {
		return "FinalA";
	}
	public static void main(String[] args) {
		A a= new FinalA();
		int j = a.x;  //5 多行取父值
		System.out.println(j);
		
		B b = new FinalA();
		int i = b.x;  //=8 多行取父值
		String s1=b.y(); //Override
		System.out.println(i);
		System.out.println(s1);
	
		FinalA c = new FinalA();
		int k = c.x;  //=10 一般new取本值
		String s2=c.y(); //New誰就找誰
		System.out.println(k);
		System.out.println(s2);

		B d = new B();
		String s3=d.y(); //New誰就找誰
		System.out.println(s3);
	
	}
}

//「變數看父類、方法看覆寫（Override）」是在使用「多型（Polymorphism）」宣告變數時才成立的規則。
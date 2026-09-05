package StudyJava;
public class StringBuilderA {
	public static void main (String[] args) {
		StringBuilder Str=new StringBuilder();  //（Capacity）寫()即可,length根據傳入值
		Str.append("ABC1234567890");
		System.out.println(Str);
		System.out.println(Str.length());
	}
}

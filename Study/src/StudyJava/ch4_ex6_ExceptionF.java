package StudyJava;

import java.util.Optional;
public class ch4_ex6_ExceptionF {
	public static void main(String[] args) {
		System.out.println("Ans: "+convert("A").get());	 //再度爆炸回到main方法後，第6行對這個空的Optional呼叫了.get()。Java 的 Optional 如果裡面沒東西卻硬要 .get()，會直接拋出 NoSuchElementException 讓主程式再次崩潰。
		} //6行發生的NoSuchElementException，是由Java內建的機制直接拋出，且在這個程式中「沒有人去抓（catch）」的。
	private static Optional<Integer> convert(String s) {
		try{
			return Optional.of(Integer.parseInt(s));		
		} catch(Exception e) {
			System.out.println("A");
			//e.printStackTrace();
			return Optional.empty();//這裡有處理,return空,出現Exception是convert(A)=>沒有這個值
			
		}	
	}
	
}




/*
	Given:

	public class Option{
		public static void main(String[] args) {
			System.out.println("Ans: "+convert("a").get());	
		}
		
		private static Optional<Integer> convert(String s) {
			try{
				return Optional.of(Integer.parseInt(s));		
			} catch(Exception e) {
				return Optional.empty();
			}	
		}
	}

	What is the result?

	A) Ans:
	B) Ans: a
	C) A java.util.NoSuchFilementException is thrown at run time
	D) The compilation fails


	ans:C


	*/
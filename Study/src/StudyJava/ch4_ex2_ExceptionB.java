package StudyJava;

import java.io.IOException;

public class ch4_ex2_ExceptionB {
	
	final static class FallenException extends Exception{}
	final static class HikingGear implements AutoCloseable{
		@Override 
		public void close() throws Exception{
			System.out.println("D");
			throw new FallenException();  //拋出FallenException，但因為它是次要例外，會被**壓制（Suppressed）**在 RuntimeException 裡面，不會打斷 RuntimeException 的傳遞。
		}
	}
	
	public static class Cliff{
		public final void climb() throws Exception{
			try(HikingGear gear=new HikingGear();){
				System.out.println("A");
				throw new RuntimeException(); //拋出主要例外，此時try區塊中斷，準備離開。=>使用try-with-resource自動觸發close()：在離開try之前，Java自動呼叫gear.close()
			}	
			//********************************
			//catch (Exception e) {
			//	System.out.println("MyTest");
			//}
			//********************************
		}
		
		public static void main(String... rocks){
			try{
				new Cliff().climb();
				System.out.println("B");
			}catch(Throwable t){  //回到main的catch：因為發生了例外
				System.out.println("C");
				System.out.println(t); //e1
			}	
		}
	}
	
}



/*
 * 因為 try-with-resources 的特別機制。
 * 傳統的 try-finally 寫法，在 finally 裡關閉資源若拋出例外會發生「覆蓋」——主程式真正的錯誤會直接不見。
 * 為了避免這個問題，Java官方在推出try-with-resources時，制定了特別的保護機制：主例外優先：try 區塊內拋出的例外（如 RuntimeException）被視為最核心的事故現場，必須被保留。自動關閉產生的錯誤改用「壓制（Suppressed）」：
 * 因為關閉資源（close()）是Java自動幫你觸發的，如果在關閉時又爆炸（如 FallenException），Java會認為這是次要的衍生問題。
 * 兩者並存：它不會去蓋掉主例外，而是默默地把這個次要例外塞進主例外的肚子裡（也就是圖片中提到的 Suppressed 機制）。
 */










/*
Given the following application, what is the name of the class printed at line e1?

package canyon;
final class FallenException extends Exception{}
final class HikingGear implements AutoCloseable{
	@Override 
	public void close() throws Exception{
		throw new FallenException();
	}
}

public class Cliff{
	public final void climb() throws Exception{
		try(HikingGear gear=new HikingGear()){
			throw new RuntimeException();
		}	
	}
	public static void main(String... rocks){
		try{
			new Cliff().climb();		
		}catch(Throwable t){
			System.out.println(t); //e1
		}	
	}
}


A. canyon.fallenException
B. java.lang.RuntimeException
C. The code does not compile.
D. The code compile, but the answer cannot be determined until runtime.
E. None of the above


ans:B


*/
	
	
	
	
	
	
	
	











/*
Given the following application, which specific type of exception will be printed in the stack trace at runtime?

package carnival;
public class WhackAnException{
	public static void main(String... hammer)
	{
		try{
			throw new ClassCastException();
		}catch(IllegalArgumentException e){
			throw new IlleaglArgumentException();
		}catch(RuntimeException e){
			throw new NullPointerException();
		}finally{
			throw new RuntimeException();
		}
	
	}

}

A. ClassCastException
B. IllegalArgumentException
C. NullPointerException
D. RuntimeException
E. The code does not compile.
F. None of the above

*/
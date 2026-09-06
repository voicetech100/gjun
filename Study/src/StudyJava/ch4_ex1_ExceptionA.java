package StudyJava;

public class ch4_ex1_ExceptionA {

	public static void main(String[] args) {
		try {
			System.out.println("A");
			throw new ClassCastException();
		} catch (IllegalArgumentException e){  //不符合，跳過。
			System.out.println("B");
			throw new IllegalArgumentException(); 
		} catch (RuntimeException e){ //符合！（因為 ClassCastException 是 RuntimeException 的子類別）。
			System.out.println("C");
			throw new NullPointerException();
			//執行throw new NullPointerException();。此時舊的例外被覆蓋，準備丟出一個全新的 NullPointerException。
		}finally{  //finally 一定會執行
			System.out.println("D");
			throw new RuntimeException();  //離開main方法前，執行了throw new RuntimeException();在finally區塊中使用throw拋出新例外它會直接覆蓋之前在try或catch 裡面產生的所有例外。
		}

	}

}

//java的規則是：同一個執行緒（Thread）在同一時間只能拋出一個例外。 當程式在不同階段都拋出例外時，最後被執行的那行 throw 就會成為最終的勝利者，前面的例外都會被無情地蓋掉。
//如果是在不同的執行緒（Thread），情況就不同：它們不會互相覆蓋，而是會各自獨立拋出、各自印出自己的 Stack Trace（錯誤軌跡）！
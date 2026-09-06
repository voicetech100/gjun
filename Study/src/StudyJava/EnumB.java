package StudyJava;

public class EnumB {

	enum AlphabetB{
		
		Success,Fail,Pending;
		public String getX(){
			return this.name();
			}
	}
	
	
	public static void main (String[] args) {

		//System.out.println(AlphabetB.Success); 
		//System.out.println(AlphabetB.Fail.getX()); // 這會印出 "Fail"
		//System.out.println(AlphabetB.values()[1]); 
		
		// 1. 修正：正確指定列舉的其中一個狀態
		AlphabetB myLetter = AlphabetB.Fail;
		// 2. 修正：switch的case必須符合定義好的狀態（Success, Fail, Pending）
		switch (myLetter) {
		    case Success:
		        System.out.println("執行 Success 的邏輯");
		        break;
		    case Fail:
		        System.out.println("執行 Fail 的邏輯");
		        break;
		    case Pending:
		        System.out.println("執行 Pending 的邏輯");
		        break;
		}
		
		
		
		String x = "Success";
		if (x.equals("Success")){System.out.println("Success0");};
		
		if (x.equals(AlphabetB.Success)) {System.out.println("Success1");} //「型態不同」：x 的型態是 String（字串），而 AlphabetB.Success 的型態是 AlphabetB（列舉常數）。Java 的 equals() 機制：當你拿一個 String 去跟一個 Enum 比較時，Java 在底層會直接發現「這兩者的品種不一樣」，因此直接回傳 false，它連裡面的字串內容都不會去比。
		if (x.equals(AlphabetB.Success.name())) {System.out.println("Success2");}//拿一個 String 變數去跟 Enum 做比較，你必須把 Enum 轉換成字串。有以下兩種寫法：寫法一：使用 name() 或 toString()（最推薦）
		
		AlphabetB a = AlphabetB.Success; //儘量避免把字串和Enum混用。如果一個變數代表的是狀態，那就讓它從頭到尾都是 AlphabetB 型態
		if (a.equals(AlphabetB.Success)) {System.out.println("Success3");}
		
	}

	//使用Enum
	//編譯器直接抓。拼錯字會直接跳紅叉，連編譯都過不了，完全不可能帶進執行期。
	//嚴格限制。參數型態定為 AlphabetB，外部就只能從那三個選一個傳進來，其他亂傳直接報錯。
	//有智慧提示。打出一個點 .，IDE 就會自動跳出所有選單讓你選，不需要死記。
	
	// if (status.equals("Success")) { ... } // 因為上面拼錯，這裡永遠不會執行
	// 這裡百分之百保證 status 只有可能是 Success、Fail 或 Pending 之一
    // if (status == AlphabetB.Success) { ... } ,編輯時就會出現錯誤

}

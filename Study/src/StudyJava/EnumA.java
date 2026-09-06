package StudyJava;

public class EnumA {

    enum Alphabet {
    	
        A(1,"Truck1"), B(2,"Truck2"), C(3,"Truck3");  //在「呼叫建構式」來建立列舉的實例（物件）.

        int x;
        String y;
        
        private Alphabet (int x,String y) {
        	this.x=x;
        	this.y=y;
        }
    	
        public void setX(int x) {
        	this.x = x;
        }
        public int getX() {
    		return x;
    	}
    	
    	public void setY(String y) {
    		this.y=y;
    	}
    	public String getY() {
    		return y;
    	}
    	
    }

    public static void main(String[] args) {
        System.out.println(Alphabet.A.getX());
        for(Alphabet o:Alphabet.values()) {
        	System.out.println(o+"\t"+o.getX()+"\t"+o.getY());
        }
    }
    
}


//一般類別 (Class)：目的是為了讓外部程式能根據需求，無限次、隨時建立新的物件（例如：new Student()、new Car()）。因此需要 public 權限。
//列舉 (Enum)：目的是為了定義一組固定且有限的常數（例如：圖片中的 A, B, C 或者是星期一到星期日）。因為這些實例在程式編譯時就已經固定了，絕對不允許外部在執行時又偷偷 new 出一個新的常數，所以 Java 強制規定其建構子必須是 private。

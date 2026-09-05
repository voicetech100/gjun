package StudyJava;

public class EnumA {

    enum Alphabet {
        A("Truck"), B("Truck"), C("Truck"); // 💡 修正關鍵：這裡必須加上分號

        
    	
    	
    	
    	
    	static String getFitstLitter() {
            //return A.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(Alphabet.getFitstLitter());
    }
    
}
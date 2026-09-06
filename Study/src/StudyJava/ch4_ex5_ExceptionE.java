package StudyJava;
import java.io.FileNotFoundException;


class ExSuper extends Exception{
	private final int eCode;
	public ExSuper(int eCode,Throwable cause){
		super(cause);
		this.eCode=eCode;
	}
	
	public ExSuper(int eCode,String msg,Throwable cause){
		super(msg,cause);
		this.eCode=eCode;	
	}
	
	public String getMessage(){
		return this.eCode+": "+super.getMessage()+"_"+this.getCause().getMessage();	
	}
}


class ExSub extends ExSuper{
	public ExSub(int eCode,String msg,Throwable cause)
	{
		super(eCode,msg,cause);
	}	
}


public class ch4_ex5_ExceptionE {

	public static void main(String[] args) {
		try{
			String param1="oracle";
			if(param1.equalsIgnoreCase("oracle")) {
				System.out.println("A");
				throw new ExSub(9001, "APPLICATION ERROR-9001",new FileNotFoundException("MyFile.txt"));	
				}
			System.out.println("B");	
			throw new ExSuper(9001, new FileNotFoundException("MyFile.txt")); // Line 1
		}
		catch(ExSuper ex)
		{
			System.out.println("C");
			System.out.println(ex.getMessage());
		}
	
	}
}










/*
Given:

public class ExSuper extends Exception{
	private final int eCode;
	public ExSuper(int eCode,Throwable cause){
		super(cause);
		this.eCode=eCode;
	}
	
	public ExSuper(int eCode,String msg,Throwable cause){
		super(msg,cause);
		this.eCode=eCode;	
	}
	
	public String getMessage(){
		return this.eCode+": "+super.getMessage()+"_"+this.getCause().getMessage();	
	}
}
	
public class ExSub extends ExSuper{
	public ExSub(int eCode,String msg,Throwable cause)
	{
		super(eCode,msg,cause);
	}	
}

and the code fragment:

try{
	String param1="oracle";
	if(param1.equalsIgnoreCase("oracle")) {
		throw new ExSub(9001, "APPLICATION ERROR-9001",new FileNotFoundException("MyFile.txt"));	
		}
		throw new ExSuper(9001, new FileNotFoundException("MyFile.txt")); // Line 1
}
catch(ExSuper ex)
{
	System.out.println(ex.getMessage());
}

}
*/
package StudyJava;

import java.io.FileNotFoundException;

public class ch4_ex3_ExceptionC {
			
	public static void main(String[] args){
		try{
			System.out.println("A");
			doA();
		}//line 1
		catch(Exception e){System.out.println("C");} //要找父Exception
	}
	
	private static void doA() throws Exception,IndexOutOfBoundsException{
		//if(false){
		//	throw new FileNotFoundException();
		//} else {
			System.out.println("B");
			throw new IndexOutOfBoundsException();
		//}
	}

}
			
			
			

	
	
	
	/*
	Given:

	import java.io.FileNotFoundException;
	import java.io.IOException;

	public class Tester{
		public static void main(String[] args){
			try{
				doA();
			}//line 1
		}
		private static void doA() throws Exception,IndexOutOfBoundsException{
			if(false){
				throw new FileNotFoundException();
			}else{
				throw now IndexOutOfBoundsException();
			}
		}
	}

	What must be added in line 1 to compile this class?

	A) catch(FileNotFoundException | Exception e){}
	B) catch(FileNotFoundException e){}
	   catch(IndexOutOfBoundsException e){}
	C) catch(Exception e){}
	D) catch(IndexOutOfBoundsEexception e){}
	   catch(FileNotFoundException e){}

	E) catch(FileNotFoundException | IndexOutBoundException e){}


	ans:C


	*/

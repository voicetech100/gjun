package StudyJava;
	
	class Person{
		private String name;
		private Person child;
		public Person(String name,Person child)
		{
			this(name);
			this.child=child;
		}
		public Person(String name){
			this.name=name;
		}
		public String toString(){
			return name+" "+child;
		}	
	}
	
	
	class Tester{
		public static Person createPeople(){
			Person jane=new Person("Jane");
			Person john=new Person("John",jane);  //John沒有return
			System.out.println("C");  
			return jane;  // 只return jane
		}
		public static Person createPerson(Person person){
			person=new Person("Jack",person);
			return person;
		}
	}
	
	
	public class ch3_ex15_  {
		public static void main(String[] args) {
			System.out.println("A");
			Person person=new Tester().createPeople();
			// line 1
			System.out.println("B");
			person=new Tester().createPerson(person); // jane又被傳送一次
			// line 2
			String name=person.toString();
			System.out.println(name);
		}
	}


	
	
	/*
	Given:

	public class Person{
		private String name;
		private Person child;
		public Person(String name,Person child)
		{
			this(name);
			this.child=child;
		}
		public Person(String name){
			this.name=name;
		}
		public String toString(){
			return name+" "+child;
		}	

	}

	and

	public class Tester{
		public static Person createPeople(){
			Person jane=new Person("Jane");
			Person john=new Person("John",jane);
			return jane;
		}
		
		public static Person createPerson(Person person){
			person=new Person("Jack",person);
			return person;	
		}
		public static void main(String[] args)
		{
			Person person=createPeople();
			// line 1
			person=createPerson(person);
			// line 2
			String name=person.toString();
			System.out.println(name);	
		}
	}

	Which statement is true?

	A) The memory allocated for John object can be reused in line 1.
	B) The memory allocated for Jack object can be reused in line 2.
	C) The memory allocated for Jane object can be reused in line 2.
	D) The memory allocated for Jane object can be reused in line 1.

	ans:C => A

	*/
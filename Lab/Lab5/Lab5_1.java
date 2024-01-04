package Lab5;

class People{
	private String name;
	private String ssn;
	
	People(String name, String ssn){
		this.name = name;
		this.ssn = ssn;
	}
	
	String getName() {
		return this.name;
	}
	
	String getSsn() {
		return this.ssn;
	}
}

class Student extends People{
	private int id;
	
	Student(String name, String ssn, int id){
		super(name, ssn);
		this.id = id;
	}
	
	int getId() {
		return this.id;
	}
}

public class Lab5_1{
	public static void main(String args[]) {
		Student s = new Student("dlwlrma", "930516-2xxxxxx", 12231234);
		System.out.println("name: " + s.getName());
		System.out.println("ssn: " + s.getSsn());
		System.out.println("name: " + s.getId());
	}
}
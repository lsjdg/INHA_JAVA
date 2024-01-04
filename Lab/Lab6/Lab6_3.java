package Lab6;
import java.util.Objects;

class Student{
	private int id;
	private String name;
	
	Student(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public boolean isSame(Student another) {
		return this.id == another.id && 
				Objects.hash(this.name) == Objects.hash(another.name) &&
				this.name.equals(another.name);
	}
}

public class Lab6_3{
	public static void main(String args[]) {
		Student s1 = new Student(16, "dlwlrma");
		Student s2 = new Student(16, "dlwlrma");
		
		if (s1.isSame(s2)) {
			System.out.println("s1 == s2");
		}
		else {
			System.out.println("s1 != s2");
		}
	}
}
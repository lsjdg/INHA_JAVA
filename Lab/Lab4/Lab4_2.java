package Lab4;

class Student {
    private String name;
    private int birth;

    Student(String name, int birth) {
        this.name = name;
        this.birth = birth;
    }

    boolean isOlder(Student other) {
        return this.birth <= other.birth;
    }

    String getName() {
        return this.name;
    }
}

public class Lab4_2{
	public static void main(String args[]) {
        Student s1 = new Student("pby", 19900212);
        Student s2 = new Student("dlwlrma", 19930516);
        Student s3 = new Student("JianLee", 19981104);
        
        System.out.println(s1.getName() + (s1.isOlder(s2) ? " > " : " <= ") + s2.getName());
        System.out.println(s3.getName() + (s3.isOlder(s2) ? " > " : " <= ") + s2.getName());
    }
}

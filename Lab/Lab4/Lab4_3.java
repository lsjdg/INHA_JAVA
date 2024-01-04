package Lab4;
import java.util.Scanner;

class Student2{
	private String name;
	private int birth;
	
	Student2(String name, int birth){
		this.name = name;
		this.birth = birth;
	}
	
	String getName() {
		return this.name;
	}
	
	int getBirth() {
		return this.birth;
	}
}



public class Lab4_3{
	static Scanner scan = new Scanner(System.in);
	static void closeScanner() {
		scan.close();
	}
	
	static Student2[] makeArray(int n) {
		Student2 arr[] = new Student2[n];
		for (int i = 0; i<n; i++) {
			System.out.print("Enter your name and birth: ");
			String name = scan.next();
			int birth = scan.nextInt();
			arr[i] = new Student2(name, birth);
		}
		return arr;
	}
	
	static void printArray(Student2 arr[]) {
		for (Student2 c : arr) {
			System.out.println(c.getName() + " " + c.getBirth());
		}
	}
	
	public static void main(String args[]) {
		int number;
		System.out.print("Enter #Students: ");
		number = scan.nextInt();
		Student2[] sArr = makeArray(number);
		System.out.println();
		printArray(sArr);
		Lab4_3.closeScanner();
	}
}
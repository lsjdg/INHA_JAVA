package Lab2;
import java.util.Scanner;

public class Lab2_1 {
	public static void main(String[] args) {
		System.out.print("age: ");
		Scanner ageScanner = new Scanner(System.in);
		String age = ageScanner.next();
		
		System.out.print("name: ");
		Scanner nameScanner = new Scanner(System.in);
		String name = nameScanner.nextLine();
		
		System.out.print(age + ' ' + name);
	}
}

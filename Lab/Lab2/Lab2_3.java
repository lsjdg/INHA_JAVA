package Lab2;
import java.util.Scanner;

public class Lab2_3{
	public static void main(String args[]) {
		System.out.print
		("Coordinates of a point (x, y): ");
		Scanner coordScanner = new Scanner(System.in);
		int x = coordScanner.nextInt();
		int y = coordScanner.nextInt();
		String s;
		if ((x >= 100) && (x <= 200) && (y >= 100) && (y <= 200)) {
			s = "inside ";
		}
		else {
			s = "not in ";
		}
		
		System.out.print
		("(" + x + ", " + y + "): " + s + "the rectangle");
	}
}
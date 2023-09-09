package Lab2;
import java.util.Scanner;
import java.lang.Math;

public class Lab2_4{
	public static void main(String args[]) {
		System.out.print
		("Center of circle: ");
		Scanner coordScanner = new Scanner(System.in);
		int cx = coordScanner.nextInt();
		int cy = coordScanner.nextInt();
		
		System.out.print
		("Radius: ");
		Scanner radiusScanner = new Scanner(System.in);
		double r = radiusScanner.nextDouble();
		
		System.out.print
		("Point: ");
		Scanner pointScanner = new Scanner(System.in);
		int px = pointScanner.nextInt();
		int py = pointScanner.nextInt();
		
		double d = (px-cx) * (px - cx) + (py-cy) * (py-cy);
		double distance = Math.sqrt(d);
		
		String s;
		if (distance <= r) {
			s = "inside ";
		}
		else {
			s = "not in ";
		}
		
		System.out.print
		("(" + px + ", " + py + "): " + s + "the circle");
	}
}
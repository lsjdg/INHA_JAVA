package Lab6;
import java.util.Scanner;
import java.lang.Math;
import java.util.StringTokenizer;

public class Lab6_5{
	public static void main(String args[]) {
		while (true) {
			Scanner textScanner = new Scanner(System.in);
			System.out.print("Input a string: ");
			String s = textScanner.nextLine();
			
			int startIndex = (int)(Math.random()*100 % s.length());
			s = s.substring(startIndex);
			
			StringTokenizer st = new StringTokenizer(s, " ");
			int wordCount = st.countTokens();
			
			System.out.println("startIndex = " + startIndex + ", #words = " + wordCount);
			System.out.println(s);
		}
	}
}
package Lab2;
public class Lab2_2{
	public static void main(String args[]) {
		byte b1 = 60;
		byte b2 = 70;
		char c1 = 'A';
		int c2 = 1;
		int bSum = (int)b1 + (int)b2;
		int cSumValue = (int)c1 + c2;
		char cSumLetter = (char)cSumValue;
		
		System.out.println("bSum (value): " + bSum);
		System.out.println("cSum (value): " + cSumValue);
		System.out.println("cSum (letter): " + cSumLetter);
	}
}
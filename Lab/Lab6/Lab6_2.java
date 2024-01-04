package Lab6;

class Point{
	private int x;
	private int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "Point(" + this.x + ", " + this.y + "), r = ";
	}
}

class Circle extends Point{
	private int r;
	
	Circle (int x, int y, int r){
		super (x, y);
		this.r = r;
	}
	
	public String toString() {
		return super.toString() + this.r;
	}
	
	public boolean isEqual(Circle another) {
		return another.toString().equals(this.toString());
	}
}

public class Lab6_2{
	public static void main(String args[]) {
		Circle c1 = new Circle(3, 4, 5);
		Circle c2 = new Circle(3, 4, 5);
		Circle c3 = new Circle(3, 4, 6);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		if (c1.isEqual(c2)) {
			System.out.println("c1 == c2");
		}
		else {
			System.out.println("c1 != c2");
		}
		
		if (c1.isEqual(c3)) {
			System.out.println("c1 == c3");
		}
		else {
		System.out.println("c1 != c3");
		}
	}
}
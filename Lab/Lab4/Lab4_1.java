package Lab4;

class Car{
	int year;
	String model;
	String color;
	
	public Car() {
		this("null", "null", 0);
	}
	
	public Car(String model) {
		this(model, "null", 0);
	}
	
	public Car(String model, String color) {
		this(model, color, 0);
	}
	
	public Car(String model, String color, int year) {
		this.model = model;
		this.color = color;
		this.year = year;
	}
	
	void printInfor() {
		System.out.println(this.model + " " + this.color + " " + this.year);
	}
}

public class Lab4_1{
	public static void main(String args[]) {
		Car car1 = new Car();
		Car car2 = new Car("MC20");
		Car car3 = new Car("MC20", "white");
		Car car4 = new Car("MC20", "white", 2021);
		
		car1.printInfor();
		car2.printInfor();
		car3.printInfor();
		car4.printInfor();
				
	}
}
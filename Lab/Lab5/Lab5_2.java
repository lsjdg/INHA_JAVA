package Lab5;

class Device_2{
	private String name;
	private int year;
	
	Device_2(String name, int year){
		this.name = name;
		this.year = year;
	}
	
	public String getInfor() {
		return name + " " + year;
	}
}

class S22_2 extends Device_2{
	String price;
	S22_2(String name, int year){
		super (name, year);
	}
	
	public String getInfor() {
		return super.getInfor() + " $1400";
	}
}

class MP3_2 extends Device_2{
	String price;
	MP3_2(String name, int year){
		super (name, year);
	}
	
	public String getInfor() {
		return super.getInfor() + " $120";
	}
}

class TV_2 extends Device_2{
	String price;
	TV_2(String name, int year){
		super (name, year);
	}
	
	public String getInfor() {
		return super.getInfor() + " $5000";
	}
}

public class Lab5_2{
	public static void main(String args[]) {
		S22_2 s22 = new S22_2("S22", 2022);
		MP3_2 mp3 = new MP3_2("MP3", 2005);
		TV_2 tv = new TV_2("TV", 2017);
		
		Device_2 arr[] = new Device_2[3];
		
		arr[0] = s22;
		arr[1] = mp3;
		arr[2] = tv;
		
		for (Device_2 d : arr) {
			System.out.println(d.getInfor());
		}
	}
}
package step1;

public class Main {
	public static void main(String[] args) {
		StringAddCalculator cal = new StringAddCalculator();
		System.out.println(cal.add("1,2,3"));
		System.out.println(cal.add("//'\n1'2'3"));
	}
}

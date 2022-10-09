package step1;

public class MainApplication {
	public static void main(String[] args) {
		Calculator calculator = new Calculator(Input.writeFormula());
		System.out.println(calculator.start());
	}
}

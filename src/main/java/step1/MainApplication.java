package step1;

public class MainApplication {
	public static void main(String[] args) {
		Calculator calculator = new Calculator(Input.writeFormula());
		Print.printResult(calculator.start());
	}
}

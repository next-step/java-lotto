package calculator;

public class CalculatorApplication {
	public static void main(String[] args) {
		ConsoleInputView consoleInputView = new ConsoleInputView();
		Calculator calculator = new Calculator();

		System.out.println(calculator.run(consoleInputView.input()));
	}
}

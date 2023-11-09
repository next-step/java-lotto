import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputView.inputExpression(scanner);

		int result = Integer.parseInt(inputs[0]);
		Calculator calculator = new Calculator();
		for (int i = 1; i < inputs.length; i += 2) {
			char operator = inputs[i].charAt(0);
			int number = Integer.parseInt(inputs[i+1]);
			calculator.calculate(result, operator, number);
			result = calculator.result();
		}

		OutputView.printResult(result);
	}
}

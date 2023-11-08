import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("계산식을 입력하세요.");
		String inputExpression = scanner.nextLine();
		if(inputExpression.isBlank()) {
			throw new IllegalArgumentException("유효한 계산식을 입력해주세요");
		}

		String[] inputs = inputExpression.split(" ");
		int result = Integer.parseInt(inputs[0]);
		Calculator calculator = new Calculator();
		for (int i = 1; i < inputs.length; i += 2) {
			char operator = inputs[i].charAt(0);
			int number = Integer.parseInt(inputs[i+1]);
			calculator.calculate(result, operator, number);
			result = calculator.result();
		}

		System.out.printf("계산 결과값은 %d 입니다.", result);
	}
}

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
		for (int i = 0; i < inputs.length - 1; i += 2) {
			calculator.calculate(result, inputs[i+1].charAt(0), Integer.parseInt(inputs[i+2]));
			result = calculator.result();
		}

		System.out.printf("계산 결과값은 %d 입니다.", result);
	}
}

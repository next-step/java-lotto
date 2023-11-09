import java.util.Scanner;

public class InputView {
	public static String[] inputExpression() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("계산식을 입력하세요.");
		String inputExpression = scanner.nextLine();
		if(inputExpression.isBlank()) {
			throw new IllegalArgumentException("유효한 계산식을 입력해주세요");
		}

		return inputExpression.split(" ");
	}
}

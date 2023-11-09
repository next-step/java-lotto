import java.util.Scanner;

public class InputView {
	public static String[] inputExpression() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("계산식을 입력하세요.");
		String inputExpression = scanner.nextLine();
		validateInputExpression(inputExpression);

		return inputExpression.split(" ");
	}

	public static String[] inputExpression(String inputExpression) {
		validateInputExpression(inputExpression);

		return inputExpression.split(" ");
	}

	private static void validateInputExpression(String inputExpression) {
		checkInputIsNullOrEmpty(inputExpression);
	}

	private static void checkInputIsNullOrEmpty(String inputExpression) {
		if(inputExpression == null || inputExpression.isBlank()) {
			throw new IllegalArgumentException("유효한 계산식을 입력해주세요");
		}
	}
}

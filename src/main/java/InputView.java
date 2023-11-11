import java.util.Scanner;

public class InputView {
	public static String inputExpression() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("계산식을 입력하세요.");
		String inputExpression = scanner.nextLine();

		return inputExpression;
	}

	public static String inputExpression(String inputExpression) {
		return inputExpression;
	}
}

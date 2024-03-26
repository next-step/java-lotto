package calculator.io;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static String[] inputExpression() {
		System.out.println("계산할 식을 입력해주세요.");
		String[] expression = scanner.nextLine().split(" ");

		return expression;
	}
}

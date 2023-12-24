package calculator.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static void printExpressionInput() {
		System.out.println("식을 입력하세요. (각 숫자와 기호는 공백을 기준으로 구분)");
	}

	public static String inputText() {
		return validate(SCANNER.nextLine());
	}

	private static String validate(String text) {
		if (text == null || text.isBlank()) {
			throw new InputMismatchException("원하는 식을 입력하여주세요");
		}

		return text;
	}
}

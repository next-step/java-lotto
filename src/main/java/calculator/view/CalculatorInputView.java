package calculator.view;

import java.util.Scanner;

public class CalculatorInputView {

	private static final String REQUEST_MESSAGE = "문자열을 입력해주세요.";
	private static final Scanner scanner = new Scanner(System.in);

	public static String requestView() {
		System.out.println(REQUEST_MESSAGE);
		return scanner.next().replace("\\n", "\n");
	}
}

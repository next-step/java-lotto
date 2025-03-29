package calculator.view;

import java.util.Scanner;

public class InputView {
	private static final String INPUT_MESSAGE = "계산식을 입력하세요.";

	public String getInput() {
		System.out.println(INPUT_MESSAGE);
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		validateInput(input);
		return input;
	}

	public void validateInput(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("입력 값이 null 이거나 빈 문자열 입니다.");
		}
	}

}

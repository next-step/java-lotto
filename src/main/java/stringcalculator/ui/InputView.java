package stringcalculator.ui;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static String input() {
		System.out.println("문자열을 입력하세요.");
		String input = scanner.nextLine();

		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("입력값은 null이거나 공백일 수 없습니다.");
		}

		return input;
	}

	public static String[] parse(String input) {
		String[] split = input.split(" ");

		if (split.length < 3 || split.length % 2 == 0) {
			throw new IllegalArgumentException("입력 문자열의 길이가 올바르지 않습니다.");
		}

		return split;
	}
}

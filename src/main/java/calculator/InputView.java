package calculator;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String SINGLE_SPACE = " ";
	private static final Pattern EXPRESSION_FORMAT_PATTERN = Pattern.compile("(\\d+ \\D )*\\d+");

	public List<String> readExpressions() {
		System.out.println("수식을 입력하세요: ");

		String input = SCANNER.nextLine();
		validateExpressionFormat(input);
		return List.of(input.split(SINGLE_SPACE));
	}

	private void validateExpressionFormat(String input) {
		if (!EXPRESSION_FORMAT_PATTERN.matcher(input).matches()) {
			throw new IllegalArgumentException("연산자와 숫자는 공백으로 구분해야 하고, 번갈아 나와야 합니다");
		}
	}
}

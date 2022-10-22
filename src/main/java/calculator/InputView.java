package calculator;

import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String SINGLE_SPACE = " ";

	public List<String> readExpressions() {
		System.out.println("수식을 입력하세요: ");

		String input = SCANNER.nextLine();
		return List.of(input.split(SINGLE_SPACE));
	}
}

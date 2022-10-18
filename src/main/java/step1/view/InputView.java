package step1.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String BLANK = " ";

	public List<String> getInput() {
		System.out.print("계산식 입력 : ");
		return splitInput(scanner.nextLine(), BLANK);
	}

	public List<String> splitInput(String input, String separator) {
		return List.of(input.split(separator));
	}
}

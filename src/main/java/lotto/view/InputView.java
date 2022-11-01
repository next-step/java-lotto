package lotto.view;

import static java.lang.System.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String ASK_MONEY_QUESTION = "구입금액을 입력해 주세요.";
	private static final String ASK_WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String LINE_BREAK = "\n";
	private static final String COMMA_DELIMITER = ",";

	private final Scanner scanner;

	private InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public InputView() {
		this(new Scanner(in));
	}

	public int askMoney() {
		print(ASK_MONEY_QUESTION);
		print(LINE_BREAK);

		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (InputMismatchException exception) {
			throw new InputMismatchException("숫자를 입력해주세요.");
		}
	}

	public List<Integer> askWinningNumbers() {
		print(ASK_WINNING_NUMBER_QUESTION);
		print(LINE_BREAK);

		scanner.useDelimiter(COMMA_DELIMITER);

		final String input = scanner.nextLine();
		final List<String> splitedInput = splitInput(input);

		return splitedInput.stream()
			.map(s -> Integer.parseInt(s.trim()))
			.collect(Collectors.toList());
	}

	private List<String> splitInput(String input) {
		return Arrays.asList(input.split(COMMA_DELIMITER));
	}

	private void print(String text) {
		out.print(text);
	}
}

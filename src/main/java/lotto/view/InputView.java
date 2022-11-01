package lotto.view;

import static java.lang.System.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
	private static final String ASK_MONEY_QUESTION = "구입금액을 입력해 주세요.";
	private static final String LINE_BREAK = "\n";

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
			return scanner.nextInt();
		} catch (InputMismatchException exception) {
			throw new InputMismatchException("숫자를 입력해주세요.");
		}
	}

	private void print(String text) {
		out.print(text);
	}

}

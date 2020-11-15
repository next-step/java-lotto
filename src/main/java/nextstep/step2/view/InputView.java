package nextstep.step2.view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
	private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String WRONG_INPUT_MESSAGE = "구입금액은 필수입니다.";

	private Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public int getInputMessage() {
		System.out.println(INPUT_MESSAGE);
		return getInputMoney();
	}

	protected int getInputMoney() {
		try {
			return scanner.nextInt();
		} catch (NoSuchElementException ex) {
			throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
		}
	}
}

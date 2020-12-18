package lotto.view;

import java.util.Scanner;

import lotto.domain.Message;

public class InputView {

	public static int waitInputMoney() {
		System.out.println(Message.INPUT_MONEY);

		return waitInputNumber();
	}

	private static int waitInputNumber() {
		try {
			return new Scanner(System.in).nextInt();
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(Message.INPUT_NUMBER);
		}
	}

	public static String waitInputLastWinNumbers() {
		System.out.println(Message.INPUT_LAST_WIN_NUMBERS);

		return new Scanner(System.in).nextLine();
	}
}

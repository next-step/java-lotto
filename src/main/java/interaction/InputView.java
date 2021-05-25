package interaction;

import java.util.Scanner;

import lotto.store.Budget;

public class InputView {

	private static final String PURCHASE_START_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String WINNING_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
	private static Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static Budget budgetLottoPrice() {
		System.out.println(PURCHASE_START_MESSAGE);
		return new Budget(scanner.nextInt());
	}

	public static String winningLottoNumberMessage() {
		System.out.println(WINNING_LOTTO_NUMBER);
		String number = scanner.nextLine();
		while (number == null || number.isEmpty()) {
			number = scanner.nextLine();
		}
		return number;
	}
}

package lotto.view;

import java.util.Scanner;

public class InputView {
	private static final String QUESTION_MONEY = "구입 금액을 입력해주세요.";
	private static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요.";
	private static final String QUESTION_BONUS_NUMBER = "보너스 볼을 입력해주세요.";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int inputMoney() {
		System.out.println(QUESTION_MONEY);
		return SCANNER.nextInt();
	}

	public static String inputWinningNumbers() {
		clearBuffer();
		System.out.println(QUESTION_WINNING_NUMBERS);
		return SCANNER.nextLine();
	}

	public static int inputBonusNumber() {
		System.out.println(QUESTION_BONUS_NUMBER);
		return SCANNER.nextInt();
	}

	private static void clearBuffer() {
		SCANNER.nextLine();
	}
}

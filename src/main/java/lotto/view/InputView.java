package lotto.view;

import java.util.Scanner;

public class InputView {
	private static final String QUESTION_AMOUNT = "구입 금액을 입력해주세요.";
	private static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요.";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int inputAmount() {
		System.out.println(QUESTION_AMOUNT);
		return SCANNER.nextInt();
	}

	public static String inputWinningNumbers() {
		clearBuffer();
		System.out.println(QUESTION_WINNING_NUMBERS);
		return SCANNER.nextLine();
	}

	private static void clearBuffer() {
		SCANNER.nextLine();
	}
}

package lottosecond.ui;

import java.util.Scanner;

public class InputView {

	private static final String HOW_MUCH = "구입금액을 입력해 주세요.";
	private static final String LAST_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputMoney() {
		System.out.println(HOW_MUCH);
		return inputIntValue();
	}

	private static int inputIntValue() {
		return Integer.parseInt(scanner.nextLine());
	}

	public static String inputLastWinningNumbers() {
		System.out.println(LAST_WINNING_NUMBERS);
		return scanner.nextLine();
	}

	public static int inputBonusNumber() {
		System.out.println(BONUS_NUMBER);
		return inputIntValue();
	}

}

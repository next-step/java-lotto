package lottomanual.ui;

import java.util.Optional;
import java.util.Scanner;

public class InputView {

	private static final String HOW_MUCH = "구입금액을 입력해 주세요.";
	private static final String RE_INPUT_INT_VALUE = "숫자만 입력 가능합니다. 다시 입력해주세요.";
	private static final String MANUAL_LOTTO_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String MANUAL_LOTTO_NUMBERS = "\n수동으로 구매할 번호를 입력해 주세요.";
	private static final String LAST_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
		throw new IllegalStateException();
	}

	public static int inputMoney() {
		System.out.println(HOW_MUCH);
		return inputIntValue();
	}

	public static String[] inputManualNumbers() {
		int manualCount = inputManualCount();

		return inputManualNumbers(manualCount);
	}

	private static String[] inputManualNumbers(int manualCount) {
		String[] manualNumbers = new String[manualCount];
		if (manualCount > 0) {
			System.out.println(MANUAL_LOTTO_NUMBERS);
			inputManualNumber(manualCount, manualNumbers);
		}
		return manualNumbers;
	}

	private static void inputManualNumber(int manualCount, String[] manualNumbers) {
		for (int i = 0; i < manualCount; i++) {
			manualNumbers[i] = scanner.nextLine();
		}
	}

	private static int inputManualCount() {
		System.out.println(MANUAL_LOTTO_COUNT);
		return inputIntValue();
	}

	private static int inputIntValue() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(RE_INPUT_INT_VALUE);
			return inputIntValue();
		}
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

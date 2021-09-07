package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final String QUESTION_MONEY = "구입 금액을 입력해주세요.";
	private static final String QUESTION_COUNT_OF_LOTTO_BY_MANUAL = "수동으로 구매할 로또 수를 입력해주세요.";
	private static final String QUESTION_LOTTO_NUMBERS_BY_MANUAL = "수동으로 구매할 번호를 입력해주세요.";
	private static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요.";
	private static final String QUESTION_BONUS_NUMBER = "보너스 볼을 입력해주세요.";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int inputMoney() {
		System.out.println(QUESTION_MONEY);
		return SCANNER.nextInt();
	}

	public static int inputCountLottoByManual() {
		System.out.println(QUESTION_COUNT_OF_LOTTO_BY_MANUAL);
		return SCANNER.nextInt();
	}

	public static List<String> inputLottoNumbersByManual(int count) {
		clearBuffer();

		List<String> numbersByManual = new ArrayList<>();

		System.out.println(QUESTION_LOTTO_NUMBERS_BY_MANUAL);
		for (int i = 0; i < count; i++) {
			String numbers = SCANNER.nextLine();
			numbersByManual.add(numbers);
		}
		return numbersByManual;
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

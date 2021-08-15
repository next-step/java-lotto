package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

	private static final String INPUT_MONEY_TEXT = "구입금액을 입력해 주세요.";

	private static final String INPUT_LOTTO_NUMBERS_TEXT = "지난 주 당첨 번호를 입력해 주세요.";

	private static final String INPUT_BONUS_LOTTO_NUMBERS_TEXT = "보너스 볼을 입력해 주세요.";

	private static final String INPUT_LOTTO_MANUAL_COUNT_TEXT = "수동으로 구매할 로또 수를 입력해 주세요.";

	private static final String PRINT_MANUAL_INPUT_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {

	}

	public static int inputMoney() {
		System.out.println(INPUT_MONEY_TEXT);

		int input = SCANNER.nextInt();

		SCANNER.nextLine();

		return input;
	}

	public static String inputWinLottoNumbers() {
		System.out.println(INPUT_LOTTO_NUMBERS_TEXT);

		return SCANNER.nextLine();
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_LOTTO_NUMBERS_TEXT);

		int input = SCANNER.nextInt();

		SCANNER.nextLine();

		return input;
	}

	public static int inputManualCount() {
		System.out.println(INPUT_LOTTO_MANUAL_COUNT_TEXT);

		int input = SCANNER.nextInt();

		SCANNER.nextLine();

		return input;
	}

	public static void printManualInputLottoNumbers() {
		System.out.println(PRINT_MANUAL_INPUT_LOTTO_NUMBERS);
	}

	public static String inputManualLottoNumbers() {
		return SCANNER.nextLine();
	}
}

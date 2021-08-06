package lotto.view;

import java.util.Scanner;

public class InputView {

	private static final String INPUT_MONEY_TEXT = "구입금액을 입력해 주세요.";

	private static final String INPUT_LOTTO_NUMBERS_TEXT = "지난 주 당첨 번호를 입력해 주세요.";

	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {

	}

	public static int inputMoney() {
		System.out.println(INPUT_MONEY_TEXT);

		return SCANNER.nextInt();
	}

	public static String inputWinLottoNumbers() {
		System.out.println(INPUT_LOTTO_NUMBERS_TEXT);

		return SCANNER.nextLine();
	}
}

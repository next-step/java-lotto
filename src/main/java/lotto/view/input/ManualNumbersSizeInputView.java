package lotto.view.input;

import lotto.option.LottoBuyPlan;
import lotto.option.LottoMoney;

import java.util.Scanner;

class ManualNumbersSizeInputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String GUIDE_MANUAL_NUMBERS_SIZE = "수동으로 구매할 로또 수를 입력해주세요.";
	private static final String VALIDATE_FAIL_ONLY_NUMBER = "숫자를 입력해주셔야 합니다.";

	long inputManualNumbersSize(LottoMoney maxMoney) {
		String input;
		do {
			System.out.println(GUIDE_MANUAL_NUMBERS_SIZE);
			input = SCANNER.nextLine();
		} while (!hasNoExceptionForManualNumbersSize(maxMoney, input));
		return Long.parseLong(input);
	}

	private boolean hasNoExceptionForManualNumbersSize(LottoMoney maxMoney, String input) {
		try {
			long manualNumbersSize = Long.parseLong(input);
			LottoBuyPlan.validate(maxMoney, manualNumbersSize);
			return true;
		} catch (NumberFormatException e) {
			System.out.println(VALIDATE_FAIL_ONLY_NUMBER);
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}

package lotto.view.input;

import lotto.option.LottoBuyPlan;
import lotto.option.LottoMoney;

import java.util.Scanner;

class ManualNumbersSizeInputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	long inputManualNumbersSize(LottoMoney maxMoney) {
		String input;
		do {
			System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
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
			System.out.println("숫자를 입력해주셔야 합니다.");
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}

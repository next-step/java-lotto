package lotto.view.input;

import lotto.LottoStore;

import java.util.Scanner;

public class MoneyInputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public int getMoney() {
		int moneyInput;
		do {
			System.out.println("구입금액을 입력해 주세요.");
			moneyInput = Integer.parseInt(SCANNER.nextLine());
		} while (!hasNoExceptionAboutMoneyValidation(moneyInput));
		return moneyInput;
	}

	private boolean hasNoExceptionAboutMoneyValidation(int moneyInput) {
		try {
			validateMoneyInput(moneyInput);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private void validateMoneyInput(int moneyInput) {
		if (moneyInput <= 0) {
			throw new IllegalArgumentException("금액은 0 초과여야합니다.");
		}

		if (moneyInput % LottoStore.LOTTO_PRICE > 0) {
			throw new IllegalArgumentException(String.format("금액은 %,d원 단위여야 합니다.", LottoStore.LOTTO_PRICE));
		}
	}
}

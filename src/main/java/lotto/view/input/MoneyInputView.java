package lotto.view.input;

import lotto.option.LottoMoney;

import java.util.Scanner;

class MoneyInputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	LottoMoney getMoney() {
		int moneyInput;
		do {
			System.out.println("구입금액을 입력해 주세요.");
			moneyInput = Integer.parseInt(SCANNER.nextLine());
		} while (!hasNoExceptionAboutMoneyValidation(moneyInput));
		return new LottoMoney(moneyInput);
	}

	private boolean hasNoExceptionAboutMoneyValidation(int moneyInput) {
		try {
			new LottoMoney(moneyInput);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}

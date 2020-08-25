package lotto;

import lotto.input.InputValidator;


public class LottoPayAmounts {

	private final int paidAmounts;

	private LottoPayAmounts(int paidAmounts) {
		this.paidAmounts = paidAmounts;
	}

	public static LottoPayAmounts of(String paidAmountsString) {
		InputValidator.validatePurchasePrice(paidAmountsString);

		return new LottoPayAmounts(Integer.parseInt(paidAmountsString));
	}

	public int getCountOfLotto(int price) {
		return paidAmounts / price;
	}


}

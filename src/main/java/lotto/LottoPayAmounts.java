package lotto;

import lotto.input.InputValidator;


public class LottoPayAmounts {

	private final int paidAmounts;
	private int countOfLotto;

	private LottoPayAmounts(int paidAmounts) {
		this.paidAmounts = paidAmounts;
	}

	public static LottoPayAmounts of(String paidAmountsString) {
		InputValidator.validatePurchasePrice(paidAmountsString);

		return new LottoPayAmounts(Integer.parseInt(paidAmountsString));
	}

	public int getCountOfLotto(int price) {
		if (countOfLotto == 0) {
			countOfLotto = paidAmounts / price;
		}

		return countOfLotto;
	}


}

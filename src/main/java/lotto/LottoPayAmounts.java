package lotto;

import lombok.Getter;

import lotto.input.InputValidator;


@Getter
public class LottoPayAmounts {

	private final int paidAmounts;

	private LottoPayAmounts(int paidAmounts) {
		this.paidAmounts = paidAmounts;
	}

	public static LottoPayAmounts of(String paidAmountsString) {
		InputValidator.validatePurchasePrice(paidAmountsString);

		return new LottoPayAmounts(Integer.parseInt(paidAmountsString));
	}


}

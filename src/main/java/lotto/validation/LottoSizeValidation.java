package lotto.validation;

import lotto.utils.ErrorMessage;

public class LottoSizeValidation {

	public static final int LOTTO_LENGTH = 6;

	private LottoSizeValidation() {
	}

	public static void validLottoSizeCheck(String[] value) {
		if (value.length != LOTTO_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE);
		}
	}
}

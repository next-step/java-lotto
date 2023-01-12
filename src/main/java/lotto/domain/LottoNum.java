package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.InvalidRangeOfLottoNumException;

public class LottoNum {

	private final int value;

	private LottoNum(int value) {
		if (!isValidLottoNum(value)) {
			throw new InvalidRangeOfLottoNumException(ErrorMessage.LOTTO_NUMBER_MUST_BE_BETWEEN_1_AND_45);
		}
		this.value = value;
	}

	public static LottoNum of(int value) {
		return new LottoNum(value);
	}

	private boolean isValidLottoNum(int value) {
		return value >= 1 && value <= 45;
	}
}

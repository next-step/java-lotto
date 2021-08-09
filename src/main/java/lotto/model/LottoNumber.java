package lotto.model;

import java.util.Objects;

import lotto.message.ErrorMessage;

public class LottoNumber {

	public static final int MINIMUM_NUMBER = 0;
	public static final int MAXIMUM_NUMBER = 45;
	private final int lottoNumber;

	public LottoNumber(int lottoNumber) {
		checkNumberRange(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	public int getLottoNumber() {
		return lottoNumber;
	}

	private void checkNumberRange(int lottoNumber) {
		if (lottoNumber < MINIMUM_NUMBER || lottoNumber > MAXIMUM_NUMBER) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return getLottoNumber() == that.getLottoNumber();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLottoNumber());
	}
}

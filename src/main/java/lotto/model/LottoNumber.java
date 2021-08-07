package lotto.model;

import java.util.Objects;

import lotto.message.ErrorMessage;

public class LottoNumber {

	private final int lottoNumber;

	public LottoNumber(int lottoNumber) {
		checkNumberRange(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	public int getLottoNumber() {
		return lottoNumber;
	}

	private void checkNumberRange(int lottoNumber) {
		if (lottoNumber < 0 || lottoNumber > 45) {
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

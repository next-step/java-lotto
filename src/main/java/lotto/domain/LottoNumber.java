package lotto.domain;

import java.util.Objects;

public class LottoNumber {
	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;
	private final int lottoNumber;

	public LottoNumber(int lottoNumber) {
		validateLottoNumber(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	public int compare(LottoNumber lottoNumber) {
		return Integer.compare(this.lottoNumber, lottoNumber.lottoNumber);
	}

	private void validateLottoNumber(int number) {
		if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException(Message.INVALID_LOTTO_NUMBER_RANGE);
		}
	}

	@Override
	public String toString() {
		return Integer.toString(lottoNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber lottoNumber1 = (LottoNumber)o;
		return lottoNumber == lottoNumber1.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}
}

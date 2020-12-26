package lotto.domain;

import java.util.Objects;

public class LottoNumber {
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;

	private final int lottoNumber;

	public LottoNumber(int lottoNumber) {
		validateNumber(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	public int getLottoNumber() {
		return lottoNumber;
	}

	private void validateNumber(int lottoNumber) {
		if (lottoNumber < LOTTO_START_NUMBER || lottoNumber > LOTTO_END_NUMBER) {
			throw new IllegalArgumentException("1부터 45까지 숫자만 가능합니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return lottoNumber == that.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}
}

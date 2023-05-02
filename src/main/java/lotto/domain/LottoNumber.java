package lotto.domain;

import java.util.Objects;

public class LottoNumber {

	public static final int MINIMUM_BOUND = 1;
	public static final int MAXIMUM_BOUND = 45;

	private final int lottoNumber;

	public LottoNumber(int lottoNumber) {
		if (lottoNumber < LottoNumber.MINIMUM_BOUND || lottoNumber > LottoNumber.MAXIMUM_BOUND) {
			throw new IllegalArgumentException(String.format("로또 넘버는 %d~%d까지의 숫자만 입력 가능합니다.", LottoNumber.MINIMUM_BOUND, LottoNumber.MAXIMUM_BOUND));
		}
		this.lottoNumber = lottoNumber;
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

	@Override
	public String toString() {
		return String.valueOf(this.lottoNumber);
	}
}

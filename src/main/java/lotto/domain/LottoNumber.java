package lotto.domain;

import exception.OutOfRangeException;
import lotto.util.Range;

public class LottoNumber {
	public static final int LOTTO_RANGE_MIN = 1;
	public static final int LOTTO_RANGE_MAX = 45;
	private final int number;

	public LottoNumber(int number) {
		validateNumber(number);
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		LottoNumber that = (LottoNumber)o;

		return number == that.number;
	}

	@Override
	public int hashCode() {
		return number;
	}

	private void validateNumber(int number) {
		if (Range.of(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX).notContain(number)) {
			throw new OutOfRangeException("생성된 로또번호가 범위를 벗어났습니다. (범위 : "+ Range.of(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX) + ")");
		}
	}
}

package lotto.domain;

import java.util.Objects;

public class LottoNumber {
	public static final int MAX_LOTTO_NUMBER = 45;
	private final int number;

	public LottoNumber(int number) {
		checkRangeOfNumber(number);
		this.number = number;
	}

	public int isGraterThanNumber(LottoNumber targetNumber) {
		return this.number - targetNumber.number;
	}

	private void checkRangeOfNumber(int number) {
		if (!isAllowNumberRange(number)) {
			throw new IllegalArgumentException("기준 범위를 초과하였습니다.");
		}
	}

	private boolean isAllowNumberRange(int number) {
		return number > 0 && number <= MAX_LOTTO_NUMBER;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumber that = (LottoNumber) o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}

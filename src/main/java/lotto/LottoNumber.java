package lotto;

import java.util.Objects;

public class LottoNumber {
	private final int number;

	public LottoNumber(int number) {
		checkRangeOfNumber(number);
		this.number = number;
	}

	private void checkRangeOfNumber(int number) {
		if (verifyNumber(number)) {
			throw new IllegalArgumentException("기준치를 초과하였습니다.");
		}
	}

	private boolean verifyNumber(int number) {
		return number > 45;
	}

	public int isGraterThanNumber(LottoNumber targetNumber) {
		return this.number - targetNumber.number;
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
}

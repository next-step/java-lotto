package lotto.domain;

import java.util.Objects;

public class LottoNumber {
	private final int number;

	public LottoNumber(int number) {
		this.number = number;
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

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}

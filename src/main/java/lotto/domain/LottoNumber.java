package lotto.domain;

import lotto.domain.validator.LottoNumberValidator;

/**
 * Created by hspark on 10/11/2018.
 */
public final class LottoNumber implements Comparable<LottoNumber> {
	private final int number;

	public LottoNumber(int number) {
		this.number = number;
		LottoNumberValidator.valid(this);
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int compareTo(LottoNumber anotherNumber) {
		return Integer.compare(this.number, anotherNumber.number);
	}

	@Override
	public String toString() {
		return "" + number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		LottoNumber that = (LottoNumber) o;

		return number == that.number;
	}

	@Override
	public int hashCode() {
		return number;
	}
}

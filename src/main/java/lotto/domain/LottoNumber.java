package lotto.domain;

import java.util.Objects;

class LottoNumber implements Comparable<LottoNumber> {

	private final int number;

	LottoNumber(int number) {
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
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		return this.number - lottoNumber.number;
	}

}

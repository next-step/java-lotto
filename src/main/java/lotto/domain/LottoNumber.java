package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
	public static final int LOTTO_MINIMUM_NUMBER = 1;
	public static final int LOTTO_MAXIMUM_NUMBER = 45;

	private final int number;

	public LottoNumber(int number) {
		this.number = number;
		validateNumber();

	}

	private void validateNumber() {
		if (number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
			throw new RuntimeException("lotto number must be within the range(1 - 45)");
		}
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
	public int compareTo(LottoNumber o) {
		return number - o.number;
	}
}

package lotto;

import java.util.Objects;

import static type.LottoExceptionType.WRONG_LOTTO_NUMBER;

public final class LottoNumber implements Comparable<LottoNumber> {

	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;

	private final int number;

	public LottoNumber(final int number) {
		if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
			throw new IllegalArgumentException(WRONG_LOTTO_NUMBER.message());
		}
		this.number = number;
	}

	@Override
	public int compareTo(LottoNumber o) {
		return Integer.compare(this.number, o.number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
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
}

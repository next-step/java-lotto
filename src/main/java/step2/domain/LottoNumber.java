package step2.domain;

import step2.util.RandomNumberGenerator;

public class LottoNumber {

	private final int MIN_NUMBER = 1;
	private final int MAX_NUMBER = 45;
	private final int number;

	public LottoNumber() {
		this.number = generate();
	}

	private int generate() {
		return RandomNumberGenerator.getRandomNumber(MAX_NUMBER);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final LottoNumber that = (LottoNumber)o;

		return number == that.number;
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public String toString() {
		return "" + number;
	}
}

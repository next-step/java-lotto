package step2.domain;

public class LottoNumber implements Comparable<LottoNumber> {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	private final int number;

	public LottoNumber(final Integer number) {
		validate(number);
		this.number = number;
	}

	private void validate(final Integer number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException();
		}
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
		return String.valueOf(number);
	}

	@Override
	public int compareTo(final LottoNumber compareNumber) {
		return number - compareNumber.number;
	}
}

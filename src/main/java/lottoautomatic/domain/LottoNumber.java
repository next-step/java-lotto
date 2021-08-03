package lottoautomatic.domain;

public class LottoNumber implements Comparable<LottoNumber> {

	private final int number;

	public LottoNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int compareTo(LottoNumber o) {
		return number > o.getNumber() ? 1 : -1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		LottoNumber number1 = (LottoNumber) o;

		return getNumber() == number1.getNumber();
	}

	@Override
	public int hashCode() {
		return getNumber();
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

}

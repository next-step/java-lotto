package lotto;

public class LottoNumber implements Comparable<LottoNumber> {

	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;

	private final int number;

	public LottoNumber(final int number) {
		validateNumber(number);
		this.number = number;
	}

	public int number() {
		return number;
	}

	@Override
	public String toString() {
		return String.valueOf(this.number);
	}

	@Override
	public boolean equals(Object lottoNumber) {
		if (!(lottoNumber instanceof LottoNumber)) {
			return false;
		}
		return ((LottoNumber)lottoNumber).number() == this.number;
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		if (this.number < lottoNumber.number()) {
			return -1;
		}
		if (this.number > lottoNumber.number()) {
			return 1;
		}
		return 0;
	}

	private void validateNumber(int number) {
		if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
			throw new IllegalArgumentException("로또 번호는 1보다 작거나 45보다 클 수 없습니다.");
		}
	}

}


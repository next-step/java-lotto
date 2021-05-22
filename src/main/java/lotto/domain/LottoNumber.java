package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {

	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;

	private final int number;

	public LottoNumber(final int number) {
		validateNumber(number);
		this.number = number;
	}

	private void validateNumber(int number) {
		if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
			throw new IllegalArgumentException("로또 번호는 1보다 작거나 45보다 클 수 없습니다.");
		}
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return String.valueOf(this.number);
	}

	@Override
	public boolean equals(Object otherLottoNumber) {
		if (!(otherLottoNumber instanceof LottoNumber)) {
			return false;
		}
		return ((LottoNumber)otherLottoNumber).getNumber() == this.number;
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		if (this.number < lottoNumber.getNumber()) {
			return -1;
		}
		if (this.number > lottoNumber.getNumber()) {
			return 1;
		}
		return 0;
	}

}


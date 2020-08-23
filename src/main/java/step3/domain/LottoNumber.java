package step3.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
	private final int number;

	public static final int MIN_LOTTO_VALUE = 1;
	public static final int MAX_LOTTO_VALUE = 45;

	private static final String LOTTO_NUMBER_PHRASES = "로또 당첨 번호는 1 이상 45 이하의 숫자여야 합니다.";

	public LottoNumber(int number) {
		validLottoNumber(number);
		this.number = number;
	}

	private void validLottoNumber(int number) {
		if (number < MIN_LOTTO_VALUE) {
			throw new IllegalArgumentException(LOTTO_NUMBER_PHRASES);
		}
		if (number > MAX_LOTTO_VALUE) {
			throw new IllegalArgumentException(LOTTO_NUMBER_PHRASES);
		}
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof LottoNumber) {
			LottoNumber anotherNumber = (LottoNumber) obj;
			return this.number == anotherNumber.number;
		}
		return false;
	}

	@Override
	public int compareTo(LottoNumber number) {
		return Integer.compare(this.number, number.number);
	}
}

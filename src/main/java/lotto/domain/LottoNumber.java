package lotto.domain;

import java.util.Objects;

public class LottoNumber {
	public static final int MIN = 1;
	public static final int MAX = 45;
	public static final String MESSAGE_INVALID_NUMBER = "로또번호는 숫자(정수)만 입력가능합니다.";
	public static final String MESSAGE_INVALID_RANGE = "로또번호는 %d~%d 이내의 숫자여야 합니다.";

	private final int number;

	public LottoNumber(int number) {
		validationRange(number);
		this.number = number;
	}

	public LottoNumber(String number) {
		validationRange(number);
		try {
			this.number = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_INVALID_NUMBER);
		}
	}

	private void validationRange(String number) {
		validationRange(Integer.parseInt(number));
	}

	private void validationRange(int number) {
		if (number < MIN || number > MAX) {
			throw new IllegalArgumentException(String.format(MESSAGE_INVALID_RANGE, MIN, MAX));
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumber that = (LottoNumber) o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(this.number);
	}
}

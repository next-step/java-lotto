package lotto.domain;

import java.util.Objects;

import lotto.exception.InvalidLottoNumberException;

public class LottoNumber {

	private static final int START_NUMBER = 1;
	private static final int LAST_NUMBER = 45;

	private final int number;

	public LottoNumber(int number) {
		validateNumber(number);
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	private void validateNumber(int number) {
		if (isInvalid(number)) {
			throw new InvalidLottoNumberException(number);
		}
	}

	private boolean isInvalid(int number) {
		return number < START_NUMBER || number > LAST_NUMBER;
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
}

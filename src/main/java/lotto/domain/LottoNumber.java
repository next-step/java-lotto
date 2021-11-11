package lotto.domain;

import java.util.Objects;

import lotto.exception.LottoNumberRangeException;

public class LottoNumber implements Comparable<LottoNumber> {
	public static final int MIN_OF_LOTTO_NUMBERS = 1;
	public static final int MAX_OF_LOTTO_NUMBERS = 45;

	private final Integer value;

	private LottoNumber(Integer value) {
		validateRange(value);
		this.value = value;
	}

	private void validateRange(Integer value) {
		if (isNotPossibleRange(value)) {
			throw new LottoNumberRangeException();
		}
	}

	private boolean isNotPossibleRange(Integer value) {
		return value < MIN_OF_LOTTO_NUMBERS || value > MAX_OF_LOTTO_NUMBERS;
	}

	public static LottoNumber create(String value) {
		return create(Integer.parseInt(value));
	}

	public static LottoNumber create(int value) {
		return new LottoNumber(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		LottoNumber that = (LottoNumber)obj;

		return Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public int compareTo(LottoNumber other) {
		return value.compareTo(other.value);
	}
}

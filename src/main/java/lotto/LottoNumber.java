package lotto;

import java.util.Objects;

public class LottoNumber {
	public static final String INVALID_NUMBER = "잘못된 숫자입니다.";
	private final int number;

	LottoNumber(int number) {
		if(!this.validate(number)) {
			throw new IllegalArgumentException(INVALID_NUMBER);
		}
		this.number = number;
	}

	private boolean validate(int number) {
		return number >= LottoRule.LOTTO_MINIMUM_NUMBER && LottoRule.LOTTO_MAXIMUM_NUMBER >= number;
	}

	public int toInteger() {
		return this.number;
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

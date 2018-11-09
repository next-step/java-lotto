package lotto.domain;

import java.util.Objects;

public class LottoNumber {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;

	private Integer number;

	public LottoNumber(String number) {
		this(Integer.valueOf(number));
	}

	public LottoNumber(Integer number) {
		if(!isInValidRange(number)) {
			throw new IllegalArgumentException(String.format("%d ~ %d 사이의 숫자만 가능합니다.",
					MIN_NUMBER, MAX_NUMBER));
		}
		this.number = number;
	}

	private boolean isInValidRange(Integer number) {
		return MIN_NUMBER <= number && number <= MAX_NUMBER;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof LottoNumber)) {
			return false;
		}
		LottoNumber that = (LottoNumber) o;
		return Objects.equals(number, that.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return number.toString();
	}
}

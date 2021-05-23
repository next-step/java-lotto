package lotto;

import java.util.Objects;

public class LottoNumber {

	private int number;

	public LottoNumber(int number) {
		validate(number);
		this.number = number;
	}

	private void validate(int number) {
		if (number < 1 || number > 46) {
			throw new IllegalArgumentException("로또의 숫자의 범위는 1~46 입니다 입력된 숫자: " + number);
		}
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

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	public int number() {
		return number;
	}
}

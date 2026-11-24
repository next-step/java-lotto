package domain.lotto;

import java.util.Objects;

public class LottoNumber {

	private final int number;

	public LottoNumber(int number) {
		if (number < 1 || number > 45) {
			throw new IllegalArgumentException("로또 숫자는 1부터 45이하여야 합니다.");
		}
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(number);
	}
}

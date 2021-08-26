package lotto;

import java.util.Objects;

public class LottoNumber {
	public static final String INVALID_NUMBER_SCOPE = "범위를 벗어났습니다.";
	public static final int MIN = 1;
	public static final int MAX = 45;
	private final int number;

	public LottoNumber(int number) {
		if(number < MIN || number > MAX) {
			throw new IllegalArgumentException(INVALID_NUMBER_SCOPE);
		}
		this.number = number;
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

package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

	private static final int LOTTO_BALL_MAX_NUMBER = 45;
	private static final int LOTTO_BALL_MIN_NUMBER = 1;

	private final int number;

	private LottoNumber(int number) {
		validateNumberRange(number);
		this.number = number;
	}

	public static LottoNumber of(int number) {
		return new LottoNumber(number);
	}

	private void validateNumberRange(int inputNumber) {
		if (inputNumber > LOTTO_BALL_MAX_NUMBER || inputNumber < LOTTO_BALL_MIN_NUMBER) {
			throw new IllegalArgumentException(String.format("로또 번호는 %s ~ %s 사이여야 합니다 (입력 : %s)",
					LOTTO_BALL_MIN_NUMBER, LOTTO_BALL_MAX_NUMBER, inputNumber));
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
	public int compareTo(LottoNumber o) {
		return this.number - o.number;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

}

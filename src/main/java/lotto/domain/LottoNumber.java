package lotto.domain;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {
	private static final int MIN = 1;
	private static final int MAX = 45;

	private static final Random random = new Random();

	private final int number;

	private LottoNumber(int number) {
		validate(number);
		this.number = number;
	}

	private void validate(int number) {
		if (number < MIN || number > MAX) {
			throw new IllegalArgumentException("로또 숫자는 1 ~ 45 이어야 합니다.");
		}
	}

	public static LottoNumber of(int number) {
		return new LottoNumber(number);
	}

	public static LottoNumber createRandom() {
		return new LottoNumber(makeRandomNumber());
	}

	private static int makeRandomNumber() {
		return random.nextInt(MAX) + 1;
	}

	public boolean isSameNumber(int number) {
		return this.number == number;
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
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}

package im.juniq.lotto.domain;

import java.util.Objects;

public class LottoNumber {
	private static final int FIRST_LOTTO_NUMBER = 1;
	private static final int LAST_LOTTO_NUMBER = 45;
	private final int number;

	public LottoNumber(int number) {
		if (number < FIRST_LOTTO_NUMBER || number > LAST_LOTTO_NUMBER) {
			throw new IllegalArgumentException("로또 번호는 " + FIRST_LOTTO_NUMBER + " ~ " + LAST_LOTTO_NUMBER + " 범위 안이어야 합니다.");
		}
		this.number = number;
	}

	public LottoNumber(String number) {
		this(Integer.parseInt(number));
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
}

package nextstep.step2.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
	private static final String DUPLICATE_NUMBER = "보너스번호는 당첨 로또번호와 중복될 수 없습니다.";
	private static final String WRONG_LOTTO_RANGE = "로또는 1~45의 숫자여야 합니다.";
	private static final String WRONG_LOTTO_NUMBER = "로또번호는 모두 숫자여야 합니다.";
	protected static final int LOTTO_MIN_NUMBER = 1;
	protected static final int LOTTO_MAX_NUMBER = 45;
	private int number;

	public LottoNumber(int number) {
		this.number = number;
		validateLottoNumberRange();
	}

	private void validateLottoNumberRange() {
		if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
			throw new IllegalArgumentException(WRONG_LOTTO_RANGE);
		}
	}

	public void validateBonusNumber(Lotto lastWinningLotto) {
		if (lastWinningLotto.getNumbers().contains(number)) {
			throw new IllegalArgumentException(DUPLICATE_NUMBER);
		}
	}

	public static int getValidateNumber(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException(WRONG_LOTTO_NUMBER);
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
		if (number < o.number)
			return -1;
		if (number == o.number)
			return 0;
		return 1;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}

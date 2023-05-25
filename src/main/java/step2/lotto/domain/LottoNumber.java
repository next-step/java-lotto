package step2.lotto.domain;

public class LottoNumber {

	public static final int LOTTO_NUMBER_MAX = 45;

	private int number;

	public LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber from(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("로또 번호는 0보다 작을 수 없습니다.");
		}

		if (number > LOTTO_NUMBER_MAX) {
			throw new IllegalArgumentException("로또 번호는" + LOTTO_NUMBER_MAX + "보다 클 수 없습니다.");
		}

		return new LottoNumber(number);
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LottoNumber) {
			return number == ((LottoNumber) obj).number;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return number;
	}
}

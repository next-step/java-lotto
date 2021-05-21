package lotto.domain;

public class LottoNumber {
	public static final int MIN = 1;
	public static final int MAX = 45;
	private final int number;

	public LottoNumber(int number) {
		validationNumber(number);
		this.number = number;
	}

	private void validationNumber(int number) {
		if (number < MIN || number > MAX) {
			throw new IllegalArgumentException("로또번호는 1~45 이내의 숫자여야 합니다.");
		}
	}

	public boolean matchNumber(int prizeNumber) {
		return this.number == prizeNumber;
	}
}

package lotto.domain;

public class LottoNumber {
	private final int number;

	public LottoNumber(int number) {
		validationNumber(number);
		this.number = number;
	}

	private void validationNumber(int number) {
		if (number < 1 || number > 45) {
			throw new IllegalArgumentException("유효하지 않은 로또번호입니다.");
		}
	}

	public boolean matchNumber(int prizeNumber) {
		return this.number == prizeNumber;
	}
}

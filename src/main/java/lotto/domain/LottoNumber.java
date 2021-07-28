package lotto.domain;

public class LottoNumber {

	private static final int START_NUMBER = 1;
	private static final int LAST_NUMBER = 45;

	private final int number;

	public LottoNumber(int number) {
		validateNumber(number);
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	private void validateNumber(int number) {
		if (number < START_NUMBER || number > LAST_NUMBER) {
			throw new IllegalArgumentException();
		}
	}
}

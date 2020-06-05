package lotto.domain;

public class LottoNumber {

	protected final int number;

	public LottoNumber(Integer number) {
		this.number = validateNumberInRange(number);
	}

	public boolean compareBonusBallIdentity(LottoNumber bonusBall) {
		return number == bonusBall.getNumber();
	}

	private int validateNumberInRange(int number) {
		if (number < 1 || number > 45) {
			throw new RuntimeException("winning number should be in between 1 and 45.");
		}
		return number;
	}

	public Integer getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}

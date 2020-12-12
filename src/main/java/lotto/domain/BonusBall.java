package lotto.domain;

public class BonusBall {
	private final LottoNumber number;

	public BonusBall(String number) {
		int inputBall = Integer.parseInt(number);
		this.number = new LottoNumber(inputBall);
	}

	public boolean hasBonusBall(LottoNumber targetNumber) {
		return this.number.equals(targetNumber);
	}
}

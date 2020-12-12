package lotto.domain;

public class BonusBall {
	private final LottoNumber number;

	public BonusBall(String number) {
		int inputBall = Integer.parseInt(number);
		this.number = new LottoNumber(inputBall);
	}

	public boolean hasBonusBall(LottoNumbers targetNumber) {
		return targetNumber.isContainsLottoNumber(this.number);
	}
}

package lotto.domain;

public class LottoWinnerNumbers {
	private final LottoNumbers winnerNumbers;
	private LottoNumber bonusBall;

	public LottoWinnerNumbers(LottoNumbers winnerNumbers) {
		this.winnerNumbers = winnerNumbers;
	}

	public LottoWinnerNumbers(LottoNumbers winnerNumbers, LottoNumber bonusBall) {
		this.winnerNumbers = winnerNumbers;
		this.bonusBall = bonusBall;
	}

	public int getMatchCount(LottoNumbers targetNumbers) {
		return this.winnerNumbers.getContainsCount(targetNumbers);
	}

	public boolean hasBonusBall(LottoNumbers checkNumber) {
		return checkNumber.isContainsLottoNumber(this.bonusBall);
	}

	public static LottoWinnerNumbers ofUser(String input, String bonusBall) {
		return new LottoWinnerNumbers(LottoNumberGenerator.ofInput(input), new LottoNumber(bonusBall));
	}
}

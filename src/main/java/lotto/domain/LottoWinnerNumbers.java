package lotto.domain;

public class LottoWinnerNumbers {
	private final LottoNumbers winnerNumbers;
	private BonusBall bonusBall;

	public LottoWinnerNumbers(LottoNumbers winnerNumbers) {
		this.winnerNumbers = winnerNumbers;
	}

	public LottoWinnerNumbers(LottoNumbers winnerNumbers, BonusBall bonusBall) {
		this.winnerNumbers = winnerNumbers;
		this.bonusBall = bonusBall;
	}

	public int getMatchCount(LottoNumbers targetNumbers) {
		return this.winnerNumbers.getContainsCount(targetNumbers);
	}

	public boolean hasBonusBall(LottoNumber checkNumber) {
		return this.bonusBall.hasBonusBall(checkNumber);
	}

	public static LottoWinnerNumbers ofUser(String input) {
		return new LottoWinnerNumbers(LottoNumberGenerator.ofInput(input));
	}

	public static LottoWinnerNumbers ofUser(String input, String bonusBall) {
		return new LottoWinnerNumbers(LottoNumberGenerator.ofInput(input), new BonusBall(bonusBall));
	}
}

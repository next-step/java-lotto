package lotto.domain;

public class LottoWinnerNumbers {
	private final LottoNumbers winnerNumbers;

	public LottoWinnerNumbers(LottoNumbers winnerNumbers) {
		this.winnerNumbers = winnerNumbers;
	}

	public int getMatchCount(LottoNumbers targetNumbers) {
		return this.winnerNumbers.getContainsCount(targetNumbers);
	}

	public static LottoWinnerNumbers ofUser(String input) {
		return new LottoWinnerNumbers(LottoNumberGenerator.ofInput(input));
	}
}

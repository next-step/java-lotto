package lotto.domain;

public class LottoWinnerNumbers {
	private final LottoNumbers winnerNumbers;

	public LottoWinnerNumbers(LottoNumbers winnerNumbers) {
		this.winnerNumbers = winnerNumbers;
	}

	public LottoNumbers getNumbers() {
		return this.winnerNumbers;
	}

	public static LottoWinnerNumbers ofUser(String input) {
		return new LottoWinnerNumbers(GenerateLottoNumber.ofInput(input));
	}
}

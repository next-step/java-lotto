package step2.domain;

public class Lotto {

	private final LottoNumbers numbers;

	public Lotto(final LottoNumbers numbers) {
		this.numbers = numbers;
	}

	public LottoNumbers getNumbers() {
		return this.numbers;
	}

	public LottoNumbers confirmWinning(final Integer... winNumbers) {
		return this.numbers.getWinningNumbers(winNumbers);
	}
}

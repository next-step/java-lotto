package step2.domain;

public class Lotto {

	private final LottoNumbers numbers;
	private LottoNumbers winningNumbers;

	public Lotto(final LottoNumbers numbers) {
		this.numbers = numbers;
	}

	public LottoNumbers getNumbers() {
		return this.numbers;
	}

	public void confirmWinning(final Integer... winNumbers) {
		this.winningNumbers = this.numbers.getWinningNumbers(winNumbers);
	}

	public LottoNumbers getWinningNumbers() {
		return winningNumbers;
	}

	public int getMatchCount() {
		return this.winningNumbers.size();
	}

	@Override
	public String toString() {
		return this.numbers.getSortedList().toString();
	}
}

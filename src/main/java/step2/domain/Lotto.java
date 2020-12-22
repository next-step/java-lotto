package step2.domain;

public class Lotto {

	private final LottoNumbers numbers;

	public Lotto(final LottoNumbers numbers) {
		this.numbers = numbers;
	}

	public LottoNumbers getNumbers() {
		return this.numbers;
	}

	public LottoNumbers getWinningNumbers(final LottoNumbers winNumbers) {
		return this.numbers.getWinningNumbers(winNumbers);
	}

	public int getMatchCount(final LottoNumbers winNumbers) {
		return this.getWinningNumbers(winNumbers).size();
	}

	public boolean matchesBonusNumber(final LottoNumber bonusNumber) {
		return this.numbers.getNumbers().contains(bonusNumber);
	}

	@Override
	public String toString() {
		return this.numbers.getSortedList().toString();
	}

}

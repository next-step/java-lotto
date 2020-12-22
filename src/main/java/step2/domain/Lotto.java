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

	public void confirmWinning(final LottoNumbers winNumbers) {
		this.winningNumbers = this.numbers.getWinningNumbers(winNumbers);
	}

	public LottoNumbers getWinningNumbers() {
		return winningNumbers;
	}

	public int getMatchCount() {
		if (this.winningNumbers == null) {
			throw new RuntimeException("아직 당첨 확인이 안되었습니다.");
		}
		return this.winningNumbers.size();
	}

	public boolean matchesBonusNumber(final LottoNumber bonusNumber) {
		return this.numbers.getNumbers().contains(bonusNumber);
	}

	@Override
	public String toString() {
		return this.numbers.getSortedList().toString();
	}
}

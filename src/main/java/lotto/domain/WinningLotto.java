package lotto.domain;

public class WinningLotto {
	private final Lotto winningNumbers;
	private final LottoNumber bonusNumber;

	public WinningLotto(String winningNumbers, int bonusNumber) {
		this.winningNumbers = Lotto.createFromString(winningNumbers);
		this.bonusNumber = LottoNumber.of(bonusNumber);
	}

	public Lotto getWinningNumbers() {
		return winningNumbers;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}

	public Rank match(Lotto lotto) {
		int matchCount = lotto.matchCount(winningNumbers);
		boolean containsBonus = lotto.isContains(bonusNumber);
		return Rank.from(matchCount, containsBonus);
	}
}
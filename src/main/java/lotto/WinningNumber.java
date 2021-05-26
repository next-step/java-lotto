package lotto;

public class WinningNumber {

	private final Lotto winLotto;
	private final LottoNumber bonusBall;

	public WinningNumber(Lotto winLotto, LottoNumber bonusBall) {
		validateBonusNumber(winLotto, bonusBall);

		this.winLotto = winLotto;
		this.bonusBall = bonusBall;
	}

	public Rank resultOf(Lotto lotto) {
		return Rank.valueOf(
			lotto.matchCount(winLotto),
			lotto.contains(bonusBall));
	}

	private void validateBonusNumber(Lotto winLotto, LottoNumber bonusNumber) {
		if (winLotto.contains(bonusNumber)) {
			throw new InvalidNumberSetException("Bonus number must not be duplicate with the winning number.");
		}
	}
}

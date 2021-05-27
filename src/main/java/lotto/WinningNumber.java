package lotto;

public class WinningNumber {

	private final Lotto winLotto;
	private final LottoNumber bonusBall;

	public WinningNumber(Lotto winLotto, LottoNumber bonusBall) {
		validateBonusNumber(winLotto, bonusBall);

		this.winLotto = winLotto;
		this.bonusBall = bonusBall;
	}

	private static void validateBonusNumber(Lotto winLotto, LottoNumber bonusNumber) {
		if (winLotto.contains(bonusNumber)) {
			throw new InvalidNumberSetException("보너스 숫자는 당첨번호에 포함될 수 없습니다.");
		}
	}

	public Rank resultOf(Lotto lotto) {
		return Rank.valueOf(
			lotto.matchCount(winLotto),
			lotto.contains(bonusBall));
	}
}

package lotto;

public class WinningLotto {

	private final Lotto winningNumber;
	private final LottoNumber bonusBall;

	public WinningLotto(Lotto winningNumber, LottoNumber bonusBall) {
		validateBonusBall(winningNumber, bonusBall);

		this.winningNumber = winningNumber;
		this.bonusBall = bonusBall;
	}

	private static void validateBonusBall(Lotto winningNumber, LottoNumber bonusBall) {
		if (winningNumber.contains(bonusBall)) {
			throw new InvalidNumberSetException("보너스 숫자는 당첨번호에 포함될 수 없습니다.");
		}
	}

	public Rank resultOf(Lotto lotto) {
		return Rank.valueOf(
			lotto.matchCount(winningNumber),
			lotto.contains(bonusBall));
	}
}

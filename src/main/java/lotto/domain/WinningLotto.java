package lotto.domain;

public final class WinningLotto {
	private final Lotto winningLotto;
	private final LottoNumber bonus;

	public WinningLotto(final Lotto winningLotto, final LottoNumber bonus) {
		this.winningLotto = winningLotto;
		this.bonus = bonus;
	}

	public Rank calculateRank(final Lotto lotto) {
		int matchingCount = winningLotto.countMatchingNumber(lotto);
		boolean containsBonusNumber = lotto.contains(bonus);

		return Rank.findRank(matchingCount, containsBonusNumber);
	}

	public LottoResult match(final Lottos entireLotto) {
		return entireLotto.updateRankCount(this);
	}
}

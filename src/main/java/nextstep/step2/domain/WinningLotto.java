package nextstep.step2.domain;

public class WinningLotto {
	private Lotto lastWeekLotto;
	private LottoNumber bonusNumber;

	public WinningLotto(Lotto lastWeekLotto, LottoNumber bonusNumber) {
		this.lastWeekLotto = lastWeekLotto;
		this.bonusNumber = bonusNumber;
	}

	public LottoReward getLottoReward(Lotto lotto) {
		long matchCount = getMatchCount(lotto);
		boolean hasBonusNumber = hasBonusNumber(lotto, bonusNumber);
		return LottoReward.getReword(Math.toIntExact(matchCount), hasBonusNumber);
	}

	protected boolean hasBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
		return lotto.getNumbers().contains(bonusNumber);
	}

	private long getMatchCount(Lotto lotto) {
		return lotto.getNumbers().stream()
				.filter(number -> lastWeekLotto.getNumbers().contains(number))
				.count();
	}
}

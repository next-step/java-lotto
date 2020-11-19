package nextstep.step2.domain;

public class WinningLotto {
	private LottoReward lottoReward;

	public WinningLotto(Lotto lotto, Lotto lastWeekLotto, LottoNumber bonusNumber) {
		lastWeekLotto.validate();
		long matchCount = getMatchCount(lotto, lastWeekLotto);
		boolean hasBonusNumber = hasBonusNumber(lotto, bonusNumber);
		lottoReward = LottoReward.getReword(Math.toIntExact(matchCount), hasBonusNumber);
	}

	protected boolean hasBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
		return lotto.getNumbers().contains(bonusNumber);
	}

	private long getMatchCount(Lotto lotto, Lotto lastWeekLotto) {
		return lotto.getNumbers().stream()
				.filter(number -> lastWeekLotto.getNumbers().contains(number))
				.count();
	}

	public LottoReward getLottoReward() {
		return lottoReward;
	}
}

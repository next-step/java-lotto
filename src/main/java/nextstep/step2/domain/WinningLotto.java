package nextstep.step2.domain;

public class WinningLotto {
	private LottoReward lottoReward;
	public WinningLotto(Lotto lotto, Lotto lastWeekLotto) {
		lastWeekLotto.validate();
		long matchCount = getMatchCount(lotto, lastWeekLotto);
		lottoReward = LottoReward.getReword(Math.toIntExact(matchCount));
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

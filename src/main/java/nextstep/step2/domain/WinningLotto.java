package nextstep.step2.domain;

import java.util.List;

public class WinningLotto {
	private LottoReward lottoReward;
	public WinningLotto(Lotto lotto, List<Integer> winnerNumbers) {
		long matchCount = getMatchCount(lotto, winnerNumbers);
		lottoReward = LottoReward.getReword(Math.toIntExact(matchCount));
	}

	private long getMatchCount(Lotto lotto, List<Integer> winnerNumbers) {
		return lotto.getNumbers().stream()
					.filter(number -> winnerNumbers.contains(number))
					.count();
	}

	public LottoReward getLottoReward() {
		return lottoReward;
	}
}

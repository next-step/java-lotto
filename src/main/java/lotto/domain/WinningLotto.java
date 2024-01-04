package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Map<Rank, Integer> match(final List<Lotto> entireLotto) {
		Map<Rank, Integer> result = initializeLottoRankResultMap();
		for (Lotto lotto : entireLotto) {
			Rank rank = calculateRank(lotto);
			result.replace(rank, result.get(rank) + 1);
		}

		return result;
	}

	private Map<Rank, Integer> initializeLottoRankResultMap() {
		Map<Rank, Integer> lottoResultMap = new HashMap<>();
		for (Rank rank : Rank.values()) {
			lottoResultMap.put(rank, 0);
		}

		return lottoResultMap;
	}
}

package lotto.modal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

	private final List<LottoRankCounter> lottoRankCounters;

	public LottoResult(List<Lotto> lottoPackage, Lotto winnerLotto) {
		this.lottoRankCounters = LottoRankAggregation(lottoPackage, winnerLotto);
	}

	public BigDecimal report(Money money) {
		long totalPrize = 0;

		for (LottoRankCounter rank : lottoRankCounters) {
			totalPrize += (long)rank.getCount() * rank.getPrize();
		}
		return money.getYield(totalPrize);
	}

	private static List<LottoRankCounter> LottoRankAggregation(List<Lotto> lottoPackage, Lotto winnerLotto) {
		List<LottoRankCounter> counters = initLottoRankCounter();

		for (Lotto lotto : lottoPackage) {
			LottoRank rank = LottoRank.getRank(lotto.getMatchCount(winnerLotto));
			counters.get(rank.ordinal()).increaseCount();
		}
		return counters;
	}

	private static List<LottoRankCounter> initLottoRankCounter() {
		return Arrays.stream(LottoRank.values())
			.map(LottoRankCounter::new)
			.collect(Collectors.toList());
	}

	public List<LottoRankCounter> getLottoRankCounters() {
		return this.lottoRankCounters;
	}
}

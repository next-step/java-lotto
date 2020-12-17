package lotto.modal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

	private final List<LottoRankCounter> lottoRankCounters;
	private final Map<LottoRank, Integer> lottoRankResult;

	public LottoResult(List<Lotto> lottoPackage, Lotto winnerLotto) {
		this.lottoRankResult = resultAggregation(lottoPackage, winnerLotto);
		this.lottoRankCounters = null;
	}

	public BigDecimal report(Money money) {
		long totalPrize = 0;

		for (LottoRank rank : lottoRankResult.keySet()) {
			totalPrize += (long)lottoRankResult.get(rank) * rank.getWinnerPrize();
		}

		return money.getYield(totalPrize);
	}

	private static Map<LottoRank, Integer> resultAggregation(List<Lotto> lottoPackage, Lotto winnerLotto) {
		Map<LottoRank, Integer> lottoResult = initLottoRankResult();

		for (Lotto lotto : lottoPackage) {
			LottoRank rank = LottoRank.getRank(lotto.getMatchCount(winnerLotto));
			lottoResult.put(rank, lottoResult.get(rank) + 1);
		}

		return lottoResult;
	}

	private static List<LottoRankCounter> initLottoRankCounter() {
		return Arrays.stream(LottoRank.values())
			.map(LottoRankCounter::new)
			.collect(Collectors.toList());
	}

	private static Map<LottoRank, Integer> initLottoRankResult() {
		Map<LottoRank, Integer> result = new LinkedHashMap<>();

		for (LottoRank rank : LottoRank.values()) {
			result.put(rank, 0);
		}
		return result;
	}

	public Map<LottoRank, Integer> getLottoRankResult() {
		return lottoRankResult;
	}
}

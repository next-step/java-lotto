package lotto.modal;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

	private final Map<LottoRank, Integer> lottoRankResult;
	private BigDecimal yield;

	public LottoResult(List<Lotto> lottoPackage, Lotto winnerLotto) {
		this.lottoRankResult = initLottoRankResult();
		resultAggregation(lottoPackage, winnerLotto);
	}

	private Map<LottoRank, Integer> initLottoRankResult() {
		Map<LottoRank, Integer> result = new LinkedHashMap<>();
		for (LottoRank rank : LottoRank.values()) {
			result.put(rank, 0);
		}
		return result;
	}

	private void resultAggregation(List<Lotto> lottoPackage, Lotto winnerLotto) {
		for (Lotto lotto : lottoPackage) {
			LottoRank rank = LottoRank.getRank(lotto.getMatchCount(winnerLotto));
			lottoRankResult.put(rank, lottoRankResult.get(rank) + 1);
		}
	}

	public void report(Money money) {
		int totalPrize = 0;

		for (LottoRank rank : lottoRankResult.keySet()) {
			totalPrize += lottoRankResult.get(rank) * rank.getWinnerPrize();
		}

		this.yield = money.getYield(totalPrize);
	}

	public BigDecimal getYield() {
		return yield;
	}

	public Map<LottoRank, Integer> getLottoRankResult() {
		return lottoRankResult;
	}
}

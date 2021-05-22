package wootecam.lotto.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LottoScoreMap {

	public static final int LOTTO_AMOUNT = 1_000;
	private final Map<LottoResult, Integer> lottoScores;

	public LottoScoreMap() {
		this.lottoScores = new ConcurrentHashMap<>();
		this.initLottoScores();
	}

	private void initLottoScores() {
		for (LottoResult result : LottoResult.values()) {
			this.lottoScores.put(result, 0);
		}
	}

	public void updateScore(LottoResult lottoResult) {
		this.lottoScores.computeIfPresent(lottoResult, (LottoResult, value) -> ++value);
	}

	public Map<LottoResult, Integer> getLottoScores() {
		return this.lottoScores;
	}

	public double getEarningRate() {
		int totalCount = 0;
		int winningPrizeMoney = 0;
		for (LottoResult lottoResult : this.lottoScores.keySet()) {
			int resultCount = this.lottoScores.get(lottoResult);
			int resultPrizeMoney = lottoResult.getWinningMoney() * resultCount;
			totalCount += resultCount;
			winningPrizeMoney += resultPrizeMoney;
		}
		return (double)winningPrizeMoney / (totalCount * LOTTO_AMOUNT);
	}

}

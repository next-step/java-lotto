package wootecam.lotto.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LottoScoreMap {

	private final Map<LottoResult, Integer> lottoScores;

	private double earningRate;

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
}

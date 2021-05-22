package wootecam.lotto.core;

import java.util.List;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoResult;
import wootecam.lotto.model.LottoScoreMap;

public class LottoResultGenerator {

	private LottoResult getLottoResult(Lotto targetLotto, Lotto winningLotto) {
		int matchCount = targetLotto.getNumberMatchCount(winningLotto);
		return LottoResult.findByMatchedCount(matchCount);
	}

	public LottoScoreMap getLottoResults(List<Lotto> lottos, Lotto winningLotto) {
		LottoScoreMap lottoScoreMap = new LottoScoreMap();

		for (Lotto lotto : lottos) {
			LottoResult lottoResult = this.getLottoResult(lotto, winningLotto);
			lottoScoreMap.updateScore(lottoResult);
		}

		return lottoScoreMap;
	}
}

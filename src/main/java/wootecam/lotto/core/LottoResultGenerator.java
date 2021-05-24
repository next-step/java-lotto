package wootecam.lotto.core;

import java.util.List;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoResult;
import wootecam.lotto.model.LottoScoreMap;
import wootecam.lotto.model.WinningLotto;

public class LottoResultGenerator {

	private LottoResult getLottoResult(Lotto targetLotto, WinningLotto winningLotto) {
		int matchCount = targetLotto.getNumberMatchCount(winningLotto);
		boolean isMatchedBonus = winningLotto.containsBonusNumber(targetLotto);
		return LottoResult.findByMatchedCount(matchCount, isMatchedBonus);
	}

	public LottoScoreMap getLottoResults(List<Lotto> lottos, WinningLotto winningLotto) {
		LottoScoreMap lottoScoreMap = new LottoScoreMap();

		for (Lotto lotto : lottos) {
			LottoResult lottoResult = this.getLottoResult(lotto, winningLotto);
			lottoScoreMap.updateScore(lottoResult);
		}

		return lottoScoreMap;
	}
}

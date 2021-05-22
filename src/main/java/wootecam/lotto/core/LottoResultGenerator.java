package wootecam.lotto.core;

import java.util.List;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoResult;

public class LottoResultGenerator {
	public LottoResult getLottoResult(Lotto targetLotto, Lotto winningLotto) {
		int matchCount = this.getMatchCount(targetLotto, winningLotto);
		return LottoResult.findByMatchedCount(matchCount);
	}

	public int getMatchCount(Lotto targetLotto, Lotto winningLotto) {
		List<Integer> lottoNumbers = targetLotto.getLottoNumbers();
		List<Integer> winningNumbers = winningLotto.getLottoNumbers();

		return (int)lottoNumbers.stream()
			.filter(winningNumbers::contains)
			.count();
	}
}

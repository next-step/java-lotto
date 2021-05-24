package lotto;

import java.util.List;

public class LottoResult {
	private final List<LottoPrizeType> lottoResults;

	private LottoResult(List<LottoPrizeType> lottoResults) {
		this.lottoResults = lottoResults;
	}

	public static LottoResult of(List<LottoPrizeType> lottoResults) {
		return new LottoResult(lottoResults);
	}

	public long getNumberOfLottosMatchedWith(int matchedNumberCount) {
		return lottoResults.stream()
				.filter(it -> it.getMatchedNumberCount() == matchedNumberCount)
				.count();
	}
}

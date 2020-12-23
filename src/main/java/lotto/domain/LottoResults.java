package lotto.domain;

import java.util.Collections;
import java.util.List;

import lotto.utils.ValidationUtils;

public class LottoResults {
	private final List<LottoResult> lottoResults;

	public LottoResults(List<LottoResult> lottoResults) {
		ValidationUtils.validateEmpty(lottoResults);
		this.lottoResults = Collections.unmodifiableList(lottoResults);
	}

	public LottoResult findLottoResult(LottoRank lottoRank) {
		return lottoResults.stream()
			.filter(lottoResult -> lottoResult.isEqualRank(lottoRank))
			.findFirst()
			.orElse(new LottoResult(lottoRank, 0));
	}

	public double calculateReturnRate() {
		return (double)sumTotalPrize() / (double)getPurchasePrice();
	}

	private int sumTotalPrize() {
		return lottoResults.stream()
			.mapToInt(LottoResult::getTotalPrize)
			.sum();
	}

	private int getPurchasePrice() {
		return getTotalLottoLotteriesCount() * LottoLottery.LOTTO_PRICE_PER_PIECE;
	}

	private int getTotalLottoLotteriesCount() {
		return lottoResults.stream()
			.mapToInt(LottoResult::getWinnerCount)
			.sum();
	}
}

package lotto.domain.result;

import lotto.LottoTVShow;
import lotto.domain.Lotto;
import lotto.domain.input.LottoBuyCount;
import lotto.domain.input.Money;
import lotto.model.LottoPrizePolicy;

public class LottoPrizeAnalysisResult {

	private Money totalPrizeMoney = new Money(0);;

	private EarningsRate earningsRate = new EarningsRate();

	public LottoPrizeAnalysisResult(LottoMatchResultList lottoMatchResultList) {
		for (MatchResultPerLotto lottoResult : lottoMatchResultList.getLottoMatchResults()) {
			this.totalPrizeMoney = calculateLottoPrize(lottoResult, this.totalPrizeMoney);
		}
		this.earningsRate.calculateEarningsRate(totalPrizeMoney, lottoMatchResultList.getLottoMatchResults(), LottoTVShow.LOTTO_PRICE_PER_SHEET);

	}

	//어떤 기능이 있는지 빠르게 파악할 수 있도록 public 주요 메서드를 상단에 배치
	public void arrangePrize(LottoMatchResultList lottoMatchCountResult, Money lottoPricePerSheet) {
		for (MatchResultPerLotto lottoResult : lottoMatchCountResult.getLottoMatchResults()) {
			this.totalPrizeMoney = calculateLottoPrize(lottoResult, this.totalPrizeMoney);
		}
		this.earningsRate.calculateEarningsRate(totalPrizeMoney, lottoMatchCountResult.getLottoMatchResults(), lottoPricePerSheet);

	}

	private Money calculateLottoPrize(MatchResultPerLotto matchResultPerLotto, Money totalPrizeMoney) {
		return LottoPrizePolicy.getPrizeMoney(matchResultPerLotto, totalPrizeMoney);
	}

	public EarningsRate getEarningsRate() {
		return earningsRate;
	}

	public Money getTotalPrizeMoney() {
		return totalPrizeMoney;
	}
}
package lotto.view;

import lotto.domain.LottoResult;
import lotto.model.LOTTO_PRIZE_POLICY;

public class ResultView {

	public ResultView() {
	}

	public void printResultUI(LottoResult lottoResult) {
		printMatchUI(lottoResult);
		printEarningRateUI(lottoResult.getEarningsRate());
	}

	public void printMatchUI(LottoResult lottoResult) {
		System.out.println(String.format("3개 일치 (%d원)- %d", LOTTO_PRIZE_POLICY.THREE_MATCH_PRIZE.getPrizeMoney(), LOTTO_PRIZE_POLICY.THREE_MATCH_PRIZE.getMatchCount()));
		System.out.println(String.format("4개 일치 (%d원)- %d", LOTTO_PRIZE_POLICY.FOUR_MATCH_PRIZE.getPrizeMoney(), LOTTO_PRIZE_POLICY.FOUR_MATCH_PRIZE.getMatchCount()));
		System.out.println(String.format("5개 일치 (%d원)- %d", LOTTO_PRIZE_POLICY.FIVE_MATCH_PRIZE.getPrizeMoney(), LOTTO_PRIZE_POLICY.FIVE_MATCH_PRIZE.getMatchCount()));
		System.out.println(String.format("6개 일치 (%d원)- %d", LOTTO_PRIZE_POLICY.SIX_MATCH_PRIZE.getPrizeMoney(), LOTTO_PRIZE_POLICY.SIX_MATCH_PRIZE.getMatchCount()));
	}

	public void printEarningRateUI(double earningRate) {
		if (earningRate < 1) {
			System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", earningRate));
		}
		if (earningRate == 1) {
			System.out.println(String.format("총 수익률은 %.2f입니다.(본전)", earningRate));
		}
		if (earningRate > 1) {
			System.out.println(String.format("총 수익률은 %.2f입니다.(수익이 생겼습니다)", earningRate));
		}
	}
}

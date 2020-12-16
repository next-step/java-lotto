package lotto.view;

import lotto.domain.LottoResult;

public class ResultView {

	public ResultView() {
	}

	public void printMatchUI(LottoResult lottoResult) {
		System.out.println(String.format("3개 일치 (%d원)- %d",lottoResult.THREE_MATCH_PRIZE_MONEY, lottoResult.getThreeMatchCount()));
		System.out.println(String.format("4개 일치 (%d원)- %d",lottoResult.FOUR_MATCH_PRIZE_MONEY, lottoResult.getFourMatchCount()));
		System.out.println(String.format("5개 일치 (%d원)- %d",lottoResult.FIVE_MATCH_PRIZE_MONEY, lottoResult.getFiveMatchCount()));
		System.out.println(String.format("6개 일치 (%d원)- %d",lottoResult.SIX_MATCH_PRIZE_MONEY, lottoResult.getSixMatchCount()));
	}

	public void printEarningRateUI(double earningRate) {
		if (earningRate < 1){
			System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", earningRate));
		}
		if(earningRate == 1){
			System.out.println(String.format("총 수익률은 %.2f입니다.(본전)", earningRate));
		}
		if(earningRate > 1){
			System.out.println(String.format("총 수익률은 %.2f입니다.(수익이 생겼습니다)", earningRate));
		}
	}

	public void printResultUI(LottoResult lottoResult) {
		printMatchUI(lottoResult);
		printEarningRateUI(lottoResult.getEarningsRate());
	}

}

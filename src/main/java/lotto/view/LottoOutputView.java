package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoRankCount;
import lotto.domain.Lottos;

public class LottoOutputView {

	private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
	private static final String WINNING_STATISTICS = "당첨 통계";
	private static final String LINE = "---------";
	private static final String MATCHES_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
	private static final String YIELD_MESSAGE = "총 수익률은 %f 입니다.\n";

	public void printLottos(Lottos lottos) {
		System.out.println(lottos.toString());
	}

	public void printPurchaseLottoCount(int lottoCount) {
		System.out.printf(PURCHASE_LOTTO_COUNT_MESSAGE, lottoCount);
	}

	public void printWinningStatistics(LottoRankCount lottoRankCount) {
		System.out.println(WINNING_STATISTICS);
		System.out.println(LINE);
		System.out.printf(MATCHES_RESULT_MESSAGE, LottoRank.FIRST.getMatches(), LottoRank.FIRST.getReward(),
			lottoRankCount.getFirstCount());
		System.out.printf(MATCHES_RESULT_MESSAGE, LottoRank.SECOND.getMatches(), LottoRank.SECOND.getReward(),
			lottoRankCount.getSecondCount());
		System.out.printf(MATCHES_RESULT_MESSAGE, LottoRank.THIRD.getMatches(), LottoRank.THIRD.getReward(),
			lottoRankCount.getThirdCount());
		System.out.printf(MATCHES_RESULT_MESSAGE, LottoRank.FOURTH.getMatches(), LottoRank.FOURTH.getReward(),
			lottoRankCount.getFourthCount());
	}

	public void printYield(double yield) {
		System.out.printf(YIELD_MESSAGE, yield);
	}

}

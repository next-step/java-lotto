package lotto.view;

import lotto.domain.*;

import java.util.List;

public class ResultView {
	public static final String BUY_LOTTO_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
	public static final String WiNNING_RESULT_MESSAGE = "당첨 통계";
	public static final String SEPARATE_BAR = "---------";
	public static final String RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
	public static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.(본전일 경우 - 1)";

	public void printOfBuyLotto(int manualCount, LottoGame lottoGame) {
		System.out.printf(BUY_LOTTO_MESSAGE, manualCount, lottoGame.countOfAutoLotto(manualCount));
		for (Lotto lotto : lottoGame.getLottos()) {
			System.out.println(lotto.sortNumbers());
		}
	}

	public void printWinningResult(List<Rank> userLottoRank) {
		System.out.println(WiNNING_RESULT_MESSAGE);
		System.out.println(SEPARATE_BAR);
		for (LottoResult result : LottoResult.matchResult(userLottoRank)) {
			System.out.printf(RESULT_MESSAGE, result.getMatchCount(), result.getPrize(), result.countWinningLotto());
		}
	}

	public void printProfit(double winningProfit){
		System.out.printf(TOTAL_PROFIT_MESSAGE, winningProfit);
	}

}
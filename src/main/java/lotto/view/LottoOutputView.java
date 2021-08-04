package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lotto.model.LottoGame;
import lotto.model.Prize;
import lotto.utils.PrizeComparator;
import lotto.utils.Utils;

public class LottoOutputView {

	private static final String RESULT_START_MESSAGE = "당첨 통계";
	private static final String DASH_LINE = "---------";
	public static final int ZERO_POINT = 0;

	public static void lottoNumbersList(List<LottoGame> resultLottoGame) {
		for (LottoGame lottoGame : resultLottoGame) {
			lottoGameView(lottoGame);
		}
		System.out.print("\n");
	}

	private static void lottoGameView(LottoGame lottoGame) {
		System.out.println(lottoGame.getLottoGame());
	}

	public static void resultLottoPrizeView(Map<Prize, Integer> resultLottoStatus, int money) {
		System.out.println(RESULT_START_MESSAGE);
		System.out.println(DASH_LINE);
		int getTotalWinMoney = getTotalWinMoney(resultLottoStatus);
		for (Prize result : getSortByResultValue(resultLottoStatus)) {
			getResultStatusPrint(resultLottoStatus, result);
		}
		System.out.println("총 수익률은 " + Utils.getPrizeEarningRate(getTotalWinMoney, money) + "입니다.");
	}

	private static List<Prize> getSortByResultValue(Map<Prize, Integer> resultLottoStatus) {
		List<Prize> resultPrize = new ArrayList<>(resultLottoStatus.keySet());
		resultPrize.sort(new PrizeComparator());
		return resultPrize;
	}

	private static int getTotalWinMoney(Map<Prize, Integer> resultLottoStatus) {
		int sum = 0;
		for (Prize winnerResult : resultLottoStatus.keySet()) {
			sum += (winnerResult.getWinningMoney() * resultLottoStatus.get(winnerResult));
		}
		return sum;
	}

	private static void getResultStatusPrint(Map<Prize, Integer> resultLottoStatus, Prize result) {
		if (result.getWinningMoney() > ZERO_POINT) {
			System.out.println(result.getCountOfMatch() +
				"개 일치" +
				"(" + result.getWinningMoney() + ")" +
				"-" + resultLottoStatus.get(result) + "개");
		}
	}
}

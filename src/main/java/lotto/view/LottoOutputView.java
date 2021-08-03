package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lotto.model.LottoGame;
import lotto.model.Prize;
import lotto.utils.Utils;

public class LottoOutputView {

	private static final String RESULT_START_MESSAGE = "당첨 통계";
	private static final String DASH_LINE = "---------";

	public static void resultLottoNumbers(List<LottoGame> resultLottoGame) {
		for (LottoGame lottoGame : resultLottoGame) {
			lottoGameView(lottoGame);
		}
		System.out.print("\n");
	}

	private static void lottoGameView(LottoGame lottoGame) {
		System.out.println(lottoGame.getLottoGame());
	}

	public static void resultLottoView(Map<Prize, Integer> resultLottoStatus, int money) {
		System.out.println(RESULT_START_MESSAGE);
		System.out.println(DASH_LINE);
		int getTotalWinMoney = getTotalWinMoney(resultLottoStatus);
		for (Prize result : getSortByResultValue(resultLottoStatus)) {
			getResultStatusPrint(resultLottoStatus, result);
		}
		System.out.println("총 수익률은 " + Utils.returnPercent(getTotalWinMoney, money) + "입니다.");
	}

	private static List<Prize> getSortByResultValue(Map<Prize, Integer> resultLottoStatus) {
		List<Prize> resultPrize = new ArrayList<>(resultLottoStatus.keySet());
		resultPrize.sort(Collections.reverseOrder());
		return resultPrize;
	}

	private static int getTotalWinMoney(Map<Prize, Integer> resultLottoStatus) {
		return resultLottoStatus.keySet()
			.stream()
			.mapToInt(winnerResult -> (winnerResult.getWinningMoney() * resultLottoStatus.get(winnerResult)))
			.sum();
	}

	private static void getResultStatusPrint(Map<Prize, Integer> resultLottoStatus, Prize result) {
		if (result.getWinningMoney() > 0) {
			System.out.println(result.getCountOfMatch() +
				"개 일치" +
				"(" + result.getWinningMoney() + ")" +
				"-" + resultLottoStatus.get(result) + "개");
		}
	}
}

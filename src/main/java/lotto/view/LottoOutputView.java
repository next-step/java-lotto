package lotto.view;

import java.util.List;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinPrizes;
import lotto.utils.PrizeRate;

public class LottoOutputView {

	private static final String RESULT_START_MESSAGE = "당첨 통계";
	private static final String DASH_LINE = "---------";
	public static final int ZERO_POINT = 0;

	public static void lottoNumbersList(List<Lotto> resultLotto) {
		for (Lotto lotto : resultLotto) {
			lottoGameView(lotto);
		}
		System.out.print("\n");
	}

	private static void lottoGameView(Lotto lotto) {
		System.out.println(lotto.getLotto());
	}

	public static void resultLottoPrizeView(WinPrizes winPrizes, int money) {
		System.out.println(RESULT_START_MESSAGE);
		System.out.println(DASH_LINE);
		int totalWinningMoney = winPrizes.getTotalWinningMoney();
		for (Prize result : winPrizes.resultWinPrizes()) {
			getResultStatusPrint(winPrizes, result);
		}
		System.out.println("총 수익률은 " + PrizeRate.getPrizeEarningRate(totalWinningMoney, money) + "입니다.");
	}

	private static void getResultStatusPrint(WinPrizes winPrizes, Prize result) {
		if (result.getWinningMoney() > ZERO_POINT) {
			System.out.println(winPrizes.winPrizeStatus(result));
		}
	}

}

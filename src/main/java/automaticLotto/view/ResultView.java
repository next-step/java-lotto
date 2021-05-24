package automaticLotto.view;

import java.util.Map;

import automaticLotto.domain.Lotto;
import automaticLotto.domain.Lottos;
import automaticLotto.domain.RankingTable;
import automaticLotto.domain.WinnerStatics;

public class ResultView {
	public static void printBoughtLottos(Lottos boughtLottos) {
		System.out.println(boughtLottos.size() + "개를 구매했습니다.");
		for (Lotto lotto : boughtLottos.getLottos()) {
			System.out.println(lotto);
		}
		System.out.println();
	}

	public static void printWinnerStatics(WinnerStatics winnerStatics) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");

		Map<Integer, Integer> winnerCountByMatchedNumber = winnerStatics.presentAllCount();
		for (int matchedCount : winnerCountByMatchedNumber.keySet()) {
			System.out.println(matchedCount + "개 일치 (" + RankingTable.getWinnerPrice(matchedCount) + "원)- "
				+ winnerCountByMatchedNumber.get(matchedCount) + "개");
		}
	}

	public static void printProfit(WinnerStatics winnerStatics) {
		String profit = "이익이";

		if (winnerStatics.getProfitRate() == 1) {
			profit = "쌤썜이";
		}

		if (winnerStatics.getProfitRate() < 1) {
			profit = "손해";
		}

		System.out.println(
			"총 수익률은 " + String.format("%.2f", winnerStatics.getProfitRate()) + "입니다.(기준이 1이기 때문에 결과적으로 " + profit
				+ "라는 의미임)");
	}
}

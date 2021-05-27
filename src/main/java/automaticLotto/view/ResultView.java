package automaticLotto.view;

import automaticLotto.domain.Lottos;
import automaticLotto.domain.Ranking;
import automaticLotto.domain.WinnerStatics;

public class ResultView {
	public static void printBoughtLottos(Lottos boughtLottos) {
		System.out.println(boughtLottos.size() + "개를 구매했습니다.");
		boughtLottos.forEachLottos(System.out::println);
		System.out.println();
	}

	public static void printWinnerStatics(WinnerStatics winnerStatics) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");

		for (Ranking ranking : Ranking.values()) {
			if (ranking == Ranking.RANKING_LAST) {
				continue;
			}

			if (ranking == Ranking.RANKING_1.RANKING_2) {
				System.out.println(
					ranking.getMatchedCount() + "개 일치, 보너스볼 일치 (" + ranking.getWinnerPrice() + "원)- "
						+ winnerStatics.presentCount(ranking) + "개");
				continue;
			}

			System.out.println(
				ranking.getMatchedCount() + "개 일치 (" + ranking.getWinnerPrice() + "원)- "
					+ winnerStatics.presentCount(ranking) + "개");
		}
	}

	public static void printProfit(WinnerStatics winnerStatics) {
		System.out.println(
			"총 수익률은 " + winnerStatics.getProfitRate() + "입니다.(기준이 1이기 때문에 결과적으로 " + winnerStatics.getProfitResult()
				+ "라는 의미임)");
	}
}

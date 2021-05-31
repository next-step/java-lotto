package lotto;

import static lotto.Rank.*;

import java.util.Map;

import lotto.shop.Lottos;

public class ResultView {

	public static void printBuyResult(Lottos lottos, int manualCount) {
		System.out.println(
			"\n" + String.format(
					"수동으로 %d장, 자동으로 %d장을 구매했습니다.",
					manualCount, lottos.count() - manualCount));
		lottos.values().forEach(System.out::println);
	}

	public static void printWinningResult(GameResult result) {
		System.out.println("\n당첨 통계");
		System.out.println("---------");

		Map<Rank, Integer> dashboard = result.dashboard();

		System.out.printf(
			"3개 일치 (%d원)- %d개\n"
			+ "4개 일치 (%d원)- %d개\n"
			+ "5개 일치 (%d원)- %d개\n"
			+ "5개 일치, 보너스 볼 일치(%d원)- %d개\n"
			+ "6개 일치 (%d원)- %d개\n"
			+ "총 수익률은 %.2f입니다.\n",
			FOURTH.award(), dashboard.get(FIFTH),
			FOURTH.award(), dashboard.get(FOURTH),
			THIRD.award(), dashboard.get(THIRD),
			SECOND.award(), dashboard.get(SECOND),
			FIRST.award(), dashboard.get(FIRST),
			result.earningRate()
		);
	}
}

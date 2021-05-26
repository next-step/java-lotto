package lotto;

import static lotto.Rank.*;

import java.util.Map;

public class ResultView {

	public static void printBuyResult(Lottos lottos) {
		System.out.println(lottos.count() + "개를 구매했습니다.");
		lottos.values().forEach(System.out::println);
		System.out.println();
	}

	public static void printWinningResult(WinningResult result) {
		System.out.println("당첨 통계");
		System.out.println("---------");

		Map<Rank, Integer> dashboard = result.dashboard();

		System.out.printf(
			"3개 일치 (%d원)- %d개\n"
			+ "4개 일치 (%d원)- %d개\n"
			+ "5개 일치 (%d원)- %d개\n"
			+ "5개 일치, 보너스 볼 일치(%d원)- %d개\n"
			+ "6개 일치 (%d원)- %d개\n"
			+ "총 수익률은 %.2f입니다.\n",
			FOURTH_PRIZE.award(), dashboard.get(FIFTH_PRIZE),
			FOURTH_PRIZE.award(), dashboard.get(FOURTH_PRIZE),
			THIRD_PRIZE.award(), dashboard.get(THIRD_PRIZE),
			SECOND_PRIZE.award(), dashboard.get(SECOND_PRIZE),
			FIRST_PRIZE.award(), dashboard.get(FIRST_PRIZE),
			result.earningRate()
		);
	}
}

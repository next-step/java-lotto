package lotto;

import static lotto.Winner.*;

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

		Map<Winner, Integer> dashboard = result.dashboard();

		System.out.printf(
			"3개 일치 (%d원)- %d개\n"
			+ "4개 일치 (%d원)- %d개\n"
			+ "5개 일치 (%d원)- %d개\n"
			+ "6개 일치 (%d원)- %d개\n"
			+ "총 수익률은 %.2f입니다.\n",
			FOURTH_PRIZE.prize, dashboard.get(FOURTH_PRIZE),
			THIRD_PRIZE.prize, dashboard.get(THIRD_PRIZE),
			SECOND_PRIZE.prize, dashboard.get(SECOND_PRIZE),
			FIRST_PRIZE.prize, dashboard.get(FIRST_PRIZE),
			result.earningRate()
		);
	}
}

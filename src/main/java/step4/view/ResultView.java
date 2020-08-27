package step4.view;

import step4.domain.Lotto;
import step4.domain.Rank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

	private ResultView() {}

	public static void printLottos(List<Lotto> lottos) {
		System.out.println(lottos.size()+"개를 구매했습니다.");
		for (Lotto lotto : lottos) {
			System.out.println(lotto.toString());
		}
		System.out.println();
	}

	public static void printWinningResult(Map<Rank, Integer> result) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("----------");

		for (Rank winning : Arrays.stream(Rank.values()).filter(winning -> winning.getMatchingCount() != 0).collect(Collectors.toList())) {
			System.out.print(winning.getMatchingCount()+ "개 일치");
			printBonus(winning);
			System.out.println("(" + winning.getReward()+"원)- " + result.getOrDefault(winning, 0) + "개");
		}
	}

	private static void printBonus(Rank winning) {
		if (winning.isBonus()) {
			System.out.print(", 보너스 볼 일치");
		}
	}

	public static void printYield(BigDecimal yield) {
		System.out.println("총 수익률은 "+ yield + "입니다.");
	}

}

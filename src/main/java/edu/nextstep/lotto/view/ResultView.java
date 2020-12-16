package edu.nextstep.lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import edu.nextstep.lotto.domain.sub.LottoRank;

public class ResultView {

	private ResultView() {
	}

	public static void printHowManyPurchase(int number) {
		System.out.println(number + "개를 구매했습니다.");
	}

	public static void printLottos(List<List<Integer>> lottos) {
		lottos.forEach(System.out::println);
		System.out.println();
	}

	public static void printWinningStatistics(Map<LottoRank, Long> rankCountingMap) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		printRankStatistics(LottoRank.FIFTH, rankCountingMap);
		printRankStatistics(LottoRank.FOURTH, rankCountingMap);
		printRankStatistics(LottoRank.THIRD, rankCountingMap);
		printRankStatistics(LottoRank.FIRST, rankCountingMap);
	}

	private static void printRankStatistics(LottoRank rank, Map<LottoRank, Long> rankCountingMap) {
		Long count = rankCountingMap.get(rank);
		if (count == null) {
			count = 0L;
		}
		System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getReward() + "원)- " + count + "개");
	}

	public static void printProfitRatio(BigDecimal profitRatio) {
		System.out.print("총 수익률은 " + profitRatio + "입니다.");
		if(profitRatio.compareTo(BigDecimal.ONE) == -1) {
			System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
			return;
		}
		System.out.println();
	}
}
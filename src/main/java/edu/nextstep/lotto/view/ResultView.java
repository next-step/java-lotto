package edu.nextstep.lotto.view;

import java.util.List;
import java.util.Map;

import edu.nextstep.lotto.domain.LottoRank;

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
}
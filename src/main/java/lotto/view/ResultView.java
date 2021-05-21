package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Iterator;

public class ResultView {

	public static final int NONE_MATCH_COUNT = -1;

	public static void printLottoResult(LottoResult lottoResult) {
		printLottoStatistics(lottoResult);
		printProfitRate(lottoResult);
	}

	private static void printLottoStatistics(LottoResult lottoResult) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");

		HashMap<Rank, Integer> statMap = lottoResult.getStatMap();
		Iterator<Rank> rankIterator = statMap.keySet().iterator();
		while (rankIterator.hasNext()) {
			Rank rank = rankIterator.next();
			printWinner(rank, statMap);
		}
	}

	private static void printWinner(Rank rank, HashMap<Rank, Integer> statMap) {
		if (rank.getMatchCount() > NONE_MATCH_COUNT) {
			System.out.printf("%d개 일치 (%d원)- %d개\n", rank.getMatchCount(), rank.getWinningMoney(), statMap.get(rank));
		}
	}

	private static void printProfitRate(LottoResult lottoResult) {
		double profitRate = lottoResult.calculateProfitRate();
		double percentageOfRevenue = floorProfitRate(profitRate);

		System.out.printf("총 수익률은 %.2f입니다.", percentageOfRevenue);
		if (profitRate != 0 && profitRate < 1) {
			System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
		}
		System.out.println();
	}

	private static double floorProfitRate(double percentageOfRevenue) {
		return Math.floor(percentageOfRevenue * 100) / 100.0;
	}

}

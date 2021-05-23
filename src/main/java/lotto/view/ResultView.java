package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Iterator;

public class ResultView {

	public static final int NONE_MATCH_COUNT = -1;
	public static final String MESSAGE_WIN_STATISTICS = "당첨 통계";
	public static final String MESSAGE_LINE_DELIMETER = "---------";
	public static final String MESSAGE_NUMBER_OF_MATCHS_BY_RANK = "%d개 일치 (%d원)- %d개\n";
	public static final String MESSAGE_PERCENTAGE_OF_REVENUE = "총 수익률은 %.2f입니다.";
	public static final String MESSAG_RESULT_IS_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	public static void printLottoResult(LottoResult lottoResult) {
		printLottoStatistics(lottoResult);
		printProfitRate(lottoResult);
	}

	private static void printLottoStatistics(LottoResult lottoResult) {
		System.out.println();
		System.out.println(MESSAGE_WIN_STATISTICS);
		System.out.println(MESSAGE_LINE_DELIMETER);

		HashMap<Rank, Integer> statMap = lottoResult.getStatMap();
		Iterator<Rank> rankIterator = statMap.keySet().iterator();
		while (rankIterator.hasNext()) {
			Rank rank = rankIterator.next();
			printWinner(rank, statMap);
		}
	}

	private static void printWinner(Rank rank, HashMap<Rank, Integer> statMap) {
		if (rank.getMatchCount() > NONE_MATCH_COUNT) {
			System.out.printf(MESSAGE_NUMBER_OF_MATCHS_BY_RANK, rank.getMatchCount(), rank.getWinningMoney(), statMap.get(rank));
		}
	}

	private static void printProfitRate(LottoResult lottoResult) {
		double profitRate = lottoResult.calculateProfitRate();
		double percentageOfRevenue = floorProfitRate(profitRate);

		System.out.printf(MESSAGE_PERCENTAGE_OF_REVENUE, percentageOfRevenue);
		if (profitRate != 0 && profitRate < 1) {
			System.out.print(MESSAG_RESULT_IS_LOSS);
		}
		System.out.println();
	}

	private static double floorProfitRate(double percentageOfRevenue) {
		return Math.floor(percentageOfRevenue * 100) / 100.0;
	}

}

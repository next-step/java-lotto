package lotto.view;

import lotto.domain.LottoResults;
import lotto.domain.Rank;

public class ResultView {

	public static final String MESSAGE_WIN_STATISTICS = "당첨 통계";
	public static final String MESSAGE_LINE_DELIMETER = "---------";
	public static final String MESSAGE_NUMBER_OF_MATCHS_BY_RANK = "%d개 일치%s (%d원)- %d개\n";
	public static final String MESSAGE_PERCENTAGE_OF_REVENUE = "총 수익률은 %.2f입니다.";
	public static final String MESSAG_RESULT_IS_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
	public static final String MESSAGE_MATCH_BONUS = ", 보너스 볼 일치";
	public static final String MESSAGE_EMPTY = "";

	public static void printLottoResult(LottoResults lottoResults) {
		printLottoStatistics(lottoResults);
		printProfitRate(lottoResults);
	}

	private static void printLottoStatistics(LottoResults lottoResults) {
		System.out.println();
		System.out.println(MESSAGE_WIN_STATISTICS);
		System.out.println(MESSAGE_LINE_DELIMETER);

		for (Rank rank : lottoResults.getRenderRanks()) {
			int rankCount = lottoResults.findRankCount(rank);
			System.out.printf(MESSAGE_NUMBER_OF_MATCHS_BY_RANK, rank.getMatchCount(), makeBonusMessage(rank), rank.getWinningMoney(), rankCount);
		}
	}

	private static String makeBonusMessage(Rank rank) {
		if (rank.equals(Rank.SECOND)) {
			return MESSAGE_MATCH_BONUS;
		}
		return MESSAGE_EMPTY;
	}

	private static void printProfitRate(LottoResults lottoResults) {
		double profitRate = lottoResults.calculateProfitRate();
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

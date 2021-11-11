package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.domain.Rank;
import lotto.domain.Statistics;
import lotto.domain.Ticket;
import lotto.exception.UtilCreationException;

public final class ResultView {
	private static final String WINNING_STATISTICS = "\n당첨 통계";
	private static final String DIVIDING_LINE = "---------";
	private static final String WINNING_NUMBER_RESULT = "%d개 일치 (%d원)- %d개\n";
	private static final String PROFIT_RESULT = "총 수익률은 %.2f 입니다. (기준이 1이기 때문에 결과적으로 '%s'(이)라는 의미임)\n";
	private static final String PROFIT = "이익";
	private static final String LOSS = "손해";
	private static final String SAME = "동일";

	private ResultView() {
		throw new UtilCreationException();
	}

	public static void printTickets(List<Ticket> tickets) {
		StringBuilder builder = new StringBuilder();
		for (Ticket ticket : tickets) {
			builder.append(ticket);
			builder.append(System.lineSeparator());
		}
		System.out.println(builder);
	}

	public static void printStatistics(Statistics statistics) {
		System.out.println(WINNING_STATISTICS);
		System.out.println(DIVIDING_LINE);

		printMatchedResult(statistics);

		double profitRatio = statistics.getProfitRatio();
		System.out.printf(PROFIT_RESULT, profitRatio, getProfitResult(profitRatio));
	}

	private static void printMatchedResult(Statistics statistics) {
		Map<Rank, Integer> matchedResult = statistics.getMatchedResult();

		Arrays.stream(Rank.values())
			.filter(rank -> rank != Rank.MISS)
			.forEach(rank -> System.out.printf(WINNING_NUMBER_RESULT, rank.getCountOfMatch(), rank.getWinningMoney(),
				matchedResult.get(rank)));
	}

	private static String getProfitResult(double profitRatio) {
		if (profitRatio > 1) {
			return PROFIT;
		}
		if (profitRatio < 1) {
			return LOSS;
		}
		return SAME;
	}
}

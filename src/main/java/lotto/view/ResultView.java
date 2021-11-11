package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.domain.Rank;
import lotto.domain.Statistics;
import lotto.domain.Ticket;
import lotto.exception.UtilCreationException;

public final class ResultView {
	private static final String WINNING_STATISTICS = "당첨 통계\n";
	private static final String DIVIDING_LINE = "---------\n";
	private static final String WINNING_NUMBER_RESULT = "%d개 일치 (%d원)- %d개\n";
	private static final String PROFIT_RESULT = "총 수익률은 %.2f 입니다. (기준이 1이기 때문에 결과적으로 '%s'(이)라는 의미임)\n";
	private static final String PROFIT = "이익";
	private static final String LOSS = "손해";
	private static final String SAME = "동일";

	private static final StringBuilder BUILDER = new StringBuilder();

	private ResultView() {
		throw new UtilCreationException();
	}

	public static void printTickets(List<Ticket> tickets) {
		initializeBuilder();
		for (Ticket ticket : tickets) {
			appendBuilder(ticket);
			appendBuilder(System.lineSeparator());
		}
		printBuilder();
	}

	public static void printStatistics(Statistics statistics) {
		initializeBuilder();

		appendBuilder(WINNING_STATISTICS);
		appendBuilder(DIVIDING_LINE);

		appendMatchedResultToBuilder(statistics);

		double profitRatio = statistics.getProfitRatio();
		appendBuilder(String.format(PROFIT_RESULT, profitRatio, getProfitResult(profitRatio)));

		printBuilder();
	}

	private static void appendMatchedResultToBuilder(Statistics statistics) {
		Map<Rank, Integer> matchedResult = statistics.getMatchedResult();

		Arrays.stream(Rank.values())
			.filter(rank -> rank != Rank.MISS)
			.forEach(rank -> appendBuilder(
				String.format(WINNING_NUMBER_RESULT, rank.getCountOfMatch(), rank.getWinningMoney(),
					matchedResult.get(rank))));
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

	private static void initializeBuilder() {
		BUILDER.setLength(0);
	}

	private static void appendBuilder(Object input) {
		BUILDER.append(input);
	}

	private static void printBuilder() {
		System.out.println(BUILDER);
	}
}

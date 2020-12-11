package lotto.domain;

import java.util.stream.Collectors;

public class LottoMessage {
	private static final String MESSAGE = "%s개 일치 (%s원)- %s개";
	private static final String RATE_MESSAGE = "총 수익률은 %1$,.2f 입니다.";

	public static String purchasedTickets(LottoTicket lottoTicket) {
		return lottoTicket.stream()
			.map(String::valueOf)
			.collect(Collectors.joining("\n"));
	}

	public static String winningStatistics(LottoResults lottoResults) {
		return Rank.greaterThanCountZeroAndSortedAmount()
			.map(target -> String.format(MESSAGE,
				target.getMatchesCount(),
				target.getAmountMoney(),
				lottoResults.askCountOfRank(target)))
			.collect(Collectors.joining("\n"));
	}

	public static String totalProfit(int buyMoney, LottoResults lottoResults) {
		Integer totalPrizeMoney = lottoResults.getLottoResults()
			.map(LottoResult::getRankAmountMoney)
			.reduce(0, Integer::sum);

		return String.format(RATE_MESSAGE, (double) totalPrizeMoney / buyMoney);
	}
}

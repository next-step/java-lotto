package lotto.domain;

import java.util.stream.Collectors;

public class LottoMessage {
	private static final String MESSAGE = "%s개 일치 (%s원)- %s개";
	private static final String RATE_MESSAGE = "총 수익률은 %1$,.2f입니다.";

	public static String purchasedTickets(LottoTicket lottoTicket) {
		return lottoTicket.getLottoNumbers()
			.stream()
			.map(String::valueOf)
			.collect(Collectors.joining("\n"));
	}

	public static String winningStatistics(LottoResult lottoResult) {
		return Rank.greaterThanCountZeroAndSortedAmount()
			.map(target -> String.format(MESSAGE,
				target.getMatchesCount(),
				target.getAmountMoney(),
				lottoResult.askCountOfRank(target)))
			.collect(Collectors.joining("\n"));
	}

	public static String totalProfit(LottoPrice lottoPrice, LottoResult lottoResult) {
		return String.format(RATE_MESSAGE, lottoPrice.totalPrizeMoneyRate(lottoResult.totalAmountMoney()));
	}
}

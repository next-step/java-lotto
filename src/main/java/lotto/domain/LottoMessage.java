package lotto.domain;

import java.util.stream.Collectors;

public class LottoMessage {
	private static final String MESSAGE = "%s개 일치 (%s원)- %s개";
	private static final String BONUS_MESSAGE = "%s개 일치, 보너스 볼 일치(%s원)- %s개";
	private static final String RATE_MESSAGE = "총 수익률은 %1$,.2f입니다.";

	public static String purchasedTickets(LottoTicket lottoTicket) {
		return lottoTicket.getLottoNumbers()
			.stream()
			.map(String::valueOf)
			.collect(Collectors.joining("\n"));
	}

	public static String winningStatistics(LottoResult lottoResult) {
		return Rank.greaterThanCountZeroAndSortedAmount()
			.map(target -> matchesMessage(target, lottoResult.askCountOfRank(target)))
			.collect(Collectors.joining("\n"));
	}

	public static String matchesMessage(Rank target, int amount) {
		String messageFormat = MESSAGE;
		if (target.equals(Rank.SECOND)) {
			messageFormat = BONUS_MESSAGE;
		}
		return String.format(messageFormat, target.getMatchesCount(), target.getAmountMoney(), amount);
	}

	public static String totalProfit(LottoPrice lottoPrice, LottoResult lottoResult) {
		return String.format(RATE_MESSAGE, lottoPrice.totalPrizeMoneyRate(lottoResult.totalAmountMoney()));
	}
}

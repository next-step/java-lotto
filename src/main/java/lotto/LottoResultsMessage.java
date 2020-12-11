package lotto;

import java.util.stream.Collectors;

public class LottoResultsMessage {
	private static final String MESSAGE = "%s개 일치 (%s원)- %s개";
	private static final String RATE_MESSAGE = "총 수익률은 %1$,.2f 입니다.";

	private final LottoResults results;

	public LottoResultsMessage(LottoResults lottoResults) {
		this.results = lottoResults;
	}

	public String getResultMessage() {
		return Rank.greaterThanCountZeroAndSortedAmount()
			.map(target -> String.format(MESSAGE, target.getMatchesCount(), target.getAmountMoney(), this.results.askCountOfRank(target)))
			.collect(Collectors.joining("\n"));
	}

	public String getRateMessage(int buyMoney) {
		Integer totalPrizeMoney = this.results.getLottoResults()
			.map(LottoResult::getRankAmountMoney)
			.reduce(0, Integer::sum);

		return String.format(RATE_MESSAGE, (double) totalPrizeMoney / buyMoney);
	}
}

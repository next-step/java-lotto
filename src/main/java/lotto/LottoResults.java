package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {
	private static final String MESSAGE = "%s개 일치 (%s원)- %s개";
	private static final String RATE_MESSAGE = "총 수익률은 %1$,.2f 입니다.";

	private final List<LottoResult> results;

	public LottoResults(List<LottoResult> results) {
		this.results = results;
	}

	public int askCountOfRank(Rank rankType) {
		return Math.toIntExact(this.results.stream()
			.filter(result -> result.isMatchesRank(rankType))
			.count());
	}

	public String getResultMessage() {
		return Arrays.stream(Rank.values())
			.sorted(Comparator.comparingInt(Rank::getMatchesCount))
			.filter(target -> target.getAmountMoney() > 0)
			.map(target -> String.format(MESSAGE, target.getMatchesCount(), target.getAmountMoney(), askCountOfRank(target)))
			.collect(Collectors.joining("\n"));
	}

	public String getRateMessage(int buyMoney) {
		Integer sumMoney = this.results.stream()
			.map(LottoResult::getRankAmountMoney)
			.reduce(0, Integer::sum);

		return String.format(RATE_MESSAGE, (double) sumMoney / buyMoney);
	}
}

package lotto.statistics;

import java.util.HashMap;
import java.util.Map;

import lotto.LottoNumbers;
import lotto.store.Ticket;

public class StatisticsCalculator {

	private static final int WINNING_TYPE_SIZE = 4;

	private final Ticket ticket;
	private final LottoNumbers winnerLotto;
	private final Map<Integer, Statistic> statisticByMatchCount;

	public StatisticsCalculator(Ticket ticket, LottoNumbers winnerLotto) {
		this.ticket = ticket;
		this.winnerLotto = winnerLotto;
		this.statisticByMatchCount = new HashMap<>(WINNING_TYPE_SIZE);
		init();
	}

	private void init() {
		for (LottoNumbers purchased : ticket.purchasedLotto()) {
			compute(statisticByMatchCount, purchased);
		}
	}

	protected Map<Integer, Statistic> statisticsMap() {
		return statisticByMatchCount;
	}

	private void compute(Map<Integer, Statistic> mapByCount, LottoNumbers purchased) {
		int count = winnerLotto.sameCount(purchased);
		if (count < 3) {
			return;
		}
		mapByCount.putIfAbsent(count, new Statistic(0, Earn.match(count)));
		mapByCount.computeIfPresent(count, (k, v) -> v.plusMatchCount());
	}

	public int sumEarningPrice() {
		int result = 0;
		for (int matchCount : statisticByMatchCount.keySet()) {
			result += earningPriceByMatchCount(matchCount);
		}
		return result;
	}

	private int earningPriceByMatchCount(int matchCount) {
		return statisticByMatchCount.get(matchCount).earningPrice();
	}

	private StringBuffer findEarnMessage(int matchCount) {
		return statisticByMatchCount.get(matchCount).earningMessage();
	}

	@Override
	public String toString() {
		StringBuilder message = new StringBuilder("당첨 통계\n---------\n");
		for (int matchCount = 3; matchCount < 7; matchCount++) {
			if (!statisticByMatchCount.containsKey(matchCount)) {
				continue;
			}
			message.append(findEarnMessage(matchCount));
		}
		return message.toString();
	}

	public double earningRatio() {
		return (double) sumEarningPrice() / (double) ticket.budget();
	}
}

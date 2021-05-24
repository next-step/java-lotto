package lotto.statistics;

import java.util.HashMap;
import java.util.Map;

import lotto.LottoNumbers;
import lotto.store.Ticket;

public class StatisticsCalculator {

	private static final int WINNING_TYPE_SIZE = 4;
	private static final String PROFIT_MESSAGE = "이익";
	private static final String BREAK_EVENT_MESSAGE = "본전";
	private static final String LOSS_MESSAGE = "손해";

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

	private String findEarnMessage(int matchCount) {
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
		message.append(ratioResultMessage());
		return message.toString();
	}

	public double earningRatio() {
		return (double) sumEarningPrice() / (double) ticket.budget();
	}

	private String ratioResultMessage() {
		double ratio = earningRatio();
		return new StringBuilder()
			.append("총 수익률은 ")
			.append(ratio)
			.append("입니다.(기준이 1이기 때문에 결과적으로 ")
			.append(messageByRatio(ratio))
			.append("라는 의미임)")
			.toString();
	}

	private String messageByRatio(double ratio) {
		if (ratio > 0) {
			return PROFIT_MESSAGE;
		}
		if (ratio < 0) {
			return LOSS_MESSAGE;
		}
		return BREAK_EVENT_MESSAGE;
	}
}

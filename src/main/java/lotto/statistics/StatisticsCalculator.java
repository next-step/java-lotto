package lotto.statistics;

import java.util.HashMap;
import java.util.Map;

import lotto.LottoNumbers;
import lotto.store.Ticket;

public class StatisticsCalculator {

	private final Ticket ticket;
	private final LottoNumbers winnerLotto;

	public StatisticsCalculator(Ticket ticket, LottoNumbers winnerLotto) {
		this.ticket = ticket;
		this.winnerLotto = winnerLotto;
	}

	public Map<Integer, Statistic> statistics() {
		Map<Integer, Statistic> result = new HashMap<>(ticket.purchaseCount());
		for (LottoNumbers purchased : ticket.purchasedLotto()) {
			compute(result, purchased);
		}
		return result;
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
		Map<Integer, Statistic> priceByCount = statistics();
		int result = 0;
		for (int matchCount : priceByCount.keySet()) {
			result += priceByCount.get(matchCount).earningPrice();
		}
		return result;
	}

}

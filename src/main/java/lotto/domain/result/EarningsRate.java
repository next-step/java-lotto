package lotto.domain.result;

import lotto.domain.input.Money;

import java.util.List;

public class EarningsRate {

	private double earningsRate;

	public double getEarningsRate() {
		return earningsRate;
	}

	public void calculateEarningsRate(Money totalPrizeMoney, List<MatchResultPerLotto> matchResultPerLottos, Money lottoPricePerSheet) {
		this.earningsRate = (double) totalPrizeMoney.getMoney() / (matchResultPerLottos.size() * lottoPricePerSheet.getMoney());
	}
}

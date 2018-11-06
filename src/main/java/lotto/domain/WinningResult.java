package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.enums.Prize;

public class WinningResult {

	private static final int PROFIT_RATE_DECIMAL_POINRT = 2;

	private List<Prize> prizes;

	public WinningResult(List<Prize> prizes) {
		this.prizes = prizes;
	}

	public int getPrizeCount(Prize selectedPrize) {
		return (int) prizes.stream()
				.filter(prize -> prize.equals(selectedPrize))
				.count();
	}

	public double getProfitRate() {
		return calculateProfitRate(calculateBuyingMoney());
	}

	private int calculateBuyingMoney() {
		return prizes.size() * LottoMachine.LOTTO_PRICE;
	}

	public double calculateProfitRate(int money) {
		int totalPrizeMoney = 0;
		for(Prize prize : prizes) {
			totalPrizeMoney = prize.sumMoney(totalPrizeMoney);
		}
		double profitRate = (double) totalPrizeMoney / money;
		return new BigDecimal(profitRate)
				.setScale(PROFIT_RATE_DECIMAL_POINRT, RoundingMode.HALF_UP)
				.doubleValue();
	}
}

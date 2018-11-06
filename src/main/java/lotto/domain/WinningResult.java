package lotto.domain;

import java.util.List;
import lotto.enums.Prize;

public class WinningResult {

	private List<Prize> prizes;

	public WinningResult(List<Prize> prizes) {
		this.prizes = prizes;
	}

	public int getPrizeCount(Prize selectedPrize) {
		return (int) prizes.stream()
				.filter(prize -> prize.equals(selectedPrize))
				.count();
	}

	public int getProfitRate() {
		int money = calculateBuyingMoney();
		return calculateProfitRate(money);
	}

	public int calculateProfitRate(int money) {
		int totalPrizeMoney = prizes.stream()
				.mapToInt(prize -> prize.getMoney())
				.sum();
		return ((totalPrizeMoney - money) / money) * 100;
	}

	private int calculateBuyingMoney() {
		return prizes.size() * LottoMachine.LOTTO_PRICE;
	}
}

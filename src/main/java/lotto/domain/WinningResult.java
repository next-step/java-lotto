package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.Prize;

public class WinningResult {

	private List<Prize> prizes;

	public WinningResult(List<Prize> prizes) {
		this.prizes = prizes;
	}

	public static WinningResult of(WinningResult... winningResults) {
		List<Prize> prizes = new ArrayList<>();
		for (WinningResult winningResult : winningResults) {
			prizes.addAll(winningResult.prizes);
		}
		return new WinningResult(prizes);
	}

	public int getPrizeCount(Prize selectedPrize) {
		return (int) prizes.stream()
				.filter(prize -> prize.equals(selectedPrize))
				.count();
	}

	public int getTotalPrizeMoney() {
		int totalPrizeMoney = 0;
		for(Prize prize : prizes) {
			totalPrizeMoney = prize.sumMoney(totalPrizeMoney);
		}
		return totalPrizeMoney;
	}
}

package lotto;

import java.util.EnumMap;

public class Statistics {
	private final EnumMap<Prize, Integer> statusMap = new EnumMap<>(Prize.class);

	public Statistics() {
		for (Prize prize : Prize.values()) {
			statusMap.put(prize, 0);
		}
	}
	public int status(Prize prize) {
		return statusMap.get(prize);
	}

	public Profit profit() {
		return new Profit(totalWinAmount(), new Money(Store.LOTTO_PRICE * count));
	}

	private Money totalWinAmount() {
		Money winAmount = new Money(0);
		for (Prize prize : Prize.values()) {
			Money amount = prize.winAmount().multiply(statusMap.get(prize));
			winAmount = winAmount.plus(amount);
		}
		return winAmount;
	}


	public int totalCount() {
		return statusMap.keySet().stream().mapToInt(this::status).sum();
	}

	public void addCount(Prize prize) {
		statusMap.put(prize, status(prize) + 1);
	}

}

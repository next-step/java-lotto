package lotto;

import java.util.EnumMap;

public class Statistics {
	private final EnumMap<Prize, Integer> statusMap = new EnumMap<>(Prize.class);
	private final Lotto prizeLotto;
	private int count = 0;

	public Statistics(Lotto prizeLotto) {
		this.prizeLotto = prizeLotto;
		initMap();
	}

	private void initMap() {
		statusMap.clear();
		for (Prize prize : Prize.values()) {
			statusMap.put(prize, 0);
		}
	}

	public void analyze(Lottos lottos) {
		initMap();
		count = lottos.count();
		for (Lotto lotto : lottos.findAll()) {
			Prize prize = lotto.match(prizeLotto);
			statusMap.put(prize, statusMap.get(prize) + 1);
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
}

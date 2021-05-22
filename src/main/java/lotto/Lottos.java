package lotto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;
	private final EnumMap<Prize, Integer> statusMap;

	public Lottos(List<Lotto> lottos) {
		this.lottos = Collections.unmodifiableList(lottos);
		this.statusMap = new EnumMap<>(Prize.class);
		initMap();
	}

	private void initMap() {
		statusMap.clear();
		for (Prize prize : Prize.values()) {
			statusMap.put(prize, 0);
		}
	}

	public int count() {
		return lottos.size();
	}

	public void statistics(Lotto prizeLotto) {
		initMap();
		for (Lotto lotto : lottos) {
			Prize prize = lotto.match(prizeLotto);
			statusMap.put(prize, statusMap.get(prize) + 1);
		}
	}

	public int status(Prize prize) {
		return statusMap.get(prize);
	}

	public Profit profit() {
		int totalWinAmount = getTotalWinAmount();
		int totalAmount = lottos.size() * Store.LOTTO_PRICE;
		return new Profit(totalWinAmount, totalAmount);
	}

	private int getTotalWinAmount() {
		int winAmount = 0;
		for (Prize prize : Prize.values()) {
			winAmount += prize.winAmount() * statusMap.get(prize);
		}
		return winAmount;
	}
}

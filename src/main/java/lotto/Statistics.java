package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Statistics {

	private final List<Lotto> lottos = new ArrayList<>();
	private final Lotto prizeLotto;
	EnumMap<Prize, Integer> statusMap = new EnumMap<>(Prize.class);
	public Statistics(Lotto prizeLotto) {
		this.prizeLotto = prizeLotto;
		for (Prize prize : Prize.values()) {
			statusMap.put(prize, 0);
		}
	}

	public void addLotto(Lotto lotto) {
		lottos.add(lotto);
		Prize prize = lotto.match(prizeLotto);
		statusMap.put(prize, statusMap.get(prize) + 1);
	}

	public boolean contains(Lotto lotto) {
		return lottos.contains(lotto);
	}

	public List<Integer> prizeLottoNumbers() {
		return  prizeLotto.numbers();
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

package automaticLotto.domain;

import java.util.Map;

public class WinnerStatics {
	private static final int NOTHING = 0;
	private final Map<Integer, Integer> winnerCountByMatchedNumber;
	private final Lottos boughtLottos;
	private final Lotto winnerLotto;

	public WinnerStatics(Lottos boughtLottos, Lotto winnerLotto) {
		this.boughtLottos = boughtLottos;
		this.winnerLotto = winnerLotto;
		this.winnerCountByMatchedNumber = getWinnerCountByMatchedNumber();
	}

	private Map<Integer, Integer> getWinnerCountByMatchedNumber() {
		return boughtLottos.announce(winnerLotto);
	}

	public Map<Integer, Integer> presentAllCount() {
		return this.winnerCountByMatchedNumber;
	}

	public int presentCount(int matchedNumber) {
		if (!hasNumber(matchedNumber)) {
			return NOTHING;
		}

		return this.winnerCountByMatchedNumber.get(matchedNumber);
	}

	private boolean hasNumber(int matchedNumber) {
		return winnerCountByMatchedNumber.containsKey(matchedNumber);
	}

	public double getProfitRate() {
		double profit = 0.00;

		for (Integer matchedNumber : winnerCountByMatchedNumber.keySet()) {
			profit += winnerCountByMatchedNumber.get(matchedNumber) * RankingTable.getWinAmount(matchedNumber);
		}

		return profit / getTotalAmount();
	}

	private int getTotalAmount() {
		return boughtLottos.size() * Lotto.LOTTO_PRICE;
	}
}

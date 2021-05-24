package automaticLotto.domain;

import java.util.Map;

public class WinnerStatics {
	private final WinnerTable winnerTable;
	private final Lottos boughtLottos;
	private final Lotto winnerLotto;

	public WinnerStatics(Lottos boughtLottos, Lotto winnerLotto) {
		this.boughtLottos = boughtLottos;
		this.winnerLotto = winnerLotto;
		this.winnerTable = getWinnerTable();
	}

	private WinnerTable getWinnerTable() {
		return boughtLottos.announce(winnerLotto);
	}

	public Map<Integer, Integer> presentAllCount() {
		return winnerTable.getWinnerTable();
	}

	public int presentCount(int matchedCount) {
		return winnerTable.getWinnerCount(matchedCount);
	}

	public double getProfitRate() {
		return winnerTable.getTotalAmount() / getTotalAmount();
	}

	private int getTotalAmount() {
		return boughtLottos.size() * Lotto.LOTTO_PRICE;
	}
}

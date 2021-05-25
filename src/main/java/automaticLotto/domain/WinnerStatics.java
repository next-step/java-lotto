package automaticLotto.domain;

import java.util.Map;

public class WinnerStatics {
	private final WinnerTable winnerTable;
	private final ProfitRate profitRate;

	public WinnerStatics(Lottos boughtLottos, Lotto winnerLotto) {
		this.winnerTable = getWinnerTable(boughtLottos, winnerLotto);
		this.profitRate = new ProfitRate(setProfitRate(boughtLottos));
	}

	private double setProfitRate(Lottos boughtLottos) {
		return winnerTable.getTotalAmount() / getTotalAmount(boughtLottos);
	}

	private int getTotalAmount(Lottos boughtLottos) {
		return boughtLottos.size() * Lotto.LOTTO_PRICE;
	}

	private WinnerTable getWinnerTable(Lottos boughtLottos, Lotto winnerLotto) {
		return boughtLottos.announce(winnerLotto);
	}

	public Map<Ranking, Integer> presentAllCount() {
		return winnerTable.getWinnerTable();
	}

	public int presentCount(Ranking winner) {
		return winnerTable.getWinnerCount(winner);
	}

	public String getProfitRate() {
		return profitRate.getProfitRate();
	}

	public String getProfitResult() {
		return profitRate.getResult();
	}
}

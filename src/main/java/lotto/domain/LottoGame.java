package lotto.domain;

import java.util.List;

public class LottoGame {
	private Lottos userLottos;
	private Money amount;

	public LottoGame(int money) {
		this.userLottos = new Lottos();
		this.amount = Money.from(money);
	}

	public int countOfAutoLotto(int countOfmManualLotto) {
		return this.amount.countOfBuyLotto() - countOfmManualLotto;
	}

	public List<Rank> match(WinningLotto winningLotto) {
		return this.userLottos.match(winningLotto);
	}

	public double calculateProfit(List<Rank> lottoRanks) {
		Money totalPrize = Money.from(0);
		for (Rank rank : lottoRanks) {
			totalPrize = totalPrize.plus(rank.getPrize());
		}
		return this.amount.calculateProfitRatio(totalPrize);
	}

	public List<Lotto> createAutoLotto(int CountOfManualLottos, NumberStrategy numberStrategy) {
		return this.userLottos.createLottos(countOfAutoLotto(CountOfManualLottos), numberStrategy);
	}

	public List<Lotto> createManualLotto(List<String> manualLottos) {
		return this.userLottos.createManualLotto(manualLottos);
	}


	public List<Lotto> getLottos() {
		return this.userLottos.getLottos();
	}
}
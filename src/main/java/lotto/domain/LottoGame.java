package lotto.domain;

import java.util.List;

public class LottoGame {
	private Lottos userLottos;
	private Money amount;

	public LottoGame(int money) {
		this.userLottos = new Lottos();
		this.amount = Money.from(money);
	}

	public List<Lotto> createLotto(NumberStrategy numberStrategy) {
		return this.userLottos.createLottos(countOfLotto(), numberStrategy);
	}

	public int countOfLotto() {
		return this.amount.countOfBuyLotto();
	}

	public List<Lotto> getLottos() {
		return this.userLottos.getLottos();
	}

	public List<Rank> match(String winningNumbers, int bonusNumber) {
		return this.userLottos.match(winningNumbers, bonusNumber);
	}

	public double calculateProfit(List<Rank> lottoRanks) {
		Money totalPrize = Money.from(0);
		for (Rank rank : lottoRanks) {
			totalPrize = totalPrize.plus(rank.getPrize());
		}
		return this.amount.calculateProfitRatio(totalPrize);
	}
}
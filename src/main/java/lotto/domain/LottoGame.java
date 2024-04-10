package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private List<Lotto> userLottos;
	private Money money;

	public LottoGame(int money) {
		this.userLottos = new ArrayList<>();
		this.money = new Money(money);
	}

	public List<Lotto> createLotto(NumberStrategy numberStrategy) {
		for (int i = 0; i < money.countOfBuyLotto(); i++) {
			userLottos.add(Lotto.of(numberStrategy.generateNumber()));
		}
		return userLottos;
	}

	public List<Rank> match(String winningNumbers) {
		List<Rank> ranks = new ArrayList<>();
		Lotto winningLotto = Lotto.of(winningNumbers);
		for (Lotto lotto : this.userLottos) {
			ranks.add(Rank.from(lotto.matchCount(winningLotto)));
		}
		return ranks;
	}

	public int countOfLottos() {
		return money.countOfBuyLotto();
	}
}

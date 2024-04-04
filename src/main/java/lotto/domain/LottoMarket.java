package lotto.domain;

import lotto.domain.strategy.AutoLottoNumberStrategy;
import lotto.domain.strategy.LottoNumberStrategy;

import java.util.List;

public class LottoMarket {
	private final Lottos lottos = new Lottos();

	public LottoMarket(int numberOfLotto, LottoNumberStrategy strategy) {
		for(int i = 0; i < numberOfLotto; i++) {
			lottos.add(new Lotto(strategy));
		}
	}

	public List<Lotto> getLottos() {
		return lottos.getLottos();
	}
}

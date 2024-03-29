package lotto.domain;

import lotto.domain.strategy.AutoLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMarket {
	private final List<Lotto> lottos = new ArrayList<>();

	public LottoMarket(int numberOfLotto) {
		for(int i = 0; i < numberOfLotto; i++) {
			lottos.add(new Lotto(new AutoLottoNumberStrategy()));
		}
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	private final static int PRICE_OF_LOTTO = 1000;
	private List<Lotto> lottos;

	public Lottos(int amount) {
		List<Lotto> lottos = new ArrayList<>();
		int numberOfLottos = amount / PRICE_OF_LOTTO;
		for (int i = 0; i < numberOfLottos; i++) {
			lottos.add(new Lotto());
		}

		this.lottos = lottos;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}

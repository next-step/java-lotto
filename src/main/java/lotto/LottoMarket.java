package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMarket {
	private static final int LOTTO_PURCHASE = 1000;
	private final List<Lotto> lottos = new ArrayList<>();

	public LottoMarket(int purchasePrice) {
		for(int i = 0; i < purchasePrice / LOTTO_PURCHASE; i++) {
			lottos.add(new Lotto(new AutoLottoNumberStrategy()));
		}
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}

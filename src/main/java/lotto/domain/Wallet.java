package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
	private final static int PRICE_OF_LOTTO = 1000;

	public Lottos purchaseLottos(int money) {
		List<Lotto> lottos = new ArrayList<>();
		LottoCard lottoCard = LottoCard.getInstance();
		for (int i = 0; i < money / PRICE_OF_LOTTO; i++) {
			Lotto lotto = lottoCard.issue();
			lottos.add(lotto);
		}
		return new Lottos(lottos);
	}
}

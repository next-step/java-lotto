package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

	public List<Lotto> purchaseLottos(PuchaseAmount purchaseAmount, RandomNumbersGenerator randomNumbersGenerator) {

		List<Lotto> lottos = new ArrayList<>();
		int lottoCount = purchaseAmount.findNumberOfAvailablePurchases();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(new Lotto(randomNumbersGenerator));
		}
		return lottos;
	}

}

package lotto.domain;

public class LottoGame {

	public Lottos purchaseLottos(PuchaseAmount purchaseAmount, RandomNumbersGenerator randomNumbersGenerator) {
		Lottos lottos = new Lottos();
		int lottoCount = purchaseAmount.findNumberOfAvailablePurchases();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(new Lotto(randomNumbersGenerator));
		}
		return lottos;
	}

}

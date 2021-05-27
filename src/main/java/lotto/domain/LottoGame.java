package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

	public PurchaseLottos purchaseLottos(PurchaseRequest purchaseRequest, RandomNumbersGenerator randomNumbersGenerator) {
		Lottos autoLottos = purchaseAutoLottos(randomNumbersGenerator, purchaseRequest.findNumberOfAutomaticPurchases());
		return new PurchaseLottos(purchaseRequest.getManualLottos(), autoLottos);
	}

	private Lottos purchaseAutoLottos(RandomNumbersGenerator randomNumbersGenerator, int countOfPurchase) {
		List<Lotto> autoLottos = new ArrayList<>();
		for (int i = 0; i < countOfPurchase; i++) {
			autoLottos.add(new Lotto(randomNumbersGenerator));
		}
		return new Lottos(autoLottos);
	}

}

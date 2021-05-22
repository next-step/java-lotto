package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

	public static final int PURCHASE_AMOUNT_PER_LOTTO = 1_000;

	public List<LottoNumbers> purchaseLottos(int purchaseAmount, RandomNumbersGenerator randomNumbersGenerator) {
		validationPurchaseAmount(purchaseAmount);

		List<LottoNumbers> lottos = new ArrayList<>();
		int lottoCount = this.findNumberOfAvailablePurchases(purchaseAmount);
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(new LottoNumbers(randomNumbersGenerator));
		}
		return lottos;
	}

	private void validationPurchaseAmount(int purchaseAmount) {
		if (purchaseAmount < PURCHASE_AMOUNT_PER_LOTTO) {
			throw new IllegalArgumentException(String.format("로또를 구입하려면 최소 %,d원 이상 있어야 합니다.", PURCHASE_AMOUNT_PER_LOTTO));
		}
	}

	protected int findNumberOfAvailablePurchases(int purchaseAmount) {
		return purchaseAmount / PURCHASE_AMOUNT_PER_LOTTO;
	}

}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

	public static final int PURCHASE_AMOUNT_PER_LOTTO = 1000;
	private final int purchaseAmount;
	private final List<LottoNumbers> lottos;
	private final RandomNumbersGenerator randomNumbersGenerator;

	public LottoGame(int purchaseAmount) {
		validationpurchaseAmount(purchaseAmount);
		this.purchaseAmount = purchaseAmount;
		this.lottos = new ArrayList<>();
		this.randomNumbersGenerator = new LottoRandomNumbersGenerator();
		this.purchaseLottos();
	}

	public LottoGame(int purchaseAmount, RandomNumbersGenerator randomNumbersGenerator) {
		validationpurchaseAmount(purchaseAmount);
		this.purchaseAmount = purchaseAmount;
		this.lottos = new ArrayList<>();
		this.randomNumbersGenerator = randomNumbersGenerator;
		this.purchaseLottos();
	}

	private void validationpurchaseAmount(int purchaseAmount) {
		if (purchaseAmount < PURCHASE_AMOUNT_PER_LOTTO) {
			throw new IllegalArgumentException("로또를 구입하려면 최소 1000원 이상 있어야 합니다.");
		}
	}

	protected int findNumberOfAvailablePurchases() {
		return this.purchaseAmount / PURCHASE_AMOUNT_PER_LOTTO;
	}

	private void purchaseLottos() {
		int lottoCount = this.findNumberOfAvailablePurchases();
		for (int i = 0; i < lottoCount; i++) {
			this.lottos.add(new LottoNumbers(this.randomNumbersGenerator));
		}
	}

	public int hasSize() {
		return this.lottos.size();
	}

}

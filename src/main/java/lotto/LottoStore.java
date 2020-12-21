package lotto;

public class LottoStore {
	private static final int LOTTO_PRICE = 1_000;

	public static Lottos buy(int purchaseAmount) {
		Purchase purchase = Purchase.of(purchaseAmount);
		int numOfLotto = purchase.countBuyableLotto(LOTTO_PRICE);

		return Lottos.of(numOfLotto);
	}
}

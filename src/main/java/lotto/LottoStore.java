package lotto;

public class LottoStore {
	private static final int LOTTO_PRICE = 1_000;

	public static Lottos buy(int purchaseAmount) {
		Money money = Money.of(purchaseAmount);
		int numOfLotto = money.count(LOTTO_PRICE);

		return Lottos.of(numOfLotto);
	}
}

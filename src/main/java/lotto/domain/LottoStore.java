package lotto.domain;

public class LottoStore {
	private static final int LOTTO_PRICE = 1_000;

	public static Lottos buy(int moeny) {
		Money money = Money.of(moeny);
		int numOfLotto = money.count(LOTTO_PRICE);

		return Lottos.of(numOfLotto);
	}
}

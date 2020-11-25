package nextstep.step2.domain;

public class LottoPurchase {
	private static final String WRONG_MONEY = "로또 구매금액이 부족합니다.";
	public static int LOTTO_PRICE = 1_000;
	private int money;

	public LottoPurchase(int money) {
		this.money = money;
	}
	public int getLottoCount() {
		int purchaseCount = money / LOTTO_PRICE;
		if (purchaseCount == 0) {
			throw new IllegalArgumentException(WRONG_MONEY);
		}
		return purchaseCount;
	}
}

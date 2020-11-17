package nextstep.step2.domain;

public class LottoPurchase {
	public static int LOTTO_PRICE = 1_000;
	private int money;

	public LottoPurchase(int money) {
		this.money = money;
	}
	public int getLottoCount() {
		return money / LOTTO_PRICE;
	}
}

package nextstep.step2.domain;

public class LottoPurchase {
	private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
	private static int LOTTO_PRICE = 1000;
	private int money;

	public LottoPurchase(int money) {
		this.money = money;
	}
	public int getLottoCount() {
		System.out.println(String.format(LOTTO_PURCHASE_MESSAGE, getBuying(money)));
		return getBuying(money);
	}

	public int getBuying(int money) {
		return money / LOTTO_PRICE;
	}
}

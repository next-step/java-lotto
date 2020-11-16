package nextstep.step2.domain;

public class LottoPurchase {
	private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
	public static int LOTTO_PRICE = 1000;
	private int money;

	public LottoPurchase(int money) {
		this.money = money;
	}
	public int getLottoCount() {
		return money / LOTTO_PRICE;
	}

	public void printLottoPurchase() {
		System.out.println(String.format(LOTTO_PURCHASE_MESSAGE, getLottoCount()));
	}
}

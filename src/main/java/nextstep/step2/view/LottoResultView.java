package nextstep.step2.view;

public class LottoResultView {
	private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
	private static int LOTTO_PRICE = 1000;
	private int money;

	public LottoResultView(int money) {
		this.money = money;
	}
	public String getPurchaseMessage() {
		return String.format(LOTTO_PURCHASE_MESSAGE, getBuying(money));
	}

	protected int getBuying(int money) {
		return money / LOTTO_PRICE;
	}
}

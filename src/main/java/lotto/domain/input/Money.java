package lotto.domain.input;

public class Money {

	private int money;

	public Money(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public LottoBuyCount calculateLottoCount(Money lottoPricePerSheet) {
		return new LottoBuyCount(this.money / lottoPricePerSheet.getMoney());
	}

	public void add(Money prizeMoney) {
		this.money += prizeMoney.money;
	}
}

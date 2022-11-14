package step4.model;

public class Money {
	private static final int LOTTO_PRICE = 1000;
	private final int money;

	public Money(int money) {
		this.money = money;
	}

	public int getLottoTicketCnt() {
		return this.money / LOTTO_PRICE;
	}

	public int getMoney() {
		return this.money;
	}
}

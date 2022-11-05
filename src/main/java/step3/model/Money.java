package step3.model;

public class Money {
	private final int money;

	public Money(int money) {
		this.money = money;
	}

	public int getLottoTicketCnt() {
		return this.money / 1000;
	}

	public int getMoney() {
		return this.money;
	}
}

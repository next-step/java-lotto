package step2.model;

public class Money {
	private final static int LOTTO_PRICE = 1000;

	private final int money;
	private final int ticketCnt;

	public Money(final int money) {
		this.money = money;
		this.ticketCnt = money / LOTTO_PRICE;
	}

	public int getTicketCnt() {
		return ticketCnt;
	}

	public int getMoney() {
		return money;
	}
}

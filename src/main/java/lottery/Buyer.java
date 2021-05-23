package lottery;

import static java.util.Objects.*;

public final class Buyer {
	private Money money = Money.ZERO;
	private Tickets tickets = Tickets.ZERO;

	private Buyer(Money money) {
		setMoney(money);
	}

	public static Buyer of(Money initial) {
		return new Buyer(initial);
	}

	public Money money() {
		return money;
	}

	public Tickets tickets() {
		return tickets;
	}

	public boolean hasTickets() {
		return tickets.size() > 0;
	}

	public void buyTicket(Store store) {
		requireNonNull(store);
		this.tickets = store.getTicket(this);
	}

	public Result checkTicket(InfoCenter infoCenter) {
		requireNonNull(infoCenter);
		return infoCenter.confirmTicket(this.tickets);
	}

	public void setMoney(Money money) {
		if (isNull(money) || money.amount() < 1000) {
			throw new IllegalArgumentException("1000원 이상의 값을 입력해주세요.");
		}
		this.money = money;
	}
}

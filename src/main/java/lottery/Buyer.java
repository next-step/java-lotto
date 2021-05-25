package lottery;

import static java.util.Objects.*;

public final class Buyer {
	private Money money = Money.ZERO;
	private Tickets tickets = Tickets.EMPTY_TICKETS;

	public static Buyer of(Money initial) {
		return new Buyer(initial);
	}

	private Buyer(Money money) {
		setMoney(money);
	}

	public Money money() {
		return money;
	}

	public Tickets tickets() {
		return tickets;
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
		if (isNull(money) || money.amount() < 0) {
			throw new IllegalArgumentException("유효하지 않은 값입니다.");
		}
		this.money = money;
	}
}

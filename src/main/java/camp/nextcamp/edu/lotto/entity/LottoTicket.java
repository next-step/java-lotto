package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.util.StringUtils.*;

public class LottoTicket {
	private static final int PRICE = 1000;
	private final int ticketCount;
	private final int money;

	public LottoTicket(String money) {
		if (!isNumeric(money)) {
			throw new RuntimeException("숫자만 가능합니다.");
		}
		this.money = Integer.parseInt(money);
		this.ticketCount = makeTicket(this.money);
	}

	private int makeTicket(int money) {
		return money / PRICE;
	}

	public int getTicketCount() {
		return this.ticketCount;
	}

	public int getMoney() {
		return this.money;
	}

}

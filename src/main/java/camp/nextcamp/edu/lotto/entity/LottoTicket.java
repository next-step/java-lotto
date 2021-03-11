package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.exception.UserExceptionMesssage.*;
import static camp.nextcamp.edu.util.StringUtils.*;

import camp.nextcamp.edu.lotto.exception.UserException;

public class LottoTicket {
	private static final int PRICE = 1000;
	private final int ticketCount;
	private final int money;

	public LottoTicket(String money) {
		if (!isNumeric(money)) {
			throw new UserException(ONLY_NUMBER);
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

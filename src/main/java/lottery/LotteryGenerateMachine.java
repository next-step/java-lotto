package lottery;

import java.util.ArrayList;
import java.util.List;

import lottery.util.RandomUtil;

public class LotteryGenerateMachine {

	public List<Ticket> createTicket(long count) {
		List<Ticket> tickets = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			Ticket of = Ticket.of(RandomUtil.randomNumber());
			tickets.add(of);
		}
		return tickets;
	}
}

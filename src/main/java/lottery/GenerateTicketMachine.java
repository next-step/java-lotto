package lottery;

import static lottery.util.RandomUtil.*;

import java.util.ArrayList;
import java.util.List;

public class GenerateTicketMachine {

	public List<Ticket> create(long count) {
		List<Ticket> tickets = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			tickets.add(Ticket.of(generateSixNumbers(1, 45)));
		}
		return tickets;
	}
}

package lottery;

import static lottery.util.RandomUtil.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class GenerateTicketMachine {

	public Tickets create(long count) {
		List<Ticket> tickets = new ArrayList<>();
		LongStream.range(0, count)
			.forEach(value -> tickets.add(
				Ticket.of(Numbers.from(generateSixNumbers(1, 45)))
			));
		return Tickets.of(tickets);
	}
}

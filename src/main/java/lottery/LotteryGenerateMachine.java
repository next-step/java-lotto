package lottery;

import java.util.ArrayList;
import java.util.List;

public class LotteryGenerateMachine {

	public List<Ticket> createTicket(long count) {
		List<Ticket> tickets = new ArrayList<>();
		int[] numbers = new int[]{1,2,3,4,5,6};
		// TODO generate Random int[]
		for (int i = 0; i < count; i++) {
			tickets.add(Ticket.of(numbers));
		}
		return tickets;
	}
}

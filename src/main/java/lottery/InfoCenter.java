package lottery;

import java.util.List;

public class InfoCenter {

	private Ticket lastWeekWinningTicket;

	public void setLastWeekWinningTicket(Ticket lastWeekWinningTicket) {
		this.lastWeekWinningTicket = lastWeekWinningTicket;
	}

	public Result confirmTicket(Tickets buyerTickets) {
		Result result = new Result();
		buyerTickets.getTicketList().stream()
			.map(ticket -> {
				List<Integer> numbers = ticket.numbers();
				numbers.removeAll(this.lastWeekWinningTicket.numbers());
				return Ticket.SIZE_OF_TICKET - numbers.size(); })
			.filter(a -> a >= 3)
			.map(LotteryMatchType::fromInteger)
			.forEach(result::addMatchType);
		return result;
	}

	public Ticket lastWeekWinningNumbers() {
		return lastWeekWinningTicket;
	}
}

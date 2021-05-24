package lottery;

import java.util.List;

public class InfoCenter {

	private final int MATCH_THREE_NUMBER_COUNT = 3;
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
				return Ticket.SIZE_OF_TICKET - numbers.size();
			})
			.filter(matchCount -> matchCount >= MATCH_THREE_NUMBER_COUNT)
			.map(LotteryMatchType::fromInteger)
			.forEach(match -> result.getResultMap().addMatchType(match));

		return result;
	}

	public Ticket lastWeekWinningNumbers() {
		return lastWeekWinningTicket;
	}
}

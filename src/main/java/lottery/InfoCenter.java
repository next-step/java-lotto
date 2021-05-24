package lottery;

import java.util.List;

public class InfoCenter {

	private final int MATCH_THREE_NUMBER = 3;
	private Ticket lastWeekWinningTicket;

	public void setLastWeekWinningTicket(Ticket lastWeekWinningTicket) {
		this.lastWeekWinningTicket = lastWeekWinningTicket;
	}

	public Result confirmTicket(Tickets buyerTickets) {
		Result result = new Result();

		buyerTickets.getValues().stream()
			.map(ticket -> {
				Numbers numbers = ticket.numbers();
				List<Integer> values = numbers.getValues();
				values.removeAll(this.lastWeekWinningTicket.numbers().getValues());
				return Ticket.SIZE_OF_TICKET - values.size(); })
			.filter(matchCount -> matchCount >= MATCH_THREE_NUMBER)
			.map(LotteryMatchType::fromInteger)
			.forEach(match -> result.getResultMap().addMatchType(match));

		return result;
	}

	public Ticket lastWeekWinningNumbers() {
		return lastWeekWinningTicket;
	}
}

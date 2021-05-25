package lottery;

import static java.util.stream.Collectors.*;

import java.util.stream.Collectors;

public class InfoCenter {

	private final int MATCH_THREE_NUMBER = 3;
	private Ticket lastWeekWinningTicket;

	public void setLastWeekWinningTicket(Ticket lastWeekWinningTicket) {
		this.lastWeekWinningTicket = lastWeekWinningTicket;
	}

	public Result confirmTicket(Tickets buyerTickets) {
		return new Result(LotteryMatchTypeMap.of(buyerTickets.getValues().stream()
			.map(ticket -> ticket.numbers().matchCountWith(lastWeekWinningTicket.numbers()))
			.filter(matchCount -> matchCount >= MATCH_THREE_NUMBER)
			.collect(Collectors.groupingBy(LotteryMatchType::fromInteger, summingInt(a -> 1)))));
	}

	public Ticket lastWeekWinningNumbers() {
		return lastWeekWinningTicket;
	}
}

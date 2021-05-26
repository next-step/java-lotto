package lottery;

import static java.util.stream.Collectors.*;

public class InfoCenter {

	private WinningTicket lastWeekWinningTicket;

	public void setLastWeekWinningTicket(WinningTicket lastWeekWinningTicket) {
		this.lastWeekWinningTicket = lastWeekWinningTicket;
	}

	public Result confirmTicket(Tickets buyerTickets) {
		return new Result(LotteryMatchTypeMap.of(buyerTickets.getValues().stream()
			.map(ticket -> lastWeekWinningTicket.getMatchTypeWith(ticket))
			.filter(matchType -> LotteryMatchType.MISS_MATCH != matchType)
			.collect(groupingBy(a -> a, summingInt(a -> 1)))));
	}

	public WinningTicket lastWeekWinningNumbers() {
		return lastWeekWinningTicket;
	}
}

package lottery;

import static java.util.Objects.*;
import static java.util.stream.Collectors.*;

public class InfoCenter {

	private Ticket lastWeekWinningTicket;
	private int bonus;

	public void setLastWeekWinningTicket(Ticket lastWeekWinningTicket) {
		this.lastWeekWinningTicket = lastWeekWinningTicket;
	}

	void setBonusNumber(int number) {
		this.bonus = number;
	}

	public Result confirmTicket(Tickets buyerTickets) {
		requireNonNull(lastWeekWinningTicket, "지난 주 티켓이 없습니다.");
		requireNonNull(bonus, "보너스 볼이 없습니다.");

		return new Result(LotteryMatchTypeMap.of(buyerTickets.getValues().stream()
			.map(ticket -> ticket.numbers().getMatchTypeWith(lastWeekWinningTicket.numbers(), bonus))
			.filter(matchType -> LotteryMatchType.MISS_MATCH != matchType)
			.collect(groupingBy(a -> a, summingInt(a -> 1)))));
	}

	public Ticket lastWeekWinningNumbers() {
		return lastWeekWinningTicket;
	}
}

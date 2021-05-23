package lottery;

import java.util.List;

public class InfoCenter {

	private Ticket lastWeekWinningNumbers;
	private final Result result;

	public InfoCenter() {
		result = new Result();
	}

	public void setLastWeekWinningNumbers(Ticket lastWeekWinningNumbers) {
		this.lastWeekWinningNumbers = lastWeekWinningNumbers;
	}

	public Result confirmTicket(List<Ticket> buyerTickets) {
		for (Ticket ticket : buyerTickets) {
			List<Integer> buyerNumbers = ticket.numbers();
			buyerNumbers.removeAll(this.lastWeekWinningNumbers.numbers());
			LotteryMatchType lotteryMatchType = LotteryMatchType.fromInteger(Ticket.SIZE_OF_TICKET - buyerNumbers.size());
			result.addMatchType(lotteryMatchType);
		}
		return result;
	}

	public Ticket lastWeekWinningNumbers() {
		return lastWeekWinningNumbers;
	}
}

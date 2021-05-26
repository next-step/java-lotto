package lottery;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class WinningTicket {

	private final Ticket ticket;
	private final int bonus;

	public WinningTicket(Ticket ticket, int bonus) {
		this.ticket = ticket;
		this.bonus = bonus;
	}

	public LotteryMatchType getMatchTypeWith(Ticket targetTicket) {
		LinkedHashSet<Integer> targetNumbers = new LinkedHashSet<>(targetTicket.numbers());
		targetNumbers.removeAll(this.ticket.numbers());

		LotteryMatchType matchType = LotteryMatchType.fromInteger(Ticket.SIZE_OF_TICKET - targetNumbers.size());
		if (isBonusMatchCount(bonus, matchType, targetNumbers)) {
			return LotteryMatchType.FIVE_MATCH_WITH_BONUS;
		}
		return matchType;
	}

	private boolean isBonusMatchCount(int bonus,
		LotteryMatchType matchType,
		Set<Integer> winningTicketNumbers) {
		return matchType == LotteryMatchType.FIVE_MATCH && winningTicketNumbers.contains(bonus);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof WinningTicket))
			return false;
		WinningTicket that = (WinningTicket)o;
		return bonus == that.bonus && Objects.equals(ticket, that.ticket);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ticket, bonus);
	}
}

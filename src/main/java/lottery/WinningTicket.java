package lottery;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class WinningTicket {

	private Ticket ticket;
	private LottoNo bonus;
	private static final String NOT_VALID_WINNING_TICKET_NUMBERS_EXCEPTION_MESSAGE = "잘못된 당첨 정보 입니다";
	private static final String NOT_VALID_BONUS_EXCEPTION_MESSAGE = "잘못된 보너스 번호 입니다";

	public WinningTicket(Ticket ticket, LottoNo bonus) {
		setTicket(ticket);
		setBonus(bonus);
	}

	private void setTicket(Ticket ticket) {
		if (Objects.isNull(ticket)) {
			throw new IllegalArgumentException(NOT_VALID_WINNING_TICKET_NUMBERS_EXCEPTION_MESSAGE);
		}
		this.ticket = ticket;
	}

	private void setBonus(LottoNo bonus) {
		this.bonus = bonus;
	}

	public LotteryMatchType getMatchTypeWith(Ticket targetTicket) {
		LinkedHashSet<LottoNo> targetNumbers = new LinkedHashSet<>(targetTicket.numbers());
		targetNumbers.removeAll(this.ticket.numbers());

		LotteryMatchType matchType = LotteryMatchType.byMatchCount(Ticket.SIZE_OF_TICKET - targetNumbers.size());
		if (isBonusMatchCount(bonus, matchType, targetNumbers)) {
			return LotteryMatchType.FIVE_MATCH_WITH_BONUS;
		}
		return matchType;
	}

	private boolean isBonusMatchCount(LottoNo bonus, LotteryMatchType matchType, Set<LottoNo> winningTicketNumbers) {
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

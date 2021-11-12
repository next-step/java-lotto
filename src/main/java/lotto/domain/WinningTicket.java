package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningTicket {
	private final Ticket ticket;
	private final LottoNumber bonus;

	private WinningTicket(Ticket ticket, LottoNumber bonus) {
		this.ticket = ticket;
		this.bonus = bonus;
	}

	public static WinningTicket create(String[] numbers, int bonus) {
		List<LottoNumber> values = Arrays.stream(numbers)
			.map(LottoNumber::create)
			.sorted()
			.collect(toList());
		return new WinningTicket(Ticket.create(values), LottoNumber.create(bonus));
	}

	public int getMatchedCount(Ticket ticket) {
		return ticket.getMatchedCount(this.ticket);
	}

	public boolean isBonusMatched(Ticket ticket) {
		return ticket.isBonusMatched(this.bonus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		WinningTicket that = (WinningTicket)obj;

		if (!Objects.equals(ticket, that.ticket)) {
			return false;
		}
		return Objects.equals(bonus, that.bonus);
	}

	@Override
	public int hashCode() {
		int result = ticket != null ? ticket.hashCode() : 0;
		result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
		return result;
	}
}

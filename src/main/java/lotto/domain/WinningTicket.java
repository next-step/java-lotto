package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningTicket {
	private static final String INCLUDED_MESSAGE = "당첨번호는 보너스 번호를 포함할수 없습니다.";

	private final Ticket ticket;
	private final LottoNumber bonus;

	private WinningTicket(Ticket ticket, LottoNumber bonus) {
		validate(ticket, bonus);
		this.ticket = ticket;
		this.bonus = bonus;
	}

	private void validate(Ticket ticket, LottoNumber bonus) {
		if (ticket.isBonusMatched(bonus)) {
			throw new IllegalArgumentException(INCLUDED_MESSAGE);
		}
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

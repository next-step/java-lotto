package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfoCenterTest {

	private InfoCenter sut;

	@BeforeEach
	void setUp() {
		sut = new InfoCenter();
	}

	@Test
	void 지난주_당첨번호를_입력받는다() {
		Ticket lastWinningNumber = Ticket.of(Lists.list(1, 2, 3, 4, 5, 6));
		sut.setLastWeekWinningNumbers(lastWinningNumber);

		assertThat(sut.lastWeekWinningNumbers()).isEqualTo(lastWinningNumber);
	}

	@Test
	void 로또_3개자리_일치() {
		Ticket buyerTicket = Ticket.of(Lists.list(1, 2, 3, 11, 12, 13));

		Ticket lastWinningNumber = Ticket.of(Lists.list(1, 2, 3, 4, 5, 6));
		sut.setLastWeekWinningNumbers(lastWinningNumber);

		Result result = sut.confirmTicket(Lists.list(buyerTicket));
		assertThat(result.getThreeMatchNumber()).isEqualTo(1);
	}

	@Test
	void 로또_4개자리_일치() {
		Ticket buyerTicket = Ticket.of(Lists.list(1, 2, 3, 4, 12, 13));

		Ticket lastWinningNumber = Ticket.of(Lists.list(1, 2, 3, 4, 5, 6));
		sut.setLastWeekWinningNumbers(lastWinningNumber);

		Result result = sut.confirmTicket(Lists.list(buyerTicket));
		assertThat(result.getFourMatchNumber()).isEqualTo(1);
	}

	@Test
	void 로또_5개자리_일치() {
		Ticket buyerTicket = Ticket.of(Lists.list(1, 2, 3, 4, 5, 13));

		Ticket lastWinningNumber = Ticket.of(Lists.list(1, 2, 3, 4, 5, 6));
		sut.setLastWeekWinningNumbers(lastWinningNumber);

		Result result = sut.confirmTicket(Lists.list(buyerTicket));
		assertThat(result.getFiveMatchNumber()).isEqualTo(1);
	}

	@Test
	void 로또_6개자리_일치() {
		Ticket buyerTicket = Ticket.of(Lists.list(1, 2, 3, 4, 5, 6));

		Ticket lastWinningNumber = Ticket.of(Lists.list(1, 2, 3, 4, 5, 6));
		sut.setLastWeekWinningNumbers(lastWinningNumber);

		Result result = sut.confirmTicket(Lists.list(buyerTicket));
		assertThat(result.getSixMatchNumber()).isEqualTo(1);
	}

	@Test
	void 복수의_로또티켓을_체크할수_있다() {
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(Ticket.of(Lists.list(1, 2, 3, 4, 5, 6)));
		tickets.add(Ticket.of(Lists.list(1, 2, 3, 4, 5, 6)));
		tickets.add(Ticket.of(Lists.list(1, 2, 3, 4, 5, 6)));
		Ticket lastWinningNumber = Ticket.of(Lists.list(1, 2, 3, 4, 5, 6));

		sut.setLastWeekWinningNumbers(lastWinningNumber);
		Result result = sut.confirmTicket(tickets);
		assertThat(result.getSixMatchNumber()).isEqualTo(3);
	}

	@Test
	void 수익률을_계산한다() {
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(Ticket.of(Lists.list(1, 2, 3, 9, 10, 11)));
		tickets.add(Ticket.of(Lists.list(1, 2, 3, 9, 10, 11)));
		tickets.add(Ticket.of(Lists.list(1, 2, 3, 9, 10, 11)));
		// 15000
		Ticket lastWinningNumber = Ticket.of(Lists.list(1, 2, 3, 4, 5, 6));
		Money money = Money.won(3000L);

		sut.setLastWeekWinningNumbers(lastWinningNumber);
		Result result = sut.confirmTicket(tickets);
		assertThat(result.getTotalYield(money)).isEqualTo(5.0f);
	}
}

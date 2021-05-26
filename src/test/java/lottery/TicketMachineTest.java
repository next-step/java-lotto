package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketMachineTest {

	private TicketMachine sut;

	@BeforeEach
	void setUp() {
		sut = new TicketMachine();
	}

	@Test
	void 랜덤숫자를가진_로또티켓을_발행한다() {
		Tickets tickets = sut.automaticTicketCreate(1);
		assertThatHasValidGenerateNumber(tickets.getValue(0).numbers());
	}

	@Test
	void 발행된_티켓의_번호들은_정렬된_순서를_갖는다() {
		Tickets tickets = sut.automaticTicketCreate(1);
		Ticket ticket = tickets.getValues().get(0);
		assertThat(new ArrayList<>(ticket.numbers())).isSorted();
	}

	@Test
	void 티켓을_한장_발행한다() {
		Tickets tickets = sut.automaticTicketCreate(1);
		assertThat(tickets.getValues()).hasSize(1);

		Set<LottoNo> lottoNumbers = tickets.getValue(0)
			.numbers();
		assertThat(lottoNumbers).hasSize(6);
		assertThatHasValidGenerateNumber(lottoNumbers);
	}

	@Test
	void 두장_발행한다() {
		Tickets tickets = sut.automaticTicketCreate(2);

		List<Ticket> ticketList = tickets.getValues();
		assertThat(ticketList).hasSize(2);

		for (Ticket ticket : ticketList) {
			assertThatHasValidGenerateNumber(ticket.numbers());
		}
	}

	private void assertThatHasValidGenerateNumber(Set<LottoNo> lottoNumbers) {
		for (LottoNo number : lottoNumbers) {
			assertThat(number.value()).isBetween(1, 45);
		}
		assertThat(new ArrayList<>(lottoNumbers)).isSorted();
	}
}

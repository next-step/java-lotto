package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenerateTicketMachineTest {

	private GenerateTicketMachine sut;

	@BeforeEach
	void setUp() {
		sut = new GenerateTicketMachine();

	}

	@Test
	void 랜덤숫자를가진_로또티켓을_발행한다() {
		List<Ticket> ticket = sut.create(1);
		assertThatHasValidNumber(ticket.get(0).numbers());
	}

	@Test
	void 발행된_티켓의_번호들은_정렬된_순서를_갖는다() {
		List<Ticket> tickets = sut.create(1);
		Ticket ticket = tickets.get(0);
		assertThat(ticket.numbers()).isSorted();
	}

	@Test
	void 티켓을_한장_발행한다() {
		List<Ticket> ticket = sut.create(1);

		List<Integer> numbers = ticket.get(0).numbers();
		assertThat(numbers).hasSize(6);
		assertThatHasValidNumber(numbers);
	}

	@Test
	void 두장_발행한다() {
		int count = 2;

		List<Ticket> tickets = sut.create(count);
		assertThat(tickets).hasSize(count);

		for (Ticket ticket : tickets) {
			assertThatHasValidNumber(ticket.numbers());
		}
	}

	private void assertThatHasValidNumber(List<Integer> numbers) {
		for (int number : numbers) {
			assertThat(number).isBetween(1, 45);
		}
	}
}

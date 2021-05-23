package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LotteryGenerateMachineTest {

	private LotteryGenerateMachine sut;

	@BeforeEach
	void setUp() {
		sut = new LotteryGenerateMachine();

	}

	@Test
	void 랜덤번호로_된_티켓을_발행_한장_발행한다() {
		sut = new LotteryGenerateMachine();
		List<Ticket> ticket = sut.createTicket(1);

		int[] numbers = ticket.get(0).numbers();
		assertThat(numbers).hasSize(6);
		assertThatHasValidNumber(numbers);
	}

	@Test
	void 두장_발행한다() {
		sut = new LotteryGenerateMachine();
		int count = 2;

		List<Ticket> tickets = sut.createTicket(count);
		assertThat(tickets).hasSize(count);

		for (Ticket ticket : tickets) {
			assertThatHasValidNumber(ticket.numbers());
		}
	}

	@Test
	void 자동으로_로또를_발행한다() {
		// TODO
	}

	private void assertThatHasValidNumber(int[] numbers) {
		for (int number : numbers) {
			assertThat(number).isBetween(1, 45);
		}
	}
}

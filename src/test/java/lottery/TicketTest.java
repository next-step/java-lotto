package lottery;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lottery.exceptions.InvalidTicketSizeException;

class TicketTest {

	Ticket sut;

	//TODO TicketList 에 대한 일급 컬렉션 고려하기

	@Test
	void create() {
		int [] numbers = new int[6];

		sut = Ticket.of(numbers);

		assertThat(sut.numbers()).hasSize(6);
		assertThat(sut.numbers()).containsExactly(numbers);

		assertThatThrownBy(() -> Ticket.of(new int[1]))
			.isInstanceOf(InvalidTicketSizeException.class);
	}
}
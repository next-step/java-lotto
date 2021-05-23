package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import lottery.exceptions.InvalidTicketSizeException;

class TicketTest {

	Ticket sut;

	@Test
	void create() {
		List<Integer> numbers = Lists.list(1, 2, 3, 4, 5, 6);

		sut = Ticket.of(numbers);

		assertThat(sut.numbers()).hasSize(6);
		assertThat(sut.numbers()).containsAll(numbers);

		assertThatThrownBy(() -> Ticket.of(new ArrayList<>()))
			.isInstanceOf(InvalidTicketSizeException.class);
	}
}

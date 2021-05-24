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
		Numbers numbers = Numbers.from(Lists.list(1, 2, 3, 4, 5, 6));

		sut = Ticket.of(numbers);

		List<Integer> values = sut.numbers().getValues();
		assertThat(values).hasSize(6);
		assertThat(values).containsAll(numbers.getValues());

		assertThatThrownBy(() -> Ticket.of(Numbers.from(new ArrayList<>())))
			.isInstanceOf(InvalidTicketSizeException.class);
	}
}

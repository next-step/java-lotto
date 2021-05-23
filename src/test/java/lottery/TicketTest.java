package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import lottery.exceptions.InvalidTicketSizeException;

class TicketTest {

	Ticket sut;

	//TODO TicketList 에 대한 일급 컬렉션 고려하기

	@Test
	void create() {
		List<Integer> numbers = new ArrayList<>(Collections.emptyList());
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);

		sut = Ticket.of(numbers);

		assertThat(sut.numbers()).hasSize(6);
		assertThat(sut.numbers()).containsAll(numbers);

		assertThatThrownBy(() -> Ticket.of(new ArrayList<>()))
			.isInstanceOf(InvalidTicketSizeException.class);
	}
}

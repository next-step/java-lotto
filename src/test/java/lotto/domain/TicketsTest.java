package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.generator.FixedGenerator;
import lotto.generator.Generator;

class TicketsTest {
	@DisplayName("Tickets 생성을 검증한다.")
	@Test
	void create() {
		// given
		Generator generator = new FixedGenerator();
		int numberOfPurchases = 10;

		// when
		Tickets tickets = Tickets.create(generator, numberOfPurchases);

		// then
		assertThat(tickets).isEqualTo(createFixedTickets(numberOfPurchases));
	}

	@DisplayName("Tickets 생성시 null 이거나 size 가 0 일 경우 예외를 던진다.")
	@Test
	void createEmptyList() {
		// given
		List<Ticket> emptyTickets = Collections.emptyList();

		// when then
		assertAll(
			() -> assertThatIllegalArgumentException().isThrownBy(() -> Tickets.create(null)),
			() -> assertThatIllegalArgumentException().isThrownBy(() -> Tickets.create(emptyTickets))
		);
	}

	@DisplayName("Tickets getValues() 호출후 컬렉션 수정시 예외를 던진다.")
	@Test
	void getValues() {
		// given
		Tickets tickets = Tickets.create(new FixedGenerator(), 10);

		// when
		List<Ticket> values = tickets.getValues();

		// then
		assertThatExceptionOfType(UnsupportedOperationException.class)
			.isThrownBy(() -> values.remove(0));
	}

	private Tickets createFixedTickets(int numberOfPurchases) {
		List<Ticket> values = new ArrayList<>();
		for (int i = 0; i < numberOfPurchases; i++) {
			values.add(new Ticket(FixedGenerator.FIXED_NUMBERS));
		}
		return new Tickets(values);
	}
}

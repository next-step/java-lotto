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
	private static final int SIZE_OF_MANUAL_TICKETS = 10;

	@DisplayName("Tickets 생성을 검증한다.")
	@Test
	void create() {
		// given
		Generator generator = new FixedGenerator();
		int sizeOfAutoTickets = 10;
		List<Ticket> manualTickets = createManualTickets();

		// when
		Tickets tickets = Tickets.create(generator, sizeOfAutoTickets, manualTickets);

		// then
		assertThat(tickets).isEqualTo(createFixedTickets(sizeOfAutoTickets, manualTickets));
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
		Tickets tickets = Tickets.create(new FixedGenerator(), 10, Collections.emptyList());

		// when
		List<Ticket> values = tickets.getValues();

		// then
		assertThatExceptionOfType(UnsupportedOperationException.class)
			.isThrownBy(() -> values.remove(0));
	}

	private Tickets createFixedTickets(int sizeOfAutoTickets, List<Ticket> manualTickets) {
		List<Ticket> values = new ArrayList<>(manualTickets);
		for (int i = 0; i < sizeOfAutoTickets; i++) {
			values.add(Ticket.create(FixedGenerator.FIXED_NUMBERS));
		}
		return Tickets.create(values);
	}

	private List<Ticket> createManualTickets() {
		List<Ticket> manualTicket = new ArrayList<>(TicketsTest.SIZE_OF_MANUAL_TICKETS);
		for (int i = 0; i < TicketsTest.SIZE_OF_MANUAL_TICKETS; i++) {
			manualTicket.add(Ticket.create(FixedGenerator.FIXED_NUMBERS));
		}
		return manualTicket;
	}
}

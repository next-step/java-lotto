package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StoreTest {

	private Store sut;
	private Buyer buyer;

	@BeforeEach
	void setUp() {
		sut = new Store();
		buyer = Buyer.of(Money.won(7000L));
	}

	@Test
	void 자동티켓_머신을_가진다() {
		assertThat(sut.getMachine()).isNotNull();
	}

	@Test
	void 티켓을_판매한다() {
		buyer = Buyer.of(Money.won(7000L));
		Tickets manualTickets = getTickets(
			Sets.newLinkedHashSet(1,2,3,4,5,6),
			Sets.newLinkedHashSet(1,2,3,4,5,6),
			Sets.newLinkedHashSet(1,2,3,4,5,6)
		);

		Tickets tickets = sut.getTicket(buyer, manualTickets);

		assertThat(tickets.getValues()).isNotEmpty();
		assertThat(tickets.getValues()).hasSize(7);
	}

	@Test
	void 수동으로_티켓을_발행() {
		sut = new Store();
		buyer = Buyer.of(Money.won(5000L));
		int countOfManual = 1;
		int countOfAuto = 4;
		Tickets manualTickets = getTickets(Sets.newLinkedHashSet(1,2,3,4,5,6));
		Tickets ticket = sut.getTicket(buyer, manualTickets);

		assertThat(ticket.sizeOfManualTickets()).isEqualTo(countOfManual);
		assertThat(ticket.sizeOfAutoTickets()).isEqualTo(countOfAuto);
	}



	private Tickets getTickets(LinkedHashSet<Integer>... numbers) {
		List<Ticket> tickets = new ArrayList<>();
		for (LinkedHashSet<Integer> number : numbers) {
			tickets.add(Ticket.of(LottoNumbers.from(number), TicketType.MANUAL));
		}
		return Tickets.of(tickets);
	}
}

package lottery;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StoreTest {

	private Store sut;
	private Buyer buyer;

	@BeforeEach
	void setUp() {
		sut = new Store();
		buyer = Buyer.of(Money.won(10000L));
	}

	@Test
	void 자동티켓_머신을_가진다() {
		assertThat(sut.getMachine()).isNotNull();
	}


	@Test
	void 티켓을_판매한다() {
		List<Ticket> tickets = sut.getTicket(buyer);
		assertThat(tickets).isNotEmpty();
		assertThat(tickets).hasSize(10);
	}
}

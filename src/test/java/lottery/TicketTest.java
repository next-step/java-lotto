package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import lottery.exceptions.InvalidTicketSizeException;

class TicketTest {

	Ticket sut;

	@Test
	void create() {
		assertThatThrownBy(() -> Ticket.of(LottoNumbers.from(new LinkedHashSet<>()), TicketType.MANUAL))
			.isInstanceOf(InvalidTicketSizeException.class);

		LottoNumbers lottoNumbers = LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6));

		sut = Ticket.of(lottoNumbers, TicketType.MANUAL);

		assertThat(sut.numbers()).hasSize(6);

	}
}

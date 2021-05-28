package lottery;

import static lottery.fixture.Const.*;
import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;

import org.junit.jupiter.api.Test;

import lottery.exceptions.InvalidTicketSizeException;

class TicketTest {

	Ticket sut;
	@Test
	void create() {
		assertThatThrownBy(() -> Ticket.of(LottoNumbers.from(new LinkedHashSet<>()), TicketType.MANUAL))
			.isInstanceOf(InvalidTicketSizeException.class);

		LottoNumbers lottoNumbers = LottoNumbers.from(로또번호_1_2_3_4_5_6);

		sut = Ticket.of(lottoNumbers, TicketType.MANUAL);

		assertThat(sut.numbers()).hasSize(6);

	}
}

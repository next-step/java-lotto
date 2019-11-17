package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

	@Test
	void 생성자() {
		assertThat(new LottoTicket().getTicketNumbers().size())
				.isEqualTo(6);
	}
}
package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest {

	@Test
	void 생성자() {
		assertThat(new LottoTickets(5)
				.getLottoTickets().size()).isEqualTo(5);

	}
}
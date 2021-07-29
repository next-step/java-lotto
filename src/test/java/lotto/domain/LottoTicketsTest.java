package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

	@DisplayName("구매한 로또 티켓을 포장하는 LottoTickets 객체를 생성한다.")
	@Test
	void create() {
		List<LottoTicket> lottoTickets = createLottoTickets();
		LottoTickets tickets = LottoTickets.from(lottoTickets);
		assertThat(tickets.getTickets()).hasSize(lottoTickets.size());
	}

	private List<LottoTicket> createLottoTickets() {
		return Arrays.asList(
				LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
				LottoTicket.from(Arrays.asList(7, 8, 9, 10, 11, 12))
		);
	}

}

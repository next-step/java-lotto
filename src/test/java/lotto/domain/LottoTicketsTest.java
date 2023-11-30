package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketsTest {

	@DisplayName("로또 티켓이 수량만큼 생성된다.")
	@ParameterizedTest
	@ValueSource(ints = {2})
	void create_ticket_in_quantity(int quantity) {
		LottoTickets lottoTickets = new LottoTickets(
			List.of(
				new LottoTicket(1, 2, 3, 4, 5, 6),
				new LottoTicket(2, 3, 4, 5, 6, 7)
			)
		);
		assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(quantity);
	}

	@Test
	@DisplayName("로또를 검사한다.")
	void valid_tickets() {
		LottoTickets lottoTickets = new LottoTickets(List.of(new LottoTicket(1, 2, 3, 4, 5, 6)));
		LottoChecker lottoChecker = new LottoChecker(1, 2, 3, 4, 5, 6, 7);
		List<Rank> ranks = lottoTickets.checkTickets(lottoChecker);
		assertThat(ranks.get(0)).isEqualTo(Rank.SECOND);
	}
}



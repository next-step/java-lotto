package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.strategy.AutoGenerateStrategy;
import lotto.domain.strategy.GenerateStrategy;
import lotto.domain.strategy.ManualGenerateStrategy;

public class LottoTicketsTest {

	@DisplayName("로또 티켓이 수량만큼 생성된다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})
	void create_ticket_in_quantity(int quantity) {
		GenerateStrategy strategy = new AutoGenerateStrategy();
		LottoTickets lottoTickets = new LottoTickets(quantity, strategy);
		assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(quantity);
	}

	@Test
	@DisplayName("로또를 검사한다.")
	void valid_tickets() {
		GenerateStrategy strategy = new ManualGenerateStrategy(1, 2, 3, 4, 5, 6);
		LottoTickets lottoTickets = new LottoTickets(1, strategy);
		LottoChecker lottoChecker = new LottoChecker(1, 2, 3, 4, 5, 6, 7);
		List<Rank> ranks = lottoTickets.checkTickets(lottoChecker);
		assertThat(ranks.get(0)).isEqualTo(Rank.SECOND);
	}
}



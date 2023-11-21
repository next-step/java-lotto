package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.strategy.AutoGenerateStrategy;
import lotto.domain.strategy.GenerateStrategy;

public class LottoTicketsTest {

	@DisplayName("로또 티켓이 수량만큼 생성된다.")
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4})
	void create_ticket_in_quantity(int quantity) {
		GenerateStrategy strategy = new AutoGenerateStrategy();
		LottoTickets lottoTickets = new LottoTickets(quantity, strategy);
		Assertions.assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(quantity);
	}
}

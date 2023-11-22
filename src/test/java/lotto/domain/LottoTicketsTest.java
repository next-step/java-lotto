package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
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

	// 리팩토링 예정
	@Test
	@DisplayName("로또를 검사한다.")
	void valid_tickets() {
		GenerateStrategy strategy = new ManualGenerateStrategy(1,2,3,4,5,6);
		LottoTickets lottoTickets = new LottoTickets(1, strategy);
		LottoValidator lottoValidator = new LottoValidator(1,2,3,7,8,9);
		EnumMap<Rank, Integer> map = lottoTickets.validTicket(lottoValidator);
		assertThat(map.get(Rank.FOURTH)).isEqualTo(1);
	}

	// 리팩토링 예정
	@Test
	@DisplayName("로또 수익률을 계산한다.")
	void calc_return_rate() {
		GenerateStrategy strategy = new ManualGenerateStrategy(1,2,3,4,8,9);
		LottoTickets lottoTickets = new LottoTickets(5, strategy);
		lottoTickets.validTicket(new LottoValidator(1,2,3,4,5,6));
		assertThat(lottoTickets.calcReturnRate(5000)).isEqualTo(2000.0);
	}
}

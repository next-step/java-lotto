package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTicketTest {

	@DisplayName("로또 티켓의 숫자가 지정한 숫자와 같지 않다면 IllegalArgumentException을 던진다.")
	@Test
	void throw_IllegalArgumentException_when_lotto_ticket_numbers_ne_count() {
		GenerateStrategy generateStrategy = () -> Set.of(1,2,3,4,5);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoTicket(generateStrategy));
	}

	@DisplayName("로또 티켓의 숫자중 중복된 값이 있다면 IllegalArgumentException을 던진다.")
	@Test
	void throw_IllegalArgumentException_when_lotto_ticket_numbers_duplicate() {
		GenerateStrategy generateStrategy = () -> Set.of(1,2,3,4,5,5);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoTicket(generateStrategy));
	}
}

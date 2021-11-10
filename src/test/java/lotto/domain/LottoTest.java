package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.generator.FixedGenerator;
import lotto.generator.Generator;

class LottoTest {
	@DisplayName("Lotto 생성을 검증한다.")
	@Test
	void create() {
		// given
		Generator generator = new FixedGenerator();
		int numberOfPurchases = 10;

		// when
		Lotto lotto = Lotto.create(generator, numberOfPurchases);

		// then
		assertThat(lotto).isEqualTo(new Lotto(Tickets.create(generator, numberOfPurchases)));
	}

	@DisplayName("생성된 Lotto 로 부터 Statistics 생성을 검증한다.")
	@Test
	void createStatistics() {
		// given
		Generator generator = new FixedGenerator();
		int numberOfPurchases = 10;

		Lotto lotto = Lotto.create(generator, numberOfPurchases);
		Ticket winningNumberTicket = Ticket.create(FixedGenerator.FIXED_NUMBERS);

		// when
		Statistics statistics = lotto.createStatistics(winningNumberTicket);

		// then
		assertThat(statistics).isEqualTo(
			new Statistics(Tickets.create(generator, numberOfPurchases), winningNumberTicket));
	}
}

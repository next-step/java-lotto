package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.generator.FixedGenerator;
import lotto.generator.Generator;

class LottoTest {
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
			Statistics.create(Tickets.create(generator, numberOfPurchases), winningNumberTicket));
	}

	@DisplayName("Lotto getTickets() 호출후 컬렉션 수정시 예외를 던진다.")
	@Test
	void getValues() {
		// given
		Generator generator = new FixedGenerator();
		int numberOfPurchases = 10;

		Lotto lotto = Lotto.create(generator, numberOfPurchases);

		// when
		List<Ticket> values = lotto.getTickets();

		// then
		assertThatExceptionOfType(UnsupportedOperationException.class)
			.isThrownBy(() -> values.remove(0));
	}
}

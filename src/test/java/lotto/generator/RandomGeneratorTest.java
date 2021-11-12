package lotto.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;
import lotto.domain.Ticket;

class RandomGeneratorTest {
	@DisplayName("generate 된 리스트 size 를 검증한다.")
	@Test
	void generate() {
		// given
		Generator generator = new RandomGenerator();

		// when
		List<LottoNumber> values = generator.generate();

		// then
		assertThat(values).hasSize(Ticket.SIZE_OF_LOTTO_TICKET);
	}
}

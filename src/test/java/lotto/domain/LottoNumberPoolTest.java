package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberPoolTest {

	@DisplayName("로또 티켓 생성 테스트")
	@Test
	void generate() {
		// when
		LottoTicket lottoTicket = LottoNumberPool.generate();

		// then
		assertThat(lottoTicket).isNotNull();
	}

}

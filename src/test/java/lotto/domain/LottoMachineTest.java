package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

	@DisplayName("로또 개수만큼 로또 티켓 생성 테스트")
	@Test
	void generate() {
		// given
		int count = 10;
		LottoMachine lottoMachine = new LottoMachine();

		// when
		List<LottoTicket> lottoTickets = lottoMachine.generate(count);

		// then
		assertThat(lottoTickets.size()).isEqualTo(count);
	}

}

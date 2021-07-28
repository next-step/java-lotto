package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

	@DisplayName("로또 1장은 무작위의 번호 6개를 갖는다.")
	@Test
	void create() {
		LottoMachine lottoMachine = new LottoMachine();
		LottoTicket lottoTicket = new LottoTicket(lottoMachine.pickRandomNumbers());
		assertThat(lottoTicket.getNumbers()).hasSize(6).doesNotHaveDuplicates();
	}

}
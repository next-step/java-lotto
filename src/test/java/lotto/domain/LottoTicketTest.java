package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
	@DisplayName("로또 티켓 생성 테스트")
	@Test
	public void lottoTicketGenerateTest() {
		int expected = 6;
		LottoTicket lottoTicket = new LottoTicket(6, new LottoNumberGenerator());
		int actual = lottoTicket.getLottoTicket().size();
		assertThat(expected).isEqualTo(actual);
	}
}
package lotto.store;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketTest {

	@Test
	@DisplayName(value = "구매한 가격 만큼의 로또를 생산하여 ticket 으로 제공한다")
	void ticket() {
		LottoStore lottoStore = new LottoStore(20000, 1000);
		Ticket ticket = lottoStore.produceLotto();
		assertThat(ticket.purchaseCount()).isEqualTo(20);
	}
}

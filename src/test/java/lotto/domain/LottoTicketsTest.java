package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class LottoTicketsTest {

	@DisplayName("1. 구입 금액에 해당하는 로또 티켓이 발급된다.")
	@Test
	void buyTicket() {
		int cash = 5000;
		LottoTickets lottoTickets = new LottoTickets(cash);
		assertThat(lottoTickets.getTicketCount()).isEqualTo(5);
	}
}

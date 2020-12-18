package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

	@DisplayName("2. 자동 로또 티켓과 수동 로또 티켓이 발급된다.")
	@Test
	void buyTicket22() {
		int cash = 5000;

		List<LottoTicket> customTicket3 = Arrays.asList(new LottoTicket(Arrays.asList(new LottoNumber(1),
			new LottoNumber(2),
			new LottoNumber(3),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(6)
		)));

		LottoTickets lottoTickets = new LottoTickets(cash);
		assertThat(lottoTickets.getTicketCount()).isEqualTo(5);
	}
}

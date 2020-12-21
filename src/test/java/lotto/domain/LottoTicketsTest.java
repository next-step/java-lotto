package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.lottoTicketsStrategy.AutoLottoTicketsStrategy;
import lotto.domain.lottoTicketsStrategy.LottoTicketsStrategy;
import lotto.domain.lottoTicketsStrategy.ManualLottoTicketsStrategy;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class LottoTicketsTest {

	@DisplayName("1. 구입 금액에 해당하는 자동 로또 티켓이 발급된다.")
	@Test
	void buyAutoTicket() {
		int cash = 5000;
		List<String> manualNumbers = new ArrayList<>();
		BuyInfo buyInfo = new BuyInfo(cash, manualNumbers);

		LottoTicketsStrategy lottoTicketsStrategy = new AutoLottoTicketsStrategy();
		LottoTickets lottoTickets = lottoTicketsStrategy.play(buyInfo);
		assertThat(lottoTickets.getTicketCount()).isEqualTo(5);
	}

	@DisplayName("2. 구입 금액에 해당하는 수동 로또 티켓이 발급된다.")
	@Test
	void buyManualTicket() {
		int cash = 1000;
		List<String> manualNumbers = Arrays.asList("1,2,3,4,5,6");
		BuyInfo buyInfo = new BuyInfo(cash, manualNumbers);

		LottoTicketsStrategy lottoTicketsStrategy = new ManualLottoTicketsStrategy();
		LottoTickets lottoTickets = lottoTicketsStrategy.play(buyInfo);

		assertThat(lottoTickets.getTicketCount()).isEqualTo(1);
	}

	@DisplayName("3. 구입 금액에 해당하는 자동, 수동 로또 티켓이 발급된다.")
	@Test
	void buyManualAndAutoTicket() {
		int cash = 3000;
		List<String> manualNumbers = Arrays.asList("1,2,3,4,5,6", "11,12,13,14,15,16");
		BuyInfo buyInfo = new BuyInfo(cash, manualNumbers);

		LottoTicketsStrategy manualLottoTicketsStrategy = new ManualLottoTicketsStrategy();
		LottoTicketsStrategy autoLottoTicketsStrategy = new AutoLottoTicketsStrategy();

		LottoTickets manualLottoTickets = manualLottoTicketsStrategy.play(buyInfo);
		LottoTickets autoLottoTickets = autoLottoTicketsStrategy.play(buyInfo);

		assertThat(manualLottoTickets.getTicketCount()).isEqualTo(2);
		assertThat(autoLottoTickets.getTicketCount()).isEqualTo(1);
	}
}

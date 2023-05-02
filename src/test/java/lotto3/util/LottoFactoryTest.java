package lotto3.util;

import static org.assertj.core.api.Assertions.*;

import lotto3.domain.LottoTicket;
import lotto3.domain.LottoTickets;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

  @Test
  void 투자금액_5000원_로또_5장발급_검증() {
    int investMoney = 5000;
    int expectedNumberOfTickets = investMoney / LottoTicket.TICKET_PRICE;

    LottoTickets lottoTickets = LottoFactory.createLottoTickets(investMoney);
    int actualNumberOfTickets = lottoTickets.size();

    assertThat(actualNumberOfTickets).isEqualTo(expectedNumberOfTickets);
  }
}
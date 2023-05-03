package lotto3.util;

import static org.assertj.core.api.Assertions.*;

import lotto3.domain.LottoTicket;
import lotto3.domain.LottoTickets;
import lotto3.domain.Money;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

  @Test
  void 투자금액_5000원_로또_5장발급_검증() {
    Money investMoney = new Money(5000);
    int expectedNumberOfTickets = 5;

    LottoTickets lottoTickets = LottoFactory.createLottoTickets(investMoney);
    int actualNumberOfTickets = lottoTickets.size();

    assertThat(actualNumberOfTickets).isEqualTo(expectedNumberOfTickets);
  }
}
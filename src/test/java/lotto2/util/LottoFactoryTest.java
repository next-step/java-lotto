package lotto2.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoFactoryTest {

  @Test
  void 투자한_금액에_맞는_로또티켓_반환_검증() {
    int investMoney = 14000;
    int expected = 14;
    int actual = LottoFactory.createLottoTickets(investMoney).size();

    assertThat(actual).isEqualTo(expected);
  }

}
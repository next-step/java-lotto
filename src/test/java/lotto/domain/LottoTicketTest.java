package lotto.domain;

import lotto.function.SixLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

  @Test
  @DisplayName("지급한 돈에 맞게 로또를 생성한다.")
  void toBuy() {
    // given
    int money = 2_000;

    // when
    LottoTicket lotto = LottoTicket.toBuy(money, new SixLottoNumbers());

    // then
    assertThat(lotto.ticketCount())
            .isEqualTo(2);
  }
}
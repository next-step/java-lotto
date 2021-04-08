package lotto.domain;

import lotto.function.SixLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketTest {

  @Test
  @DisplayName("지급한 돈에 맞게 로또를 생성한다.")
  void toBuy() {
    // given
    int money = 2_000;

    // when
    LottoTicket lotto = LottoTicket.toBuy(money, new SixLottoNumbers());

    // then
    assertAll(() -> assertThat(lotto.ticketCount()).isEqualTo(2)
            , () -> assertThat(lotto.getList().get(0))
                    .isNotEqualTo(lotto.getList().get(1)));
  }
}
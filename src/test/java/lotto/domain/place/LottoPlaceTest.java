package lotto.domain.place;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPlaceTest {

  @Test
  @DisplayName("로또가 당첨되면 해당 등수에 맞게 금액을 반환한다.")
  void win() {
    // given
    LottoPlace first = LottoFirstPlace.create();

    // when
    first = first.win().win();

    // then
    assertThat(first.getTotalMoney())
            .isEqualTo(first.getWinMoney() * 2);
  }
}
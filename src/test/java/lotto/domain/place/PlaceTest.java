package lotto.domain.place;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlaceTest {

  @Test
  @DisplayName("로또가 당첨되면 해당 등수에 맞게 금액을 반환한다.")
  void win() {
    // given
    Place first = FirstPlace.create();

    // when
    first = first.win().win();

    // then
    assertThat(first.getTotalWinningMoney())
            .isEqualTo(first.getWinningMoney() * 2);
  }
}
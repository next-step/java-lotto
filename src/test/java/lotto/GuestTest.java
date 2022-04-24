package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuestTest {

  @Test
  @DisplayName("손님이 얼마나 가지고 있는지 테스트한다.")
  void haveMoney() {
    Guest guest = new Guest(14000);
    assertThat(guest).isEqualTo(new Guest(14000));
  }

  @Test
  @DisplayName("로또를 가격에 맞게 구입을 하였는지 체크한다.")
  void buy() {
    Guest guest = new Guest(14000);
    assertThat(guest.boughtLottoCount()).isEqualTo(14);
  }
}

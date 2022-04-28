package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuestTest {

  @Test
  @DisplayName("고객은 상품을 선택한다.")
  void choiceProduct() {
    Guest guest = new Guest(14000);
    guest = guest.choiceProduct(new Store());
    assertThat(guest).isEqualTo(new Guest(0, guest.hasAllLotto()));
  }
  @Test
  @DisplayName("고객이 구입한 로또 갯수 테스트")
  void lottoCountTest() {
    Guest guest = new Guest(14000);
    guest = guest.choiceProduct(new Store());
    assertThat(guest.hasAllLotto()).hasSize(14);
  }

}

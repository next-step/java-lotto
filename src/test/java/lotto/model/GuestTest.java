package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.LottoSizeException;
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
    assertThat(guest).isEqualTo(new Guest(0, guest.hasAllLotto()));
  }

  @Test
  @DisplayName("1000원이하의 돈으로 로또를 구입 할 수 없습니다.")
  void lottoEmptySizeTest() {
    assertThrows(LottoSizeException.class, () -> {
      Guest guest = new Guest(999);
      guest = guest.choiceProduct(new Store());
      assertThat(guest).isEqualTo(new Guest(0, guest.hasAllLotto()));
    });
  }

}

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
    List<Product> products = guest.choiceProduct(new Store());
    assertThat(products).hasSize(14);
  }
}

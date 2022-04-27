package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Guest;
import lotto.model.Product;
import lotto.model.Store;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuestTest {

  @Test
  @DisplayName("상점에 방문하는 고객 테스트")
  void visit() {
    Guest guest = new Guest(14000);
    assertThat(guest.visit(new Store())).isEqualTo(true);
  }
}
